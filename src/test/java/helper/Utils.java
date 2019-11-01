package helper;

import base.Initializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

//import static io.appium.java_client.touch.WaitOptions.waitOptions;
//import static io.appium.java_client.touch.offset.PointOption.point;


public class Utils extends Initializer {

	private  int miliSecond = 1000;
	private  int oneSecond = 1 * miliSecond;
	private  int twoSecond = 2 * miliSecond;
	private  int fullScreenSize = 100;

	private  int startx = 0;
	private  int starty = 0;
	private  int endx = 0;
	private  int endy = 0;

	private String CONTENT_DESCRIPTION = "contentDescription";

	public  void clickWithBy(By by) {

		waitForElement(by, miliSecond).click();
		waitThread(3);
	}

	public void type(By byLocator, String keyword) {
		waitForElement(byLocator, miliSecond).sendKeys(keyword);
	}


	private void waitThread(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  MobileElement tipinde nesneye tıklar.
	 */
	public  void click(MobileElement mobileElement) {
		mobileElement.click();
	}

	/**
	 * By tipinde nesneye tıklar.
	 */
	public  void click(By byElement) {

		MobileElement me = findElement(byElement);
	    if(me != null)
	    	me.click();
	}

	/**
	 * MobileElement tipinde nesneyi seçili hale getirir.

	 */
	public  void select(MobileElement mobileElement) {

		//mobileElement.tap(1, twoSecond);
	}

	/**
	 * By tipinde nesneyi seçili hale getirir.
	 */
	public  void select(By byElement) {

		MobileElement me = findElement(byElement);
		if(me != null);
			//me.tap(1, twoSecond);
	}

	/**
	 * By tipinde nesne içerisine veri yazar.
	 */
	public  void sendKeys(By byElement, String keys) {

		MobileElement me = findElement(byElement);
		if(me != null) {
			me.sendKeys(keys);
		}
	}

	/**
	 *MobileElement tipinde nesne içerisine veri yazar.
	 */
	public  void sendKeys(MobileElement mobileElement, String keys) {

		mobileElement.sendKeys(keys);
	}

	protected void setElementConverter(org.openqa.selenium.remote.internal.JsonToWebElementConverter converter){


	}

	/**
	 * By tipinde nesneyi bulur.
	 */
	public  MobileElement findElement(By byElement) {
		mobilDriver.manage().timeouts().implicitlyWait(5, SECONDS);
		MobileElement me;
		try{
			me = (MobileElement) webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byElement));
			// me = (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
			//me = (MobileElement) webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byElement));
		}
		catch(Exception ex) {
			//System.err.println(String.format("[%s] idli element bulunamadı! Hata mesajı: %s", byElement, ex.getMessage()));
			me = null;
		}
		return me;
	}

