package com.fpmislata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LineaPedido.class)
public abstract class LineaPedido_ {

	public static volatile SingularAttribute<LineaPedido, Float> precio;
	public static volatile SingularAttribute<LineaPedido, Pedido> pedido;
	public static volatile SingularAttribute<LineaPedido, Integer> id;
	public static volatile SingularAttribute<LineaPedido, String> producto;
	public static volatile SingularAttribute<LineaPedido, Integer> cantidad;

}

