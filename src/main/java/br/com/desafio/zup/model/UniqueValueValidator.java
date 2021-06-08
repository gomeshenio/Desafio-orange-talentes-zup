package br.com.desafio.zup.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String attribute;
	private Class<?> theClass;

	@PersistenceContext
	EntityManager manager;

	@Override
	public void initialize(UniqueValue uniqueValue) {
		attribute = uniqueValue.fieldName();
		theClass = uniqueValue.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + theClass.getName() + " where " + attribute + "=:value");
		query.setParameter("value", value);

		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1,
				"Foi encontrado mais de um " + theClass + " com o atributo " + attribute + " = " + value);

		return list.isEmpty();
	}
}