/**
	 * By tipinde nesneyi bulur.
	 */
	public  MobileElement findElementNew(By byElement) {
		mobilDriver.manage().timeouts().implicitlyWait(10, SECONDS);
		MobileElement me =findElement(byElement);
		return me;
	}

	public  MobileElement findElementNewFinder(By byElement) {
		mobilDriver.manage().timeouts().implicitlyWait(5, SECONDS);
		MobileElement me =(MobileElement) webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byElement));

		for(int i=0;i<=2;i++)

		{

			try{

				me = (MobileElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
				break;

			}

			catch(Exception e)
			{

				System.out.println((e.getMessage()));
				me=null;
			}

		}
		return me;
	}

	/**
	 *  By tipinde nesneyi bulur.
	 */
	public  MobileElement findElement(By byElement, int timeOutInSeconds) {

		MobileElement me = null;
		try {
			me = (MobileElement) new WebDriverWait(mobilDriver, timeOutInSeconds, oneSecond).until(ExpectedConditions.presenceOfElementLocated(byElement));
		}
		catch(Exception ex) {
			//System.err.println(String.format("[%s] idli element bulunamadı! ", byElement));
			me = null;
		}
		return me;
	}

	/**
	 * By tipinde nesneyi bulur. Bu metot, nesnenin sayfa kaynağına yüklenmesini beklemez.
	 * Kullanacağınız zaman nesnenin sayfa üzerinde olduğundan emin olmanız gerekir.
	 */
	/*public  MobileElement findElementDoNotWait(By byElement) {

		MobileElement element;

		try {
		//	element = mobilDriver.findElement(byElement);
		}
		catch (Exception ex) {
			System.err.println(String.format("[%s] idli element bulunamadı! Hata mesajı: %s", byElement, ex.getMessage()));
			element = null;
		}
		return element;
	}*/

	public void goBack(){
		mobilDriver.navigate().back();
	}

	/**
	 * By tipinde nesneyi bulur. Bu metot, nesnenin sayfa kaynağına yüklenmesini beklemez.
	 * Kullanacağınız zaman nesnenin sayfa üzerinde olduğundan emin olmanız gerekir.
	 */
	/*public  MobileElement findElementDoNotWaitWithoutTryCatch(By byElement) {

		MobileElement element;
	//	element = mobilDriver.findElement(byElement);

		return element;
	}*/

	/**
	 * Root dizini altında bulunan üyeler  arama yapar . By tipinde nesneyi bulur.
	 * Bu metot, nesnenin sayfa kaynağına yüklenmesini beklemez.
	 * Kullanacağınız zaman sayfanın yüklenmiş olduğundan emin olmanız gerekir.
	 */
	public  MobileElement findElementDoNotWait(By byRootElement, By byChildElement) {

		return mobilDriver.findElement(byRootElement).findElement(byChildElement);
	}

	/**
	 * Bir root dizini ve onun altında bulunan üyeler arasında 'ContentDescription' değeri eşleşen nesneyi dönderir.
	 */
	public  MobileElement findElementByContentDescription(By byRootElement, By byChildElement, String contentDescription) {

		List<MobileElement> mobileElementList = findElements(byRootElement, byChildElement);
		MobileElement findElement = null;

		if(mobileElementList.isEmpty()){
			return null;
		}

		for (MobileElement item : mobileElementList) {
			if (item.getAttribute(CONTENT_DESCRIPTION).toString().trim().equals(contentDescription)) {
				findElement = item;
				break;
			}
		}
		return findElement;
	}

	/**
	 * Sayfada bulunan üyeler arasında 'ContentDescription' değeri eşleşen nesneyi dönderir.
	 */
	public  MobileElement findElementByContentDescription(By byChildElement, String contentDescription) {

		for (MobileElement item : findElements(byChildElement)) {
			if (item.getAttribute(CONTENT_DESCRIPTION).toString().trim().equals(contentDescription)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * By tipinde nesneleri dönderir.
	 */
	public  List<MobileElement> findElements(By byRootElement, By byChildElements) {

		List<MobileElement> mobileElementList = new ArrayList<MobileElement>();
		List<WebElement> webElementList = new ArrayList<WebElement>();


		try{
			webElementList = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byRootElement)).findElements(byChildElements);
		}
		catch (Exception ex){

			System.err.println(String.format("[%s] root dizininde [%s] child elementler bulunamadı! Hata: %s",
					byRootElement, byChildElements, ex.getMessage()));
		}

		if(webElementList.isEmpty()){
			return mobileElementList;
		}

		for (WebElement webElement : webElementList) {
			mobileElementList.add((MobileElement) webElement);
		}
		return mobileElementList;
	}

	/**
	 * By tipine uygun nesneleri dönderir.
	 */
	public  List<MobileElement> findElements(By byChildren) {

		List<WebElement> webElementList = new ArrayList<WebElement>();

		try{
			webElementList = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byChildren));
		}
		catch (Exception ex){
			System.err.println(String.format("Sayfa kaynağında [%s] idli element bulunamadı!", byChildren));
		}
		return convertWebElementToMobileElement(webElementList);
	}

	/**
	 * Web Element tipindeki nesneleri listeye çeker uygun nesneleri dönderir.
	 */
	public  List<MobileElement> convertWebElementToMobileElement(List<WebElement> webElementList){

		List<MobileElement> mobileElementList = new ArrayList<MobileElement>();

	    if(webElementList == null || webElementList.isEmpty())
	        return mobileElementList;

        for (WebElement we : webElementList) {
            mobileElementList.add((MobileElement) we);
        }
	    return mobileElementList;
    }

	/**
	 * By tipindeki nesneleri listeye çeker uygun nesneleri dönderir.
	 */
	public  List<MobileElement> findElements(By byChildren, int second) {

        List<WebElement> webElementList = new ArrayList<WebElement>();
        WebDriverWait wait = new WebDriverWait(mobilDriver,5,1000);

        try{
            webElementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byChildren));
        }
        catch (Exception ex){
            System.err.println(String.format("Sayfa kaynağında [%s] idli element bulunamadı!", byChildren));
        }
		return convertWebElementToMobileElement(webElementList);
	}

    /**
     * By tipindeki nesneler içerisinden {@code Text} değeri eşleşen nesneyi dönderir.
     */
	public  MobileElement findElementByText(By byChildren, String elementText) {

		MobileElement findElement = null;
		List<MobileElement> mobileElementList = findElements(byChildren);

		if(mobileElementList.isEmpty()){
			return null;
		}

		for (MobileElement mobileElement : mobileElementList) {
			if (getText(mobileElement).equals(elementText)) {
				findElement = mobileElement;
				break;
			}
		}
		return findElement;
	}

	/**
	 * By tipindeki nesneler içerisinden {@code Text} değeri içeren nesneyi dönderir.
	 */
	public  MobileElement findElementByContains(By byChildren, String containsText) {

		MobileElement findElement = null;
		List<MobileElement> mobileElementList = findElements(byChildren);

		if(mobileElementList.isEmpty()){
			return null;
		}

		for (MobileElement mobileElement : mobileElementList) {
			if (getText(mobileElement).indexOf(containsText) != -1) {
				findElement = mobileElement;
				break;
			}
		}
		return findElement;
	}

	/**
	 * Elementin Text değerini dönderir.
	 */
	public  String getText(MobileElement mobileElement) {

		if (mobileElement == null) {
			return "";
		}
		if(mobileElement.getText() == null){
			return "";
		}
		return mobileElement.getText().trim();
	}

	/**
	 * Elementin Text değerini dönderir.
	 */
	public  String getText(By element) {

		return getText(findElement(element));
	}


	/**
	 * Element sayfa kaynağında var mı kontrol eder.
	 */
	public  boolean isExist(By byElement) {

		return findElement(byElement) != null;
	}

	/**
	 * Element sayfa kaynağında var mı kontrol eder.
	 */
	public  boolean isExist(By byElement, int timeOut) {

		return findElement(byElement, timeOut) != null;
	}

	/**
	 * Element sayfa kaynağında var mı kontrol eder. Bu metodu kullanmak için sayfanın yüklenmiş olduğundan emin olun.
	 */
	public  boolean isExistDoNotWait(By byElement) {

		try {
			if (mobilDriver.findElement(byElement) != null) {
				return true;
			}
		}
		catch (Exception ex) {
			return false;
		}
		return false;
	}

	/**
	 * Sayfa üzerinde {@code } bekleme yapar.
	 */
	public  void wait(int second) {

		try {

			if(second < 30) {
				Thread.sleep(convertToMiliSecond(second));
			}
			else {

				int timeIsUp = 0;

				while(timeIsUp >= second) {

					if(timeIsUp % 30 == 0) {
						mobilDriver.getPageSource();
					}

					Thread.sleep(oneSecond);
					timeIsUp++;
				}
			}
		}
		catch (Exception ex) {
			ex.getMessage();
		}
	}

	/**
	 * Bir elementin  'Content Description' değerini dönderir.
	 */
	public  String getContentDescription(By byElement) {

		MobileElement mobileElement = findElement(byElement);

		if(mobileElement == null){
			return "";
		}
	    return mobileElement.getAttribute(CONTENT_DESCRIPTION).trim();
	}

	/**
	 * 'Content Description' değerini dönderir.
	 */
	public  String getContentDescription(MobileElement byElement) {

		return byElement.getAttribute(CONTENT_DESCRIPTION).toString().trim();
	}

	/**
	 * Bir elementin 'Text' değerini dönderir.
	 */
	public  String getText(By byRootElement, By byChildElement) {

		String meText = "";
		MobileElement me = null;

		try{

			me = findElement(byRootElement).findElement(byChildElement);
		}
		catch(Exception ex){

			System.err.println(String.format("%s elementinin text değeri almaya çalışılırken hata oluştu!", byChildElement));
		}

		if (me != null){
			meText = getText(me);
		}
		return meText;
	}

	/**
	 * By tipine uygun nesneleri dönderir. Kullanacağınız zaman nesnenin sayfa üzerinde olduğundan emin olmanız gerekir.
	 * Nesnelerin sayfaya yüklenmesini beklemez.
	 */
	public  List<MobileElement> findElementsDoNotWait(By byRootElement, By byChildElement) {

		List<MobileElement> mobileElementList = new ArrayList<MobileElement>();
		try {
			mobileElementList = mobilDriver.findElement(byRootElement).findElements(byChildElement);
		}
		catch (Exception ex){
			System.err.println(String.format("[%s] root dizininde [%s] elementleri bulunamadı. Hata: %s ",
					byRootElement, byChildElement, ex.getMessage()));
		}
		return mobileElementList;
	}

	/**
	 * By tipine uygun nesneleri dönderir. Kullanacağınız zaman nesnenin sayfa üzerinde olduğundan emin olmanız gerekir.
	 * Nesnelerin sayfaya yüklenmesini beklemez.
	 */
	public  List<MobileElement> findElementsDoNotWait(MobileElement byRootElement, By byChildElement) {

		return byRootElement.findElements(byChildElement);
	}

	/**
	 * Elementin 'Text' değerini temizler.
	 */
	public  void clear(By byElement) {

		MobileElement me = findElement(byElement);
		if(me != null)
			me.clear();
	}

	/**
	 * Elementin 'Text' değerini temizler.
	 */
	public  void clear(MobileElement mobileElement) {

		mobileElement.clear();
	}

	/**
	 * Element sayfa kaynağından silindi mi kontrol eder.
	 * Genel olarak ekrana çıkan pop'up vb. şeylerin ekrandan kaybolduğunu kontrol etmek için kullanılır.
	 * Varsayılan olarak 300 saniye (5 dakika) sonra element kaybolmazsa zamanaşımına uğrar.
	 */
	/*public  boolean waitHideElement(By byElement) {

		return waitHideElement(byElement, 300);
	}
*/
	/**
	 * Element sayfa kaynağından silindi mi kontrol eder.
	 * Genel olarak ekrana çıkan pop'up vb. şeylerin ekrandan kaybolduğunu kontrol etmek için kullanılır.
	 */
