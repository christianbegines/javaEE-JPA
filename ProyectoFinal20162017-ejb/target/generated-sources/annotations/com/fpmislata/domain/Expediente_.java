package com.fpmislata.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Expediente.class)
public abstract class Expediente_ {

	public static volatile SingularAttribute<Expediente, Cliente> cliente;
	public static volatile SingularAttribute<Expediente, Timestamp> fechasubscripcion;
	public static volatile SingularAttribute<Expediente, Integer> numeroCuenta;
	public static volatile SingularAttribute<Expediente, Integer> id;

}

