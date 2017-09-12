package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;
import cn.chenkaix.util.Constants;

/**
 * @ClassName: MouseHelper
 * @Description: 鼠标操作帮助类
 * @author: 15255391553@163.com
 * @date: 2017年9月11日 上午12:09:55
 * @bolg: https://kxchen.github.io
 * 
 */
public class MouseHelper {

	/**
	 * @Title: mouseOver
	 * @Description: 鼠标移动到指定对象上。
	 * @param locator
	 */
	public static void mouseOver(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().mouseOver(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().mouseOver(locator);
			}
	}

	/**
	 * @Title: mouseDown
	 * @Description: 在指定对象上按下鼠标右键
	 * @param locator
	 */
	public static void mouseDown(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().mouseDown(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().mouseDown(locator);
			}
	}

	/**
	 * @Title: mouseUp
	 * @Description: 在指定对象上释放鼠标右键
	 * @param locator
	 */
	public static void mouseUp(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().mouseUp(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().mouseUp(locator);
			}
	}

	/**
	 * @Title: mouseMove
	 * @Description: 鼠标移动到指定对象上
	 * @param locator
	 */
	public static void mouseMove(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().mouseMove(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().mouseMove(locator);
			}
	}

}
