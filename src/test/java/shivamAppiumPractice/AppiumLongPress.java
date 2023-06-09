package shivamAppiumPractice;



import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;



public class AppiumLongPress extends BaseTestClass {
	
	@Test
	public void LongPress() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		LongPressActions(ele);
		
		String displayText= driver.findElement(By.id("android:id/title")).getText();
		System.out.println(displayText);
		
		Assert.assertEquals(displayText, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
	}
}
