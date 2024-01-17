package com.utilities;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	
public class ExtentReport implements ITestListener{

	public static ExtentReports extent;
	public static ExtentSparkReporter sparkreporter;
    protected static ExtentTest test;

    public static void setUp() {
    	sparkreporter = new ExtentSparkReporter("C:\\Users\\srira\\RestAPI workspace\\petStoreAutomation\\reports\\report.html");
        extent = new ExtentReports();
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
    }

    public static void tearDown() {
        extent.flush();
    }
}
