package com.fpmislata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, Float> precio;
	public static volatile SingularAttribute<Producto, Categoria> categoria;
	public static volatile SingularAttribute<Producto, Integer> id;
	public static volatile SingularAttribute<Producto, String> nombre;

}

