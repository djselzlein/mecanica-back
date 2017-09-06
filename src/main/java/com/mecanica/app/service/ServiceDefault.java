package com.mecanica.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mecanica.app.domain.Model;

public class ServiceDefault<T extends Model, R extends JpaRepository<T, Long>> {

	@Autowired
	protected R repository;

	public T save(T entity) {
		if (entity.getId() != null) {
			return update(entity);
		}
		beforeInsert();
		repository.save(entity);
		afterInsert();
		return entity;
	}

	public T update(T entity) {
		beforeUpdate();
		repository.save(entity);
		afterUpdate();
		return entity;
	}

	public void delete(T entity) {
		beforeDelete();
		repository.delete(entity);
		afterDelete();
	}

	public void delete(Long id) {
		beforeDelete();
		repository.delete(id);
		afterDelete();
	}

	public Collection<T> findAll() {
		return repository.findAll();
	}

	public T findOne(Long id) {
		return repository.findOne(id);
	}

	protected void afterInsert() {
	}

	protected void afterUpdate() {
	}

	protected void afterDelete() {
	}

	protected void beforeInsert() {
	}

	protected void beforeUpdate() {
	}

	protected void beforeDelete() {
	}
}
