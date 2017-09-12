package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.MyWebDriver;
import cn.chenkaix.commons.WebDriverFactory;
import cn.chenkaix.util.Constants;

/**
 * @ClassName: PopUpHelper
 * @Description: 提示，警告，输入的弹出对话框操作帮助类
 * @author: 15255391553@163.com
 * @date: 2017年9月11日 上午12:10:06
 * @bolg: https://kxchen.github.io
 * 
 */
public class PopUpHelper {

	/**
	 * @Title: clickOnAlert
	 * @Description: 点击提示对话框的确认按钮，并且返回提示框中的提示内容。
	 * @return @return： String 返回提示信息
	 */
	public static String clickOnAlert() {
		String alertText = "";
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				alertText = WebDriverFactory.getMyDriverInst().getAlert();
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					alertText = WebDriverFactory.getMyDriverInst().getAlert();
				}
			}
		}
		return alertText;
	}

	/**
	 * @Title: getPropmt
	 * @Description: 获取输入对话框中的提示信息
	 * @return @return： String 提示信息
	 */
	public static String getPropmt() {
		String propmtText = "";
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				propmtText = WebDriverFactory.getMyDriverInst().getPrompt();
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					propmtText = WebDriverFactory.getMyDriverInst().getPrompt();
				}
			}
		}
		return propmtText;
	}

	/**
	 * @Title: getTextOnConfirmation
	 * @Description: 获取警告对话框的提示信息（和getPropmt() 方法实现一样，为了语义化）
	 * @return @return： String
	 */
	public static String getTextOnConfirmation() {
		String confirmationText = "";
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				confirmationText = WebDriverFactory.getMyDriverInst().getConfirmation();
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					confirmationText = WebDriverFactory.getMyDriverInst().getConfirmation();
				}
			}
		}
		return confirmationText;
	}

	/**
	 * @Title: clickOkOnConfirmation
	 * @Description: 点击警告对话框的确认按钮，并且返回警告对话框里的提示信息
	 * @return @return： String
	 */
	public static String clickOkOnConfirmation() {
		MyWebDriver myWebDriver = WebDriverFactory.getMyDriverInst();
		String text = myWebDriver.getConfirmation();
		myWebDriver.chooseOkOnNextConfirmation();
		return text;
	}

	/**
	 * @Title: clickCancelOnConfirmation
	 * @Description: 点击警告对话框的取消按钮，并且返回警告对话框里的提示信息
	 * @return @return： String
	 */
	public static String clickCancelOnConfirmation() {
		MyWebDriver myWebDriver = WebDriverFactory.getMyDriverInst();
		String text = myWebDriver.getConfirmation();
		myWebDriver.chooseCancelOnNextConfirmation();
		return text;
	}

	/**
	 * @Title: clickOkOnPropmt
	 * @Description: 在输入对话框中输入内容，并且点击确认按钮
	 * @param text输入的内容
	 */
	public static void clickOkOnPropmt(String text) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().answerOnNextPrompt(text);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().answerOnNextPrompt(text);
			}
	}

	/**
	 * @Title: isAlertExit
	 * @Description: 判断是否存在提示对话框
	 * @return @return： booleantrue 为存在 false 为不存在
	 */
	public static boolean isAlertExit() {
		boolean isAlert = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isAlert = WebDriverFactory.getMyDriverInst().isAlertPresent();
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isAlert = WebDriverFactory.getMyDriverInst().isAlertPresent();
				}
			}
		}
		return isAlert;
	}

	/**
	 * @Title: isConfirmationExit
	 * @Description: 判断是否存在警告对话框
	 * @return @return： boolean
	 */
	public static boolean isConfirmationExit() {
		boolean isConfirmation = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isConfirmation = WebDriverFactory.getMyDriverInst().isConfirmationPresent();
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isConfirmation = WebDriverFactory.getMyDriverInst().isConfirmationPresent();
				}
			}
		}
		return isConfirmation;
	}

	/**
	 * @Title: isPropmtExit
	 * @Description: 判断是否存在输入对话框
	 * @return @return： boolean
	 */
	public static boolean isPropmtExit() {
		boolean isPropmt = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isPropmt = WebDriverFactory.getMyDriverInst().isPromptPresent();
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isPropmt = WebDriverFactory.getMyDriverInst().isPromptPresent();
				}
			}
		}
		return isPropmt;
	}

}
