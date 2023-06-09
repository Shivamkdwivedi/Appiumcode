package shivamAppiumPractice;



import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class AppiumMiscllanous extends BaseTestClass {
	
	@Test
	public void AppiumTest() throws MalformedURLException
	{
		
//		For Mac/Linux:

//adb shell dumpsys window | grep -E 'mCurrentFocus' 
//For Windows:

//adb shell dumpsys window | find "mCurrentFocus"
		
//		TO start from middle of the app
		Activity activity=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		
////		By using xpath
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
//		For Rotation
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertText=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertText, "WiFi settings");

	//		For Copy and Paste to clip board
		driver.setClipboardText("Shivam Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
//		or by using class name
		
//		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		

	}
}
