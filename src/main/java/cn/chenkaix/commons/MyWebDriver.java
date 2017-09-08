package cn.chenkaix.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.chenkaix.util.ReadProperties;

public class MyWebDriver implements IMyWebDriver {
	private WebDriverFactory webDriver = new WebDriverFactory();
	private static final Logger log = Logger.getLogger(MyWebDriver.class);

	public WebElement findElement(String locator) {
		if (locator.startsWith("id=")) {
			return WebDriverFactory.getDriverInst().findElement(By.id(locator.substring("id=".length())));
		}
		if (locator.startsWith("name=")) {
			return WebDriverFactory.getDriverInst().findElement(By.name(locator.substring("name=".length())));
		}
		if (locator.startsWith("xpath=")) {
			return WebDriverFactory.getDriverInst().findElement(By.xpath(locator.substring("xpath=".length())));
		}
		if (locator.startsWith("//"))
			return WebDriverFactory.getDriverInst().findElement(By.xpath(locator));
		if (locator.startsWith("css=")) {
			return WebDriverFactory.getDriverInst().findElement(By.cssSelector(locator.substring("css=".length())));
		}
		if (locator.startsWith("link=")) {
			return WebDriverFactory.getDriverInst().findElement(By.linkText(locator.substring("link=".length())));
		}
		try {
			return WebDriverFactory.getDriverInst().findElement(By.id(locator));
		} catch (Exception e) {
		}
		return WebDriverFactory.getDriverInst().findElement(By.name(locator));
	}

	public void start() {
		webDriver.getFirefoxDriverInst();

	}

