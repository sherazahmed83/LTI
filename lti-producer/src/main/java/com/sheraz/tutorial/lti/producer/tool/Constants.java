/**
 * 
 */
package com.sheraz.tutorial.lti.producer.tool;

/**
 * @author Sheraz Ahmed
 *
 */
public class Constants {

	public static final String ERROR = "error";
	public static final String ERROR_VIEW = ERROR;
	public static final String HOME_VIEW = "home";

	// LTI Request Required Parameters
	public static final String PARAM_RESOURCE_LINK_ID = "resource_link_id";
	public static final String PARAM_LTI_VERSION = "lti_version";
	public static final String PARAM_LTI_MESSAGE_TYPE = "lti_message_type";
	public static final String PARAM_LIS_PERSON_GIVEN_NAME = "lis_person_name_given";
	public static final String PARAM_LIS_PERSON_CONTACT_EMAIL_PRIMARY = "lis_person_contact_email_primary";
	public static final String PARAM_LIS_PERSON_NAME_FAMILY = "lis_person_name_family";
	public static final String PARAM_LIS_PERSON_NAME_FULL = "lis_person_name_full";

	// LTI Request Some Required Values
	public static final String LTI_VERSION_VALUE_1P0 = "LTI-1p0";
	public static final String LTI_MESSAGE_TYPE_VALUE_BASIC_LTI_LAUNCH_REQ = "basic-lti-launch-request";

	// LTI Request Validation Messages
	public static final String MSG_NO_RESOURCE_LINK_ID_PROVIDED = "No `resource_link_id` provided.";
	public static final String MSG_NO_LTI_VERSION_PROVIDED = "No `lti_version` provided.";
	public static final String MSG_INVALID_LTI_VERSION_PROVIDED = "Invalid LTI Version provided.";
	public static final String MSG_NO_LTI_MESSAGE_TYPE_PROVIDED = "No `lti_message_type` provided.";
	public static final String MSG_INVALID_LTI_MESSAGE_TYPE_PROVIDED = "Invalid LTI Message Type provided.";
	public static final String MSG_EMAIL_PROVIDED_NAME_NOT_PROVIDED = "Email provided but name not provided";
	public static final String MSG_FULL_NAME_NOT_PROVIDED = "Full name not provided; given & family names provided";

	// LTI Signature Validation Parameters
	public static final String PARAM_OAUTH_CONSUMER_KEY = "oauth_consumer_key";

	// LTI Signature Validation Messages
	public static final String MSG_INVALID_CONSUMER_KEY = "Invalid Consumer Key";
	public static final String MSG_OAUTH_SIGNATURE_VERIFICATION_FAILED = "OAuth Signature Verification Failed";

	// LTI Outcome Callback Parameters 
	public static final String PARAM_LIS_OUTCOME_SERVICE_URL = "lis_outcome_service_url";
	
	// MODEL Outcome Callback Parameters
	public static final String MODEL_PARAM_CONSUMER_URL = "consumerUrl";
	public static final String MODEL_PARAM_CONSUMER_URL_EXISTS = "consumerUrlExists";
}