/*	public  boolean waitHideElement(By byElement, int timeOut) {

		long endTime = System.currentTimeMillis() + convertToMiliSecond(timeOut);

		while (System.currentTimeMillis() < endTime) {
			if (findElementDoNotWait(byElement) == null)
				return true;
		}
		return false;
	}
*/
	/**
	 * Bir elementin sayfa kaynağına yüklenmesini bekler. Varsayılan olarak 20 saniye beklemektedir.
	 */
	/*public  boolean waitElement(By element) {

		return waitElement(element, 20);
	}
*/
	/**
	 * Bir elementin sayfa kaynağına yüklenmesini belirtilen saniye kadar bekler.
	 */
/*	public  boolean waitElement(By byElement, int second) {

		long endTime = System.currentTimeMillis() + convertToMiliSecond(second);

		while (System.currentTimeMillis() < endTime) {
			if (findElementDoNotWait(byElement) != null)
				return true;
		}
		return false;
	}
*/
	/**
	 * Android klavyesini kapatır.
	 */
	public  void hideAndroidKeyboard() {

		try {
			mobilDriver.hideKeyboard();
		}
		catch (Exception ex) {
			//System.err.println(String.format("Android klavye kapatılamadı."));
		}
	}

	/**
	 * Sayfa kaynağında 'String' arar.
	 * Genel olarak ekranda belirli süre bekledikten sonra kaybolan pop'up vb. nesneleri kontrol için kullanılır.
	 */
	public  boolean findString(String str, int second) {

		boolean isFind = false;
		long endTime = System.currentTimeMillis() + convertToMiliSecond(second);

		while (System.currentTimeMillis() < endTime) {

			isFind = findString(str);

			if (isFind) {
				break;
			}
		}
		return isFind;
	}

	/**
	 * Sayfa kaynağında 'String' arar.
	 * Genel olarak ekranda belirli süre bekledikten sonra kaybolan pop'up vb. nesneleri kontrol için kullanılır.
	 */
	public  boolean findString(String value) {

		return mobilDriver.getPageSource().contains(value);
	}

	/**
	 * Saniye cinsinden değeri milisaniye cinsine çevirir.
	 */
	private  long convertToMiliSecond(int second) {

		return (long) second * miliSecond;
	}

	/**
	 * IOS key kodlarını çalıştırmak için kullanılır.
	 */
	public  void hideIOSKeyboard() {

		IOSDriver<WebElement> we = (IOSDriver) mobilDriver;
		we.getKeyboard().sendKeys(Keys.RETURN);
	}

	/**
	 * Android key kodlarını çalıştırmak için kullanılır.
	 */
	public  void pressAndroidKeyCode(int keyCode) {

		//((AndroidDriver<?>)mobilDriver).pressKeyCode(keyCode);
	}

	/**
	 * By tipindeki nesnenin 'Text' ini almak için kullanılır.
	 */
	public  MobileElement findElementByText(String text, By buttonsID){

		Assert.assertTrue(String.format("[%s] idli element bulunamadı!", buttonsID), isExist(buttonsID));
		MobileElement foundButton = null;

		for(MobileElement me : findElements(buttonsID)){
			if(text.equals(me.getText())){
				foundButton = me;
				break;
			}
		}
		return foundButton;
	}

	/**
	 * Ekranda kaydırma işlemi yapar. Swipe metodunun muadili denebilir.
	 */
	public  void touch(int startLocationX, int startLocationY, int endLocationX, int endLocationY) {

		clearLocationVariablesValue();

		startx = getWindowWidth() * startLocationX / fullScreenSize;
		starty = getWindowHeight() * startLocationY / fullScreenSize;
		endx = getWindowWidth() * endLocationX / fullScreenSize;
		endy = getWindowHeight() * endLocationY / fullScreenSize;

		/*new TouchAction(mobilDriver)
				.press(startx, starty)
				.moveTo(endx - startx, endy - starty)
				.release()
				.perform();*/
	}

	/**
	 * Ekranda kaydırma işlemi yapar.
	 */

	/*
	public  void swipe(int startLocationX, int startLocationY, int endLocationX, int endLocationY) {

		clearLocationVariablesValue();

		startx = getWindowWidth() * startLocationX / fullScreenSize;
		starty = getWindowHeight() * startLocationY / fullScreenSize;
		endx   = getWindowWidth() * endLocationX / fullScreenSize;
		endy   = getWindowHeight() * endLocationY / fullScreenSize;

		//mobilDriver.swipe(startx, starty, endx, endy, 1000);
		new TouchAction(mobilDriver).tap(point(50, 80)).perform();

	}*/

	private  void clearLocationVariablesValue() {

		startx = 0;
		starty = 0;
		endx = 0;
		endy = 0;
	}

	/**
	 * Telefon yükseklik değerini dönderir
	 */
	protected  int getWindowHeight() {

		return mobilDriver.manage().window().getSize().height;
	}

	/**
	 * Telefonun genişlik değerini dönderir

	 */
	protected  int getWindowWidth() {

		return mobilDriver.manage().window().getSize().width;
	}

	public boolean isElementPresent(By byLocator) {
		try {
			waitForElement(byLocator, 5);
			return true;
		} catch (WebDriverException wde) {
			return false;
		}
	}

	public WebElement waitForElement(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(mobilDriver, timeOut);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}

	public void swipe(int startx, int starty, int endx, int endy, int duration){
/*
		new TouchAction(mobilDriver)
				.press(point(startx, starty))
				.waitAction(waitOptions(ofMillis(duration)))
				.moveTo(point(endx, endy))
				.release()
				.perform();*/
	}

	private void scrollOnApplicationForDown(String direction, int startX, int startY, int endX, int endY) {
		if ("down".equals(direction)) {
			swipe(startX, startY, endX, endY, 500);
		} else {
			swipe(startX, endY, endX, startY, 500);
		}

	}

	private void scrollOnApplicationForUp(String direction, int startX, int startY, int endX, int endY) {
		wait(2);
		if ("down".equals(direction)) {
			swipe(startX, startY, endX, endY, 500);
		} else {
			swipe(startX, endY, endX, startY, 500);
		}

	}

	private void scrollOnApplicationForRight(String direction, int startX, int startY, int endX, int endY) {
		if ("right".equals(direction)) {
			swipe(startX, startY, endX, endY, 500);
		} else {
			swipe(startX, endY, endX, startY, 500);
		}

	}

	public void leftSwipeAtListingSuggestion(String direction) {
	/*	MobileElement suggestion = mobilDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/com.google.android.material.chip.Chip[1]");

		int startX = suggestion.getLocation().getX();
		int startY = suggestion.getLocation().getY();
		int endX = (startX + suggestion.getSize().getWidth());

		scrollOnApplicationForRight(direction, endX, startY, startX, startY);
*/	}


	public void scrollOnApplication(String direction) {

		Dimension dimensions = mobilDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollStart = screenHeightStart.intValue();
		int scrollEnd = screenHeightEnd.intValue();

		scrollOnApplicationForDown(direction, 10, scrollStart, 10, scrollEnd);
	}

	public void scrollOnApplications(String direction) {
		Dimension dimensions = mobilDriver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.6;
		Double screenHeightEnd = dimensions.getHeight() * 0.4;
		int scrollStart = screenHeightStart.intValue();
		int scrollEnd = screenHeightEnd.intValue();

		scrollOnApplicationForUp(direction, 10, scrollStart, 10, scrollEnd);
	}

	public void waitForElementIsNoExists(By by) {
		try {

			FluentWait<WebDriver> myWait = new FluentWait<WebDriver>(mobilDriver)
					.withTimeout(5, SECONDS)
					.pollingEvery(50, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(TimeoutException.class);
			myWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
		} catch (TimeoutException e) {
			System.out.println("Timed out after default time out. Page is not responding after " + 5 + "sec.");
		}
	}

}


