package shivamAppiumPractice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException 
	{
		
//		URL url = new URL(Common.getProperty("URL"));
//		driver = new AndroidDriver<WebElement>(url, capabilities);
//		
//		Code to Start the Server
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("ShivamPhone");
//		options.setApp("C:\\Users\\DELL\\eclipse-workspace\\appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\DELL\\eclipse-workspace\\appium\\src\\test\\java\\resources\\General-Store.apk");
		
//		Android driver
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//	public void LongPressActions(WebElement ele)
//	{
//
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(), 
//						"duration", 2000));
//		
//	}
//	
//	public void scrollDown()
//	{
//		boolean canScrollMore;
//		do {
//		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 3.0
//			));
//		}while(canScrollMore);
//	}
//	
//	public void swipeActions(WebElement ele, String direction)
//	{
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//				"elementId" ,((RemoteWebElement)ele).getId(),
//				    "direction", direction,
//				    "percent", 0.75
//				));
//	}
//	
//	public void dragnDropAction(WebElement ele, int endx, int endy) {
//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) ele).getId(),
//			    "endX", endx,
//			    "endY", endy
//			));
//	}
//	
//	//Converting String to double
//	public Double getFormattedSum(String amount) {
//		Double price=Double.parseDouble(amount.substring(1));
//		return price;
//	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
//		Server stop
		service.stop();
	}

}
