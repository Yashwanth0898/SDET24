package com.org.stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	//priority
	@Before(order =0)
	public void connectToDB()
	{
		System.out.println("database connection");
	}
	
	@Before(order =2)
	public void login()
	{
		System.out.println("perform login");
	}
	@Before(order =1)
	public void initBrowser()
	{
		System.out.println("launch browser");
	}
	@After(order =2)
	public void logout()
	{
		System.out.println("logout from application");
	}
	@After(order=1)
	public void closeBrowser()
	{
		System.out.println("close browser");
	}
	@After(order=0)
	public void closeDB()
	{
		System.out.println("close db connection");
	}

}
