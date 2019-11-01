package helper;


import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import static io.appium.java_client.touch.WaitOptions.waitOptions;
//import static io.appium.java_client.touch.offset.PointOption.point;
//import static java.time.Duration.ofMillis;

public class MethodsPage extends Utils {

	public final Logger log = Logger.getLogger(Class.class);

	protected void clickBy(By byElement, String assertionMessage, String logMessage) {

		MobileElement me = findElement(byElement);
 		clickMobileElement(me, assertionMessage, logMessage);
	}

	protected void clickByFast(By byElement, String assertionMessage, String logMessage) {

	//	MobileElement me = findElementDoNotWaitWithoutTryCatch(byElement);
	//	clickMobileElement(me, assertionMessage, logMessage);
	}

	protected void clickBy(By byElement, String logMessage) {
  		MobileElement me = findElementNew(byElement);
		clickMobileElement(me, logMessage);
			}

	protected void clickByx(By byElement, String logMessage) {
  		mobilDriver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
		WebElement element= mobilDriver.findElement(byElement);
  		element.click();
		mobilDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        try {

		List<WebElement> webElements=element.findElements(byElement);
  		WebElement toClick=null;
  		for(WebElement me:webElements){

  			if(me.isDisplayed()){
  				toClick=me;
				mobilDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				break;
			}
		}
  		if(toClick !=null)
		{
			toClick.click();
			mobilDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}else {
			System.out.println(logMessage);
		}
			}catch (Exception e){

		System.out.println(e.getMessage());
        }
			}

	private void clickMobileElement(MobileElement me, String assertionMessage, String logMessage) {

		Assert.assertTrue(assertionMessage, me != null);
		click(me);
		logger(logMessage);
	}

	private void clickMobileElement(MobileElement me, String logMessage) {

		click(me);
		logger(logMessage);
	}

	private void sendKeys(MobileElement mobileElement, String value, String errorMessage, String logMessage) {

		Assert.assertTrue(errorMessage, mobileElement != null);
		sendKeys(mobileElement, value);
		logger(logMessage);
	}

	private void logger(String message) {
		if(message != null) {
			log.info(message);
		}
	}

	protected MobileElement findElementWithSwipe(By findElement, int swipeCount){

		MobileElement mElement = null;

		for(int i = 0; i < swipeCount; i++){

			if(isExist(findElement, 3)){
				mElement = findElement(findElement);
				break;
			}
			//swipe(50, 80, 50, 50);
			swipe(50, 50,50 ,150,2);
		}
		return mElement;
	}

	protected MobileElement findElementWithSwipeLeft(By findElement, int swipeCount){

		MobileElement mElement = null;

		for(int i = 0; i < swipeCount; i++){

			if(isExist(findElement, 3)){
				mElement = findElement(findElement);
				break;
			}
			swipe(50, 50,50 ,150,2);
		}
		return mElement;
	}

	private String getAttribute(MobileElement me, String attributeName){
		return me.getAttribute(attributeName);
	}

	public String getRandomSearchKey () {

		Random random = new Random();
		List<String> list = new ArrayList<String>();
		list.add("iphone");
		list.add("elma");
		list.add("armut");
		list.add("terlik");
		list.add("ayakkabı");

		return list.get(random.nextInt(list.size()));
	}

	public String getRandomSearchWithOneCharacter(){

		Random random = new Random();
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("%");
		list.add("");
		list.add("a ");

		return list.get(random.nextInt(list.size()));
	}

}
