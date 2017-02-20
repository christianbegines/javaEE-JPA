package com.fpmislata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> apellidos;
	public static volatile SetAttribute<Cliente, Proveedor> proveedores;
	public static volatile SingularAttribute<Cliente, String> codigoPostal;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile SingularAttribute<Cliente, String> nif;
	public static volatile SingularAttribute<Cliente, Integer> id;
	public static volatile SingularAttribute<Cliente, String> poblacion;
	public static volatile SingularAttribute<Cliente, String> provincia;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile SingularAttribute<Cliente, String> nombre;

}

