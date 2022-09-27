package com.test.GenericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	ExtentReports reports;
	ExtentTest test;

	public  void report() {
	ExtentSparkReporter  htmlReporter=new ExtentSparkReporter(IPathConstant.htmlPath);
	
	htmlReporter.config().setDocumentTitle("Automation Test Store Application");
	htmlReporter.config().setReportName("RegressionTest");
	htmlReporter.config().setTheme(Theme.DARK);
	reports=new ExtentReports();
	reports.attachReporter(htmlReporter);
	reports.setSystemInfo("OS", "Windows 10");
	reports.setSystemInfo("Platform", "Windows");
	reports.setSystemInfo("Reporter Name", "Sonu Kumar");
	
	
	
}
}