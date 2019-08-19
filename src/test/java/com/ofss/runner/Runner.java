package com.ofss.runner;

import org.apache.log4j.Logger;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import pages.BasePage;
import utils.Listeners.*;

public class Runner {
	private static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws ClassNotFoundException {
		BasePage.intiateLoggers(args[0]);
		TestListenerAdapter testlisteneradapter = new TestListenerAdapter();
		TestListener testlistener = new TestListener();
		AnnotationTransformer annotationtransformer = new AnnotationTransformer();
		TestNG testng = new TestNG();

		Class[] setofClasses = new Class[args.length];
		LOGGER.info(" List of tests to be invoked are :");
		
		for (int i = 0; i < args.length; i++) {
			setofClasses[i] = Class.forName("configList." + args[i] + "Test");
			LOGGER.info(args[i] );
		}
		testng.setTestClasses(setofClasses);
		testng.addListener(testlisteneradapter);
		testng.addListener(testlistener);
		testng.addListener(annotationtransformer);
		testng.run();
	}
}
