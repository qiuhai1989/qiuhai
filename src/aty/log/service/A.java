package aty.log.service;

import org.apache.log4j.Logger;

public class A implements Cloneable {
	 private static Logger logger = Logger.getLogger(A.class);  
	 public void run() {  
	        logger.error("log in A.java");  
	    }  
	 
	 public A(){
		System.out.println("A...");
	 };
	 
	 public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException {
		A a = (A) Class.forName(A.class.getName()).newInstance();
		A b =  (A) a.clone();
		System.out.println(a);
		System.out.println(b);
	}
	 
}
