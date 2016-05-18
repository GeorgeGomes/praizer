package com.seismaismais.praizer.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praizer.dao.SlideDao;
import com.seismaismais.praizer.model.Slide;

@Repository("slideDao")
public class SlideDaoImpl implements SlideDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public SlideDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Slide> list() {
		List<Slide> list = null;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(Slide.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public Slide findById(Long id) {
		Slide slide = null;
		try {
			slide = sessionFactory.getCurrentSession().get(Slide.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slide;
	}

	@Transactional
	@Override
	public void delete(Slide u) {
		try {
			sessionFactory.getCurrentSession().delete(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(Slide u) {
		try {
			sessionFactory.getCurrentSession().save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void update(Slide u) {
		try {
			sessionFactory.getCurrentSession().update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}