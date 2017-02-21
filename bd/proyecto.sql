-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 21-02-2017 a las 12:31:31
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre`) VALUES
(1, 'cat1'),
(2, 'cat2'),
(3, 'cat3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `nif` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `poblacion` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `provincia` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `codigopostal` varchar(5) COLLATE latin1_spanish_ci DEFAULT NULL,
  `telefono` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `apellidos`, `nif`, `direccion`, `poblacion`, `provincia`, `codigopostal`, `telefono`) VALUES
(1, 'Fabio', 'Perez Golderos', '48413175S', '525', 'La Cañada', 'Valencia', '46182', '628786053'),
(2, 'Pepito', 'Garcia', '123123', 'asd', 'asd', 'asd', '123', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE IF NOT EXISTS `facturas` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `total` float(11,2) NOT NULL,
  `cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `cliente_idx` (`cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`id_factura`, `fecha`, `total`, `cliente`) VALUES
(1, '01/02/2017', 500.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineas_pedido`
--

CREATE TABLE IF NOT EXISTS `lineas_pedido` (
  `id_lineas_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `pedido` int(11) NOT NULL,
  `articulo` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT '1',
  `precio` float(11,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id_lineas_pedido`),
  KEY `pedido_idx` (`pedido`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `lineas_pedido`
--

INSERT INTO `lineas_pedido` (`id_lineas_pedido`, `pedido`, `articulo`, `cantidad`, `precio`) VALUES
(1, 1, 'Art1', 1, 15.00),
(2, 2, 'Art2', 2, 20.00),
(3, 1, 'Aer3', 1, 55.00),
(4, 1, 'Art4', 2, 70.00),
(5, 2, 'Art5', 3, 80.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE IF NOT EXISTS `pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `estado` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id_pedido`, `descripcion`, `estado`) VALUES
(1, 'Prueba 1', 0),
(2, 'Prueba 2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `precio` float(11,2) NOT NULL,
  `categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `categoria_idx` (`categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `precio`, `categoria`) VALUES
(1, 'prod1', 10.00, 1),
(2, 'prod2', 10.00, 1),
(3, 'prod3', 5.00, 2),
(4, 'prod4', 15.00, 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `cliente` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `lineas_pedido`
--
ALTER TABLE `lineas_pedido`
  ADD CONSTRAINT `pedido` FOREIGN KEY (`pedido`) REFERENCES `pedidos` (`id_pedido`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `categoria` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