	public void start(String Browser) {
		try {
			if (Browser.equalsIgnoreCase("firefox")) {
				log.info(ReadProperties.getFIREFOX_DRIVER_PATH());
				System.setProperty("webdriver.gecko.driver", ReadProperties.getFIREFOX_DRIVER_PATH());
				log.info(ReadProperties.getFIREROX_APP_PATH());
				System.setProperty("webdriver.firefox.bin", ReadProperties.getFIREROX_APP_PATH());
				webDriver.getFirefoxDriverInst();
			} else if (Browser.equalsIgnoreCase("chrome")) {
				log.info(ReadProperties.getCHROME_DRIVER_PATH());
				System.setProperty("webdriver.chrome.driver", ReadProperties.getFIREFOX_DRIVER_PATH());
				log.info(ReadProperties.getCHROME_APP_PATH());
				System.setProperty("webdriver.chrome.bin", ReadProperties.getFIREROX_APP_PATH());
				webDriver.getChromeDriverInst();
			} else {
				log.info(ReadProperties.getIE_DRIVER_PATH());
				System.setProperty("webdriver.chrome.driver", ReadProperties.getIE_DRIVER_PATH());
				log.info(ReadProperties.getIE_APP_PATH());
				System.setProperty("webdriver.chrome.bin", ReadProperties.getIE_APP_PATH());
				webDriver.getInternetExplorerDriverInst();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}

	}

	public void stop() {
		WebDriverFactory.getDriverInst().quit();

	}

	public void click(String paramString) {
		WebDriverFactory.getDriverInst().close();

	}

	public void jsClick(String paramString) {
		// TODO Auto-generated method stub

	}

	public void doScroll(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void doubleClick(String paramString) {
		// TODO Auto-generated method stub

	}

	public void contextMenu(String paramString) {
		// TODO Auto-generated method stub

	}

	public void clickAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void doubleClickAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void contextMenuAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void focus(String paramString) {
		// TODO Auto-generated method stub

	}

	public void keyPress(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void shiftKeyDown() {
		// TODO Auto-generated method stub

	}

	public void shiftKeyUp() {
		// TODO Auto-generated method stub

	}

	public void metaKeyDown() {
		// TODO Auto-generated method stub

	}

	public void metaKeyUp() {
		// TODO Auto-generated method stub

	}

	public void altKeyDown() {
		// TODO Auto-generated method stub

	}

	public void altKeyUp() {
		// TODO Auto-generated method stub

	}

	public void controlKeyDown() {
		// TODO Auto-generated method stub

	}

	public void controlKeyUp() {
		// TODO Auto-generated method stub

	}

	public void keyDown(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void keyUp(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void mouseOver(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseOut(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseDown(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseDownRight(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseDownAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void mouseDownRightAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void mouseUp(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseUpRight(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseUpAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void mouseUpRightAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void mouseMove(String paramString) {
		// TODO Auto-generated method stub

	}

	public void mouseMoveAt(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void type(String paramString1, String paramString2) {
		findElement(paramString1).sendKeys(new CharSequence[] { paramString2 });

	}

	public void typeKeys(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void check(String paramString) {
		// TODO Auto-generated method stub

	}

	public void uncheck(String paramString) {
		// TODO Auto-generated method stub

	}

	public void select(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void addSelection(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void removeSelection(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void removeAllSelections(String paramString) {
		// TODO Auto-generated method stub

	}

	public void submit(String paramString) {
		// TODO Auto-generated method stub

	}

	public void open(String paramString) {

		WebDriverFactory.getDriverInst().get(paramString);

	}

	public void openWindow(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void selectWindow(String paramString) {
		Set handlers = WebDriverFactory.getDriverInst().getWindowHandles();
		Iterator it = handlers.iterator();
		while (it.hasNext()) {
			WebDriver window = WebDriverFactory.getDriverInst().switchTo().window((String) it.next());
			if (window.getTitle().equals(paramString))
				return;
		}

	}

	public void selectFrame(String paramString) {
		if (paramString.startsWith("index=")) {
			WebDriverFactory.getDriverInst().switchTo()
					.frame(Integer.parseInt(paramString.substring("index=".length())));

			return;
		}
		if (paramString.startsWith("//")) {
			WebDriverFactory.getDriverInst().switchTo()
					.frame(WebDriverFactory.getDriverInst().findElement(By.xpath(paramString)));

			return;
		}
		if (paramString.startsWith("xpath=")) {
			WebDriverFactory.getDriverInst().switchTo().frame(
					WebDriverFactory.getDriverInst().findElement(By.xpath(paramString.substring("xpath=".length()))));

			return;
		}
		WebDriverFactory.getDriverInst().switchTo().frame(paramString);

	}

	public void chooseCancelOnNextConfirmation() {
		// TODO Auto-generated method stub

	}

	public void chooseOkOnNextConfirmation() {
		// TODO Auto-generated method stub

	}

	public void answerOnNextPrompt(String paramString) {
		// TODO Auto-generated method stub

	}

	public void goBack() {
		WebDriverFactory.getDriverInst().navigate().back();

	}

	public void refresh() {
		WebDriverFactory.getDriverInst().navigate().refresh();

	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public boolean isAlertPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPromptPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isConfirmationPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getAlert() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getConfirmation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrompt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocation() {

		return WebDriverFactory.getDriverInst().getCurrentUrl();
	}

	public String getTitle() {

		return WebDriverFactory.getDriverInst().getTitle();
	}

	public String getBodyText() {

		return WebDriverFactory.getDriverInst().getPageSource();
	}

	public String getValue(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public void highlight(String paramString) {
		WebElement element = findElement(paramString);
		JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriverInst();
		System.out.println(js.executeScript("return arguments[0].style.border", new Object[] { element }));
		log.info(js.executeScript("return arguments[0].style.border", new Object[] { element }));
		js.executeScript("arguments[0].style.border='3px solid red';", new Object[] { element });

	}

	public String getEval(String paramString) {
		Object result = ((JavascriptExecutor) WebDriverFactory.getDriverInst()).executeScript(paramString,
				new Object[0]);

		if (result == null) {
			return "";
		}
		return result.toString();
	}

	public boolean isChecked(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getTable(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getSelectedLabels(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectedLabel(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getSelectedValues(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectedValue(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getSelectedIndexes(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectedIndex(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getSelectedIds(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectedId(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSomethingSelected(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getSelectOptions(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttribute(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTextPresent(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isElementPresent(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isVisible(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEditable(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public void windowFocus() {
		// TODO Auto-generated method stub

	}

	public void windowMaximize() {
		WebDriverFactory.getDriverInst().manage().window().maximize();

	}

	public String[] getAllWindowIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getAllWindowNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getAllWindowTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHtmlSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public Number getElementPositionLeft(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public Number getElementPositionTop(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public Number getElementWidth(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public Number getElementHeight(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public Number getXpathCount(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTimeout(String paramString) {
		// TODO Auto-generated method stub

	}

	public void waitForPageToLoad(String paramString) {
		// TODO Auto-generated method stub

	}

	public void waitForFrameToLoad(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public String getCookie() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCookieByName(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCookiePresent(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	public void createCookie(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void deleteCookie(String paramString1, String paramString2) {
		// TODO Auto-generated method stub

	}

	public void deleteAllVisibleCookies() {
		// TODO Auto-generated method stub

	}

	public void setBrowserLogLevel(String paramString) {
		// TODO Auto-generated method stub

	}

	public void runScript(String paramString) {
		// TODO Auto-generated method stub

	}

	public void useXpathLibrary(String paramString) {
		// TODO Auto-generated method stub

	}

	public void setContext(String paramString) {
		// TODO Auto-generated method stub

	}

	public void keyDownNative(String paramString) {
		// TODO Auto-generated method stub

	}

	public void keyUpNative(String paramString) {
		// TODO Auto-generated method stub

	}

	public void keyPressNative(String paramString) {
		// TODO Auto-generated method stub

	}

	public void defaultContent() {
		WebDriverFactory.getDriverInst().switchTo().defaultContent();

	}

	public void clear(String paramString) {
		// TODO Auto-generated method stub

	}

	public Set<String> getWindowHandlers() {

		return WebDriverFactory.getDriverInst().getWindowHandles();
	}

	public void selectWinByHandler(String paramString) {
		// TODO Auto-generated method stub

	}

	public String getWindowHandler() {

		return WebDriverFactory.getDriverInst().getWindowHandle();
	}

	public String getBrowserWinHandle() {

		return WebDriverFactory.getDriverInst().getWindowHandle();
	}

	public void downloadFile(String paramString1, String paramString2, String paramString3) {
		// WebDriverFactory.getDriverInst().downloadFile(paramString1,
		// paramString2, paramString3);

	}

}
