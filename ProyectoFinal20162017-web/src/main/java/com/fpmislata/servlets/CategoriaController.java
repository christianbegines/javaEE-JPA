/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Categoria;
import com.fpmislata.service.CategoriaServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lodiade
 */
@WebServlet(name = "CategoriaController",
        loadOnStartup = 1,
        urlPatterns = {"/ListarCategorias",
            "/AddCategoria",
            "/DeleteCategoria",
            "/UpdateCategoria"})
public class CategoriaController extends HttpServlet {

    @EJB
    private CategoriaServiceLocal categoriaService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        // Si la operacion es listar personas
        if (userPath.equals("/ListarCategorias")) {
            listarCategorias(request, response);
            // Si la operacion es Alta Categoria
        } else if (userPath.equals("/AddCategoria")) {
            altaCategoria(request, response);
            // Si la operacion es Eliminar Categoria
        } else if (userPath.equals("/DeleteCategoria")) {
            eliminarCategoria(request, response);
            // Si la operacion es Modificar Categoria
        } else if (userPath.equals("/UpdateCategoria")) {
            modificarCategoria(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response) {
        try {
            List lista = categoriaService.listCategorias();
            ArrayList<Categoria> listCat = new ArrayList<>(lista);
            request.getSession().setAttribute("listaCategorias", listCat);
            RequestDispatcher rd
                    = request.getRequestDispatcher("/listarCategorias.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void altaCategoria(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("nombre");
        Categoria c = new Categoria(nombre);
        try {
            categoriaService.addCategoria(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listarCategorias(request, response);
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Categoria c = new Categoria();
        c.setId(id);
        try {
            this.categoriaService.deleteCategoria(c);
            List lista = categoriaService.listCategorias();
            ArrayList<Categoria> listaArray = new ArrayList<>(lista);
            request.getSession().setAttribute("listaCategorias", listaArray);
            RequestDispatcher rd = request.getRequestDispatcher("/listarCategorias.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modificarCategoria(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        if (accion != null && accion.equals("editar")) {
            String idPersona = request.getParameter("id");
            if (idPersona != null) {
                Categoria c = new Categoria();
                int id = Integer.parseInt(request.getParameter("id"));
                c.setId(id);
                try {
                    c = categoriaService.findCategoriaById(c);
                    request.setAttribute("categoria", c);
                    request.getRequestDispatcher("/persona.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (accion != null && accion.equals("modificar")) {
            String nombre = request.getParameter("nombre");
            int id = Integer.valueOf(request.getParameter("id"));
            Categoria c = new Categoria();
            c.setNombre(nombre);
            c.setId(id);
            try {
                this.categoriaService.updateCategoria(c);
                List lista = categoriaService.listCategorias();
                ArrayList<Categoria> listaArray = new ArrayList<>(lista);
                request.getSession().setAttribute("listaCategorias", listaArray);
                request.getRequestDispatcher("/listarCategorias.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
