/**
 * 
 */
package com.sheraz.tutorial.lti.producer.tool.validator;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.sheraz.tutorial.lti.producer.tool.Constants;

/**
 * @author Sheraz Ahmed
 *
 */
@Component
public class LTIParametersValidator {

	public String validate(Map<String, String> paramsMap) {
		// "resource_link_id"
		if (paramsMap.get(Constants.PARAM_RESOURCE_LINK_ID) == null) {
			return Constants.MSG_NO_RESOURCE_LINK_ID_PROVIDED;
		}

		// "lti_version"
		if (paramsMap.get(Constants.PARAM_LTI_VERSION) == null) {
			return Constants.MSG_NO_LTI_VERSION_PROVIDED;
		}

		// "lti_version"
		// "LTI-1p0"
		if (!paramsMap.get(Constants.PARAM_LTI_VERSION).equals(Constants.LTI_VERSION_VALUE_1P0)) {
			return Constants.MSG_INVALID_LTI_VERSION_PROVIDED;
		}

		// "lti_message_type"
		if (paramsMap.get(Constants.PARAM_LTI_MESSAGE_TYPE) == null) {
			return Constants.MSG_NO_LTI_MESSAGE_TYPE_PROVIDED;
		}

		// "lti_message_type"
		// "basic-lti-launch-request"
		if (!paramsMap.get(Constants.PARAM_LTI_MESSAGE_TYPE).equals(Constants.LTI_MESSAGE_TYPE_VALUE_BASIC_LTI_LAUNCH_REQ)) {
			return Constants.MSG_INVALID_LTI_MESSAGE_TYPE_PROVIDED;
		}

		// "lis_person_name_given"
		// "lis_person_contact_email_primary"
		if (paramsMap.get(Constants.PARAM_LIS_PERSON_GIVEN_NAME) == null
				&& paramsMap.get(Constants.PARAM_LIS_PERSON_CONTACT_EMAIL_PRIMARY) != null) {
			return Constants.MSG_EMAIL_PROVIDED_NAME_NOT_PROVIDED;
		}

		// "lis_person_name_given"
		// "lis_person_name_family"
		// "lis_person_name_full"
		if (paramsMap.get(Constants.PARAM_LIS_PERSON_GIVEN_NAME) != null
				&& paramsMap.get(Constants.PARAM_LIS_PERSON_NAME_FAMILY) != null
				&& paramsMap.get(Constants.PARAM_LIS_PERSON_NAME_FULL) == null) {
			return Constants.MSG_FULL_NAME_NOT_PROVIDED;
		}
		return null;
	}

}
