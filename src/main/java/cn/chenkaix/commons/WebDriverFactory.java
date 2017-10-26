package cn.chenkaix.commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cn.chenkaix.util.ReadProperties;

/**
 * @ClassName: WebDriverFactory
 * @Description: driverInst工厂
 * @author: 15255391553@163.com
 * @date: 2017年9月5日 下午11:02:15
 * @bolg: https://kxchen.github.io
 * 
 */
public class WebDriverFactory {
	private static final Logger log = Logger.getLogger(WebDriverFactory.class);
	private static WebDriver driverInst;
	private static MyWebDriver myDriverInst = new MyWebDriver();

	/**
	 * @Title: setDriverInst
	 * @Description: 设置webDriverInst
	 * @param driverInst
	 */
	public static void setDriverInst(WebDriver driverInst) {
		WebDriverFactory.driverInst = driverInst;
	}

	/**
	 * @Title: getMyDriverInst
	 * @Description: 获得myWebDriverInst
	 * @return @return： MyWebDriver
	 * @throws:
	 */
	public static MyWebDriver getMyDriverInst() {
		if (myDriverInst == null) {
			log.error("没有初始化实例:myDriverInst=null");
		} else {
			log.info("当前实例:" + myDriverInst.toString());
		}
		return myDriverInst;
	}

	/**
	 * @Title: getDriverInst
	 * @Description: 获得driverInst(该实例是selenium实例，可直接调用selenium的方法)
	 * @return: WebDriver
	 * @throws:
	 */
	public static WebDriver getDriverInst() {
		if (driverInst == null) {
			log.error("没有初始化实例:driverInst=null");
		} else {
			log.info("当前实例:" + driverInst.toString());
		}
		return driverInst;
	}

	/**
	 * @Title: getFirefoxDriverInst
	 *         、getChromeDriverInst、getInternetExplorerDriverInst
	 * @Description: 获取对应浏览器实例、创建myWebDriver实例
	 * @return @return： WebDriver
	 * @throws:
	 */
	public WebDriver getFirefoxDriverInst() {
		log.info("初始化FirefoxDriverInst");
		if (driverInst != null)
			log.warn("实例已经存在：" + driverInst.toString());
		log.info(ReadProperties.getFIREFOX_DRIVER_PATH());
		System.setProperty("webdriver.gecko.driver", ReadProperties.getFIREFOX_DRIVER_PATH());
		log.info(ReadProperties.getFIREROX_APP_PATH());
		System.setProperty("webdriver.firefox.bin", ReadProperties.getFIREROX_APP_PATH());
		driverInst = new FirefoxDriver();
		return driverInst;
	}

	public WebDriver getChromeDriverInst() {
		log.info("初始化ChromeDriverInst");
		if (driverInst != null)
			log.warn("实例已经存在：" + driverInst.toString());
		log.info(ReadProperties.getCHROME_DRIVER_PATH());
		System.setProperty("webdriver.chrome.driver", ReadProperties.getCHROME_DRIVER_PATH());
		log.info(ReadProperties.getCHROME_APP_PATH());
		System.setProperty("webdriver.chrome.bin", ReadProperties.getCHROME_APP_PATH());
		driverInst = new ChromeDriver();
		return driverInst;
	}

	public WebDriver getInternetExplorerDriverInst() {
		log.info("初始化InternetExplorerDriverInst");
		if (driverInst != null)
			log.warn("实例已经存在：" + driverInst.toString());
		log.info(ReadProperties.getIE_DRIVER_PATH());
		System.setProperty("webdriver.ie.driver", ReadProperties.getIE_DRIVER_PATH());
		log.info(ReadProperties.getIE_APP_PATH());
		System.setProperty("webdriver.ie.bin", ReadProperties.getIE_APP_PATH());
		driverInst = new InternetExplorerDriver();
		return driverInst;
	}
}
