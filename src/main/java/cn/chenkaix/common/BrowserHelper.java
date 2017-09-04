package cn.chenkaix.common;

/**
 * @ClassName: BrowserHelper
 * @Description: 浏览器的操作帮助类
 * @author: 15255391553@163.com
 * @date: 2017年9月4日
 * @bolg: https://kxchen.github.io
 * 
 */
public class BrowserHelper {

	/**
	 * @Title: start
	 * @Description: TODO
	 * @param Browser;目前支持：firefox、chrome、ie
	 * 			@return： void
	 * @throws:
	 */
	public static void start(String Browser) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @Title: stop
	 * @Description: 关闭所有该WebTest实例浏览器，且停止WebTest实例。
	 * @param:
	 * @return: void
	 * @throws:
	 */
	public static void stop() {

	}

	/**
	 * @Title: close
	 * @Description: 关闭该WebTest实例当前的浏览器，不停止WebTest实例。
	 * @param:
	 * @return: void
	 * @throws:
	 */
	public static void close() {

	}

	/**
	 * @Title: windowMaximize
	 * @Description: 浏览器窗口最大化
	 * @param:
	 * @return: void
	 * @throws:
	 */
	public static void windowMaximize() {

	}

	/**
	 * @Title: getPageSource
	 * @Description: 获取当前页面所在frame的源码
	 * @return: String
	 * @throws:
	 */
	public static String getPageSource() {
		return null;
	}

	/**
	 * @Title: open
	 * @Description: 打开一个页面。
	 * @param: baseUrl
	 *             -要访问页面的url地址。例：http://127.0.0.1:8080/default/test.html
	 * @return: void
	 * @throws:
	 */
	public static void open(String baseUrl) {

	}

	/**
	 * @Title: selectWindow
	 * @Description: 浏览器切换到指定的窗口
	 * @param windowTitle
	 *            -指定的窗口标题
	 * @return: void
	 * @throws:
	 */
	public static void selectWindow(String windowTitle) {

	}

	/**
	 * @Title: goBack
	 * @Description: 点击页面的回退按钮
	 * @return: void
	 * @throws:
	 */
	public static void goBack() {

	}

	/**
	 * @Title: refresh
	 * @Description: 点击页面的刷新按钮
	 * @return: void
	 * @throws:
	 */
	public static void refresh() {

	}

	/**
	 * @Title: getLocation
	 * @Description: 获得当前浏览器显示页面的绝对路径
	 * @return: void
	 * @throws:
	 */
	public static void getLocation() {

	}

	/**
	 * @Title: getTitle
	 * @Description: 获得当前浏览器窗口的标题，只返回当前激活窗口的标题
	 * @return: void
	 * @throws:
	 */
	public static void getTitle() {

	}

	/**
	 * @Title: executeScript
	 * @Description: 在当前页面执行JS脚本
	 * @param express
	 *            -需要执行的js脚本
	 * @return: 需要返回值：JS脚本最后使用return，例如 return
	 *          document.window.title；不需要返回值：JS可以不需要使用return，例如 Alert("")
	 * @throws:
	 */
	public static String executeScript(String express) {
		return null;
	}

	/**
	 * @Title: getBrowserWindHandle
	 * @Description: 获得浏览器句柄
	 * @return @return： String
	 * @throws:
	 */
	public static String getBrowserWindHandle() {
		return null;
	}
}
