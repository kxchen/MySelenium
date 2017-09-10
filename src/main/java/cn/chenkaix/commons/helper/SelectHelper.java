package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;
import cn.chenkaix.util.Constants;

/**
 * @ClassName: SelectHelper
 * @Description: TODO
 * @author: 15255391553@163.com
 * @date: 2017年9月9日 上午12:19:23
 * @bolg: https://kxchen.github.io
 * 
 */
public class SelectHelper {

	/**
	 * @Title: select
	 * @Description: 在指定下拉列表里选中选项，不清除之前的选项。
	 * @param locator
	 *            元素的标识 。 默认为id: 例 InputHelper.click("loginBtn"); id=id： 例如
	 *            id=loginBtn; name=name： 例如 name=username dom=jsExpress： 例如
	 *            dom=document.forms['myForm'].myDropdown xpath=xpathExpress：例如
	 *            //input[@name='name2' ] xpath=//input[@name='name2']
	 *            link=textPattern：例如 link=登陆 css=cssSelectorSyntax：例如
	 *            css=a[href="#id3"]
	 * @param value
	 *            选项的标识 value=value 使用value值来选择选项 index=index 使用index值来选择选项
	 *            label=label 使用label值来选择选项 没有指定类型时，默认是按照label来选择选项
	 * 
	 * @throws:
	 */
	public static void select(String locator, String value) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().select(locator, value);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().select(locator, value);
			}
	}

	/**
	 * @Title: selectOnly
	 * @Description: TODO
	 * @param locator
	 * @param value
	 * 			@return： void
	 * @throws:
	 */
	public static void selectOnly(String locator, String value) {
		removeAllSelections(locator);
		select(locator, value);
	}

	/**
	 * @Title: addSelection
	 * @Description: TODO
	 * @param locator
	 * @param value
	 * 			@return： void
	 * @throws:
	 */
	public static void addSelection(String locator, String value) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().addSelection(locator, value);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().addSelection(locator, value);
			}
	}

	/**
	 * @Title: removeSelection
	 * @Description: TODO
	 * @param locator
	 * @param value
	 * 			@return： void
	 * @throws:
	 */
	public static void removeSelection(String locator, String value) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().removeSelection(locator, value);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().removeSelection(locator, value);
			}
	}

	/**
	 * @Title: removeAllSelections
	 * @Description: TODO
	 * @param locator
	 * 			@return： void
	 * @throws:
	 */
	public static void removeAllSelections(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().removeAllSelections(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().removeAllSelections(locator);
			}
	}

	/**
	 * @Title: getSelectedLabels
	 * @Description: TODO
	 * @param locator
	 * @return @return： String[]
	 * @throws:
	 */
	public static String[] getSelectedLabels(String locator) {
		return WebDriverFactory.getMyDriverInst().getSelectedLabels(locator);
	}

	/**
	 * @Title: getSelectedLabel
	 * @Description: TODO
	 * @param locator
	 * @return @return： String
	 * @throws:
	 */
	public static String getSelectedLabel(String locator) {
		return WebDriverFactory.getMyDriverInst().getSelectedLabel(locator);
	}

	/**
	 * @Title: isSomethingSelected
	 * @Description: TODO
	 * @param locator
	 * @return @return： boolean
	 * @throws:
	 */
	public static boolean isSomethingSelected(String locator) {
		return WebDriverFactory.getMyDriverInst().isSomethingSelected(locator);
	}

	/**
	 * @Title: getSelectOptions
	 * @Description: TODO
	 * @param locator
	 * @return @return： String[]
	 * @throws:
	 */
	public static String[] getSelectOptions(String locator) {
		String[] options = null;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				options = WebDriverFactory.getMyDriverInst().getSelectOptions(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					options = WebDriverFactory.getMyDriverInst().getSelectOptions(locator);
				}
			}
		}
		return options;
	}
}
