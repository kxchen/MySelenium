package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;
import cn.chenkaix.util.Constants;

/**
 * @ClassName: InputHelper
 * @Description: Input的类型的操作公共类。
 * @author: 15255391553@163.com
 * @date: 2017年9月9日 上午1:07:44
 * @bolg: https://kxchen.github.io
 * 
 */
public class InputHelper {
	/**
	 * @Title: type
	 * @Description: 在指定的对象里输入内容，该操作会清空之前的内容。
	 * @param locator
	 *            - 元素的标识 。 默认为id: 例 InputHelper.click("loginBtn"); id=id： 例如
	 *            id=loginBtn; name=name： 例如 name=username dom=jsExpress： 例如
	 *            dom=document.forms['myForm'].myDropdown xpath=xpathExpress：例如
	 *            //input[@name='name2' ] xpath=//input[@name='name2']
	 *            link=textPattern：例如 link=登陆 css=cssSelectorSyntax：例如
	 *            css=a[href="#id3"]
	 * 
	 * @param 输入的内容
	 * 
	 */
	public static void type(String locator, String text) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().clear(locator);
				WebDriverFactory.getMyDriverInst().type(locator, text);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					WebDriverFactory.getMyDriverInst().clear(locator);
					WebDriverFactory.getMyDriverInst().type(locator, text);
				}
			}
	}

	/**
	 * @Title: append
	 * @Description:在指定对象结尾追加内容，该操作不会清空之前的操作。
	 * @param locator:同方法type()中的locator
	 * @param text:追加的内容
	 */
	public static void append(String locator, String text) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().type(locator, text);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().type(locator, text);
			}
	}

	/**
	 * @Title: click
	 * @Description: 单击指定对象
	 * @param locator:同方法type()中的locator
	 * 			@return： void
	 */
	public static void click(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().click(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().click(locator);
			}
	}

	/**
	 * @Title: scroll
	 * @Description: TODO
	 * @param scrollLocator
	 * @param targetLocator
	 */
	public static void scroll(String scrollLocator, String targetLocator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().doScroll(scrollLocator, targetLocator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().doScroll(scrollLocator, targetLocator);
			}
	}

	/**
	 * @Title: jsClick
	 * @Description: TODO
	 * @param locator
	 */
	public static void jsClick(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().jsClick(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().jsClick(locator);
			}
	}

	/**
	 * @Title: getText
	 * @Description: 获得指定对象的Text内容
	 * @param locator
	 * @return
	 */
	public static String getText(String locator) {
		String tip = "";
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				tip = WebDriverFactory.getMyDriverInst().getText(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					tip = WebDriverFactory.getMyDriverInst().getText(locator);
				}
			}
		}
		return tip;
	}

	/**
	 * @Title: getAttribute
	 * @Description: 获得指定对象的某个属性值
	 * @param attributeLocator
	 *            指定对象的属性 格式 //input[@name='user']@offsetHeight
	 * 
	 * @return @return： String
	 */
	public static String getAttribute(String attributeLocator) {
		String value = "";
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				value = WebDriverFactory.getMyDriverInst().getAttribute(attributeLocator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					value = WebDriverFactory.getMyDriverInst().getAttribute(attributeLocator);
				}
			}
		}
		return value;
	}

	/**
	 * @Title: getValue
	 * @Description: 获得指定对象的Value值
	 * @param locator
	 * @return @return： String
	 */
	public static String getValue(String locator) {
		String value = "";

		int count = Constants.COUNT;
		while (count > 0) {
			try {
				value = WebDriverFactory.getMyDriverInst().getValue(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					value = WebDriverFactory.getMyDriverInst().getValue(locator);
				}
			}
		}
		return value;
	}

	/**
	 * @Title: doubleClick
	 * @Description: 双击指定对象
	 * @param locator
	 */
	public static void doubleClick(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().doubleClick(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().doubleClick(locator);
			}
	}

	/**
	 * @Title: contextMenu
	 * @Description: 显示指定对象的右键菜单
	 * @param locator
	 */
	public static void contextMenu(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().contextMenu(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().contextMenu(locator);
			}
	}

	/**
	 * @Title: clear
	 * @Description:清空指定对象的内容
	 * @param locator
	 */
	public static void clear(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().clear(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().clear(locator);
			}
	}

	/**
	 * @Title: check
	 * @Description: 选中指定的(Checkbox/Radiobox)对象
	 * @param locator
	 */
	public static void check(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().check(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().check(locator);
			}
	}

	/**
	 * @Title: uncheck
	 * @Description: 取消选中指定的(Checkbox/Radiobox)对象
	 * @param locator
	 */
	public static void uncheck(String locator) {
		int count = Constants.COUNT;
		while (count > 0)
			try {
				WebDriverFactory.getMyDriverInst().uncheck(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0)
					WebDriverFactory.getMyDriverInst().uncheck(locator);
			}
	}

	/**
	 * @Title: isChecked
	 * @Description: 判断指定的(Checkbox/Radiobox)对象是否被选中
	 * @param locator
	 * @return @return： boolean
	 */
	public static boolean isChecked(String locator) {
		boolean isCheck = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isCheck = WebDriverFactory.getMyDriverInst().isChecked(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isCheck = WebDriverFactory.getMyDriverInst().isChecked(locator);
				}
			}
		}
		return isCheck;
	}

	/**
	 * @Title: isTextExist
	 * @Description: 判断是否存在指定的text内容，范围为当前页面可访问的Frame
	 * @param text:
	 *            指定查找的内容
	 * @return @return： boolean:true 为存在 false 为不存在
	 */
	public static boolean isTextExist(String text) {
		boolean isPresent = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isPresent = WebDriverFactory.getMyDriverInst().isTextPresent(text);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isPresent = WebDriverFactory.getMyDriverInst().isTextPresent(text);
				}
			}
		}
		return isPresent;
	}

	/**
	 * @Title: isElementPresent
	 * @Description: 判断指定对象是否存在
	 * @param locator
	 * @return @return： boolean
	 */
	public static boolean isElementPresent(String locator) {
		boolean isPresent = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isPresent = WebDriverFactory.getMyDriverInst().isElementPresent(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isPresent = WebDriverFactory.getMyDriverInst().isElementPresent(locator);
				}
			}
		}
		return isPresent;
	}

	/**
	 * @Title: isVisible
	 * @Description: 判断指定对象是否可见
	 * @param locator
	 * @return @return： boolean
	 */
	public static boolean isVisible(String locator) {
		boolean isVisible = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isVisible = WebDriverFactory.getMyDriverInst().isVisible(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isVisible = WebDriverFactory.getMyDriverInst().isVisible(locator);
				}
			}
		}
		return isVisible;
	}

	/**
	 * @Title: isEditable
	 * @Description: 判断指定对象是否可编辑
	 * @param locator
	 * @return @return： boolean
	 */
	public static boolean isEditable(String locator) {
		boolean isEditable = false;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				isEditable = WebDriverFactory.getMyDriverInst().isEditable(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					isEditable = WebDriverFactory.getMyDriverInst().isEditable(locator);
				}
			}
		}
		return isEditable;
	}

	/**
	 * @Title: getElementPositionLeft
	 * @Description: 获得指定对象的位置X
	 * @param locator
	 * @return @return： Number
	 */
	public static Number getElementPositionLeft(String locator) {
		Number left = null;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				left = WebDriverFactory.getMyDriverInst().getElementPositionLeft(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					left = WebDriverFactory.getMyDriverInst().getElementPositionLeft(locator);
				}
			}
		}
		return left;
	}

	/**
	 * @Title: getElementPositionTop
	 * @Description: T获得指定对象的位置Y
	 * @param locator
	 * @return @return： Number
	 */
	public static Number getElementPositionTop(String locator) {
		Number top = null;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				top = WebDriverFactory.getMyDriverInst().getElementPositionTop(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					top = WebDriverFactory.getMyDriverInst().getElementPositionTop(locator);
				}
			}
		}
		return top;
	}

	/**
	 * @Title: getElementWidth
	 * @Description: 获得指定对象的宽度
	 * @param locator
	 * @return @return： Number
	 */
	public static Number getElementWidth(String locator) {
		Number width = null;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				width = WebDriverFactory.getMyDriverInst().getElementWidth(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					width = WebDriverFactory.getMyDriverInst().getElementWidth(locator);
				}
			}
		}
		return width;
	}

	/**
	 * @Title: getElementHeight
	 * @Description: 获得指定对象的高度
	 * @param locator
	 * @return @return： Number
	 */
	public static Number getElementHeight(String locator) {
		Number height = null;
		int count = Constants.COUNT;
		while (count > 0) {
			try {
				height = WebDriverFactory.getMyDriverInst().getElementHeight(locator);
				count = 0;
			} catch (Exception e) {
				--count;
				SleepHelper.sleep(Constants.INTERVAL);
				if (count == 0) {
					height = WebDriverFactory.getMyDriverInst().getElementHeight(locator);
				}
			}
		}
		return height;
	}

	/**
	 * @Title: getXpathCount
	 * @Description: 获得满足指定Xpath的条件的对象的个数
	 * @param locator
	 * @return @return： Number
	 */
	public static Number getXpathCount(String locator) {
		return WebDriverFactory.getMyDriverInst().getXpathCount(locator);
	}
}
