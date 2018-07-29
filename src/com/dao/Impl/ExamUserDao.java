package com.dao.Impl;

import java.lang.reflect.ParameterizedType;

import com.entity.ExamUser;

public class ExamUserDao extends BaseDaoImpl<ExamUser> {
	@SuppressWarnings("unused")
	private Class<?> EntityClass;
	public ExamUserDao() {

        ParameterizedType type = (ParameterizedType) getClass()
                .getGenericSuperclass();
        EntityClass = (Class<?>) type.getActualTypeArguments()[0];
    }
}
