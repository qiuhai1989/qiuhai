package aty.log.service;

import org.apache.log4j.Logger;

public class A {
	 private static Logger logger = Logger.getLogger(A.class);  
	 public void run() {  
	        logger.error("log in A.java");  
	    }  
}
