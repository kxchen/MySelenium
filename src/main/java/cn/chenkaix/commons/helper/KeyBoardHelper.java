package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;
import cn.chenkaix.util.Constants;

/**
 * @ClassName: KeyBoardHelper
 * @Description: 键盘输入操作帮助类 
 * @author: 15255391553@163.com
 * @date: 2017年9月10日 下午11:26:59
 * @bolg: https://kxchen.github.io
 * 
 */
public class KeyBoardHelper {

	/**
	 * @Title: keyPress
	 * @Description: 模拟在指定对象上按下并释放某键
	 * @param locator
	 * @param key键的key值
	 */
	public static void keyPress(String locator, String key) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().keyPress(locator, key);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().keyPress(locator, key);
			}
	}

	/**
	 * @Title: keyPressNative
	 * @Description: 操作键盘的某键
	 * @param key
	 */
	public static void keyPressNative(String key) {
		WebDriverFactory.getMyDriverInst().keyPressNative(key);
	}

	/**
	 * @Title: shiftKeyDown
	 * @Description: 按下shift键，不释放
	 * 
	 */
	public static void shiftKeyDown() {
		WebDriverFactory.getMyDriverInst().shiftKeyDown();
	}

	/**
	 * @Title: shiftKeyUp
	 * @Description: 释放shift键
	 */
	public void shiftKeyUp() {
		WebDriverFactory.getMyDriverInst().shiftKeyUp();
	}

	/**
	 * @Title: metaKeyDown
	 * @Description: 按下meta键，不释放
	 */
	public static void metaKeyDown() {
		WebDriverFactory.getMyDriverInst().metaKeyDown();
	}

	/**
	 * @Title: metaKeyUp
	 * @Description: 释放meta键
	 */
	public static void metaKeyUp() {
		WebDriverFactory.getMyDriverInst().metaKeyUp();
	}

	/**
	 * @Title: altKeyDown
	 * @Description: 按下alt键，不释放
	 */
	public static void altKeyDown() {
		WebDriverFactory.getMyDriverInst().altKeyDown();
	}

	/**
	 * @Title: altKeyUp
	 * @Description: 释放alt键
	 */
	public static void altKeyUp() {
		WebDriverFactory.getMyDriverInst().altKeyUp();
	}

	/**
	 * @Title: controlKeyDown
	 * @Description: 按下ctrl键，不释放
	 */
	public static void controlKeyDown() {
		WebDriverFactory.getMyDriverInst().controlKeyDown();
	}

	/**
	 * @Title: controlKeyUp
	 * @Description: 释放ctrl键
	 */
	public static void controlKeyUp() {
		WebDriverFactory.getMyDriverInst().controlKeyUp();
	}

	/**
	 * @Title: keyDown
	 * @Description: 在指定对象上按下某键，不释放
	 * @param locator
	 * @param key
	 */
	public static void keyDown(String locator, String key) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().keyDown(locator, key);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().keyDown(locator, key);
			}
	}

	/**
	 * @Title: keyUp
	 * @Description: 在指定对象上释放某键
	 * @param locator
	 * @param key
	 */
	public static void keyUp(String locator, String key) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().keyUp(locator, key);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().keyUp(locator, key);
			}
	}
}
