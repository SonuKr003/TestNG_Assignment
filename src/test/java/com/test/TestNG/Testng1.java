package com.test.TestNG;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.GenericUtility.BaseClass;
import com.test.GenericUtility.FileUtility;
import com.test.POM.Registrations;

public class Testng1 {
	
	
	
	@Test
	public void inTest() throws Throwable {
		
		FileUtility ff=new FileUtility();
		
		System.out.println(ff.getDataFromJson("registrationConfim"));
		
		
		System.out.println("in tetst+==============================================TEST");
		
		String str="hello world hello";
		
		String s="hello world hello";
		
		System.out.println(str.equals(s)+"=========================================");
		
		Reporter.log(str);;
		
		Random rr=new Random();
	}

}
