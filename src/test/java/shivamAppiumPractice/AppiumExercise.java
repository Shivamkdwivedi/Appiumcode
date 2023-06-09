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



public class AppiumExercise extends BaseTestClass {
	
	@Test
	public void Exercise() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(By.id("android:id/button1")).click();
		String clikable=driver.findElement(By.xpath("(//android.widget.Button)[2]")).getText();
		Assert.assertEquals(clikable, "OK CANCEL DIALOG WITH A LONG MESSAGE");
		
	}
}
