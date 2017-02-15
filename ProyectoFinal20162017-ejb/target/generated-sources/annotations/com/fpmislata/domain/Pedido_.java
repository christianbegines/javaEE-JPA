package com.fpmislata.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SetAttribute<Pedido, LineaPedido> lineas;
	public static volatile SingularAttribute<Pedido, String> descripcion;
	public static volatile SingularAttribute<Pedido, Integer> estado;
	public static volatile SingularAttribute<Pedido, Integer> id;

}

