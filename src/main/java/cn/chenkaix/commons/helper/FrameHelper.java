package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;
import cn.chenkaix.util.Constants;

/**
 * @ClassName: FrameHelper
 * @Description: Frame元素的帮助类 
 * @author: 15255391553@163.com
 * @date: 2017年9月4日
 * @bolg: https://kxchen.github.io
 * 
 */
public class FrameHelper {
	/**
	 * @Title: selectFrame
	 * @Description: 选择指定的Frame
	 * @param locator
	 *            frame的标识 默认为id或name：例1. selectFrame("top")
	 *            xpath=xpathExpress：例2. //iframe[@name='top']
	 *            xpath=//iframe[@name='top']index=indexValue：例3.index=0
	 */
	public static void selectFrame(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().selectFrame(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().selectFrame(locator);
			}
	}

	/**
	 * @Title: getDefaultContent
	 * @Description: 返回到页面的顶层frame
	 * @throws:
	 */
	public static void getDefaultContent() {
		WebDriverFactory.getMyDriverInst().defaultContent();
	}

}
