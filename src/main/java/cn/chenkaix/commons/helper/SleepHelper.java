package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;

/**
 * @ClassName: SleepHelper
 * @Description: 时间等待帮助类
 * @author: 15255391553@163.com
 * @date: 2017年9月6日
 * @bolg: https://kxchen.github.io
 * 
 */
public class SleepHelper {
	/**
	 * @Title: sleep
	 * @Description:等待固定时间
	 * @param interval:时间间隔
	 *            单位是毫秒 @return： void
	 * @throws:
	 */
	public static void sleep(int interval) {
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
		}
	}

	/**
	 * @Title: sleep
	 * @Description:等待指定对象出现，等待总时间为interval*times。
	 * @param locator
	 * @param interval
	 *            两次查找的时间间隔
	 * @param times
	 *            查找次数 @return： void
	 * @throws:
	 */
	public static void sleep(String locator, int interval, int times) {
		int count = times;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().isElementPresent(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				sleep(interval);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().isElementPresent(locator);
			}
	}
}
