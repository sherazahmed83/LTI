/**
 * 
 */
package com.sheraz.tutorial.lti.producer.tool.validator;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.sheraz.tutorial.lti.producer.tool.Constants;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthMessage;
import net.oauth.OAuthValidator;
import net.oauth.SimpleOAuthValidator;
import net.oauth.server.OAuthServlet;

/**
 * @author Sheraz Ahmed
 *
 */
@Component
public class OAuthSignatureValidator {

	public Boolean validate(HttpServletRequest request, Map<String, String> paramsMap, Model model,
			Environment environment) {
		
		String consumerKey = paramsMap.get(Constants.PARAM_OAUTH_CONSUMER_KEY);
		Optional<String> secretKey = Optional.ofNullable(environment.getProperty(consumerKey));
		
		if (!secretKey.isPresent()) {
			model.addAttribute(Constants.ERROR, Constants.MSG_INVALID_CONSUMER_KEY);
			return false;
		}
		
		OAuthMessage oam = OAuthServlet.getMessage(request, OAuthServlet.getRequestURL(request));

		OAuthValidator oav = new SimpleOAuthValidator();
		OAuthConsumer cons = new OAuthConsumer(null, consumerKey, secretKey.get(), null);
		OAuthAccessor acc = new OAuthAccessor(cons);

		try {
			oav.validateMessage(oam, acc);
		} catch (Exception e) {
			model.addAttribute(Constants.ERROR, Constants.MSG_OAUTH_SIGNATURE_VERIFICATION_FAILED);
			return false;
		}

		return true;
	}

}
