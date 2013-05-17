/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.interceptor.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author SERKAN OZAL
 *         
 *         E-Mail: <a href="mailto:serkanozal86@hotmail.com">serkanozal86@hotmail.com</a>
 *         GitHub: <a>https://github.com/serkan-ozal</a>
 */
@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		if (applicationContext == null) {
			return null;
		}
		else {
			return (T)applicationContext.getBean(beanName);
		}	
	}
	
	public static <T> T getBean(Class<T> clazz) {
		if (applicationContext == null) {
			return null;
		}
		else {
			return (T)applicationContext.getBean(clazz);
		}	
	}
	
	public static Class<?> getType(String beanName) {
		if (applicationContext == null) {
			return null;
		}
		else {
			return applicationContext.getType(beanName);
		}	
	}
	
}
