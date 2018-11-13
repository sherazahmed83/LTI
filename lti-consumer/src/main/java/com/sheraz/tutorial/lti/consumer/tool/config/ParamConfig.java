package com.sheraz.tutorial.lti.consumer.tool.config;

public class ParamConfig {

	ParamConfig() {
		super();
	}

	public static final String OAUTH_CONSUMER_KEY = "consumerKey";
	public static final String TOOL_CONSUMER_URL = "http://localhost:8085";
	public static final String TOOL_PRODUCER_URL = "http://localhost:8086/ltiProducer";
	public static final String SHARED_SECRET = "sheraz's-secret-key";
	public static final boolean GET_GRADES_FROM_TOOL = true;
}
