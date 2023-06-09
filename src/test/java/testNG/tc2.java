package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tc2{
  @Test(dataProvider = "employeeDetail")
  public void employee(String name, int eid, String email) {
	  System.out.println("Employee Name: "+ name+" Employee id: "+ eid+ " Employee email: "+ email);
	  
  }
  
  @DataProvider
  public Object[][] employeeDetail(){
	  Object[][] data=new Object[3][3];
	  data[0][0]="Shivam";
	  data[0][1]=123;
	  data[0][2]="abc@gmail.com";
	  
	  data[1][0]="Roushan";
	  data[1][1]=345;
	  data[1][2]="cde@xyz.com";
	  
	  data[2][0]="Shivansh";
	  data[2][1]=678;
	  data[2][2]="dgc@fjg.com";
	  
	  return data;
  }
}
