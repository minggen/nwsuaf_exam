package com.dao.Impl;

import java.lang.reflect.ParameterizedType;

import com.entity.ExamInformation;

public class ExamInformationDao extends BaseDaoImpl<ExamInformation> {
	@SuppressWarnings("unused")
	private Class<?> EntityClass;
	public ExamInformationDao() {

        ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();
        EntityClass = (Class<?>) type.getActualTypeArguments()[0];
    }
	
}
