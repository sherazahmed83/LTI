package com.sheraz.tutorial.lti.producer.tool.util;

/**
 * @author Sheraz Ahmed
 *
 */

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static Map<String, String> getRequestParametersMap(HttpServletRequest request) {
		HashMap<String, String> params = new HashMap<>();
		
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			for (String paramValue : paramValues) {
				params.put(paramName, paramValue);
			}
		}
		
		return params;
	}

}
