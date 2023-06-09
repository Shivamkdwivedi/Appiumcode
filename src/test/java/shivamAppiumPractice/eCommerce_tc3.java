package shivamAppiumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class eCommerce_tc3 extends BaseTestClass {
	
	@Test
	public void fillForm() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shivam Kumar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		int product=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		for(int i=0; i<product; i++) {
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Thread.sleep(2000);
		
		List<WebElement> productPrice=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int productCount=productPrice.size();
		double productSum= 0;
		for(int i=0; i<productCount; i++) {
			String amountString=productPrice.get(i).getText();
			Double price=getFormattedSum(amountString);
			productSum=productSum+price;
		}
		
		Thread.sleep(2000);
		
		String displayAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double diaplayTotal=getFormattedSum(displayAmount);
		
		Assert.assertEquals(productSum, diaplayTotal);
		
		
	
		
	}

}
