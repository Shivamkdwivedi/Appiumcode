package shivamAppiumPractice;



import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;



public class AppiumScroll extends BaseTestClass {
	
	@Test
	public void ScrollView() throws MalformedURLException, InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
//		Where to scroll is known prior
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
//		Where to scroll is no prior idea
		scrollDown();
	
		
		Thread.sleep(2000);
	
	}
}
