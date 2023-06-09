package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class tc_1 {
  @Test(priority=0, invocationCount=3)
  public void login() {
	  System.out.println("You arte login page");
  }
  
  @Test(priority=1)
  public void homePage() {
	  System.out.println("you are on Home Page");
  }
  @Ignore
  @Test(priority = -1)
  public void reverseString() {
	  String s="Shivam";
	  String rev=" ";
	  for(int i=s.length()-1; i>=0; i--) {
		  rev=rev+s.charAt(i);
	  }
	  System.out.println(rev);
  }
  
  @BeforeMethod
  public void launch() {
	  System.out.println("Launch browser");
  }
  
  @BeforeClass
  public void setup() {
	  System.out.println("Setup has been done");
  }
  
  @BeforeSuite
  public void connect() {
	  System.out.println("Connected");
  }
  
  @AfterSuite
  public void disconnect() {
	  System.out.println("Disconected");
  }
  
  @AfterClass
  public void compl() {
	  System.out.println("Completed");
  }
  
  @AfterMethod
  public void tearDown() {
	  System.out.println("Close the browser");
  }
}
