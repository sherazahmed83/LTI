/**
 * 
 */
package com.sheraz.tutorial.lti.producer.tool.validator;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.sheraz.tutorial.lti.producer.tool.Constants;

/**
 * @author Sheraz Ahmed
 *
 */
@Component
public class LTIResponseCallbackValidator {

	public void validate(Map<String, String> paramsMap, Model model) {

		if (paramsMap.get(Constants.PARAM_LIS_OUTCOME_SERVICE_URL) != null) {
			String consumerUrl = paramsMap.get(Constants.PARAM_LIS_OUTCOME_SERVICE_URL);
			model.addAttribute(Constants.MODEL_PARAM_CONSUMER_URL, consumerUrl);
			model.addAttribute(Constants.MODEL_PARAM_CONSUMER_URL_EXISTS, false);

		} else {
			model.addAttribute(Constants.MODEL_PARAM_CONSUMER_URL_EXISTS, true);
		}
	}

}
