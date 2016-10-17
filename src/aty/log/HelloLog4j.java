package aty.log;

import org.apache.log4j.Logger;

import aty.log.service.A;

public class HelloLog4j {

	private static Logger logger = Logger.getLogger(HelloLog4j.class);

	public static void main(String[] args) {
		logger.debug("log in main.");
		new A().run();
	}

}
