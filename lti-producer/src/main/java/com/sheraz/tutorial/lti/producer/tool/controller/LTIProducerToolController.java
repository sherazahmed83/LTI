package com.sheraz.tutorial.lti.producer.tool.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.sheraz.tutorial.lti.producer.tool.Constants;
import com.sheraz.tutorial.lti.producer.tool.util.Utils;
import com.sheraz.tutorial.lti.producer.tool.validator.LTIParametersValidator;
import com.sheraz.tutorial.lti.producer.tool.validator.LTIResponseCallbackValidator;
import com.sheraz.tutorial.lti.producer.tool.validator.OAuthSignatureValidator;

@Controller
public class LTIProducerToolController {

	private final Environment environment;
	private LTIParametersValidator paramValidator;
	private OAuthSignatureValidator signValidator;
	private LTIResponseCallbackValidator callbackValidator;

	@Autowired
	public LTIProducerToolController(Environment environment, LTIParametersValidator paramValidator,
			OAuthSignatureValidator signValidator, LTIResponseCallbackValidator callbackValidator) {
		this.environment = environment;
		this.paramValidator = paramValidator;
		this.signValidator = signValidator;
		this.callbackValidator = callbackValidator;
	}

	@PostMapping("/ltiProducer")
	public String verifyUser(Model model, HttpServletRequest request) {
		Map<String, String> paramsMap = Utils.getRequestParametersMap(request);

		String validatedErrorMSG = paramValidator.validate(paramsMap);

		if (validatedErrorMSG != null) {
			model.addAttribute(Constants.ERROR, validatedErrorMSG);
			return Constants.ERROR_VIEW;
		}

		if (signValidator.validate(request, paramsMap, model, environment)) {
			callbackValidator.validate(paramsMap, model);
			return Constants.HOME_VIEW;
		}

		return Constants.ERROR_VIEW;
	}

}
