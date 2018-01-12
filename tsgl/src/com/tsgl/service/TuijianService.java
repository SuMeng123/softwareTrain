package com.tsgl.service;

import java.util.List;

import org.hibernate.validator.util.privilegedactions.GetAnnotationParameter;

import com.tsgl.entity.Tuijian;

public interface TuijianService {
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Tuijian> geTuijians(String name);

}
