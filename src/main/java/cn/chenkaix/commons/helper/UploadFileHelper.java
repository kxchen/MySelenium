package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;

/**
 * @ClassName: UploadFileHelper
 * @Description: 上传文件帮助类
 * @author: 15255391553@163.com
 * @date: 2017年9月7日 下午11:28:39
 * @bolg: https://kxchen.github.io
 * 
 */
public class UploadFileHelper {

	/**
	 * @Title: uploadFile
	 * @Description: 在指定上传对象上上传指定文件,文件路径为绝对路径
	 * @param locator
	 *            元素的标识 默认为id: 例如 InputHelper.click("loginBtn"); id=id： 例如
	 *            id=loginBtn; name=name： 例如 name=username dom=jsExpress： 例如
	 *            dom=document.forms['myForm'].myDropdown xpath=xpathExpress：例如
	 *            //input[@name='name2' ] xpath=//input[@name='name2']
	 *            link=textPattern：例如 link=登陆 css=cssSelectorSyntax：例如
	 *            css=a[href="#id3"]
	 * @param path
	 * 			@return： void
	 * @throws:
	 */
	public static void uploadFile(String locator, String path) {
		WebDriverFactory.getMyDriverInst().type(locator, path);
	}

	/**
	 * @Title: uploadFileByPackagePath
	 * @Description: 在指定上传对象上上传指定文件，文件路径为classloader的相对路径
	 * @param locator
	 *            元素的标识 默认为id: 例如 InputHelper.click("loginBtn"); id=id： 例如
	 *            id=loginBtn; name=name： 例如 name=username dom=jsExpress： 例如
	 *            dom=document.forms['myForm'].myDropdown xpath=xpathExpress：例如
	 *            //input[@name='name2' ] xpath=//input[@name='name2']
	 *            link=textPattern：例如 link=登陆 css=cssSelectorSyntax：例如
	 *            css=a[href="#id3"]
	 * @param packagePath
	 * 			@return： void
	 * @throws:
	 */
	public static void uploadFileByPackagePath(String element, String packagePath) {
		if (packagePath.startsWith("\\")) {
			uploadFile(element, getPath(packagePath.substring("\\".length())));
			return;
		}
		uploadFile(element, getPath(packagePath));
	}

	/**
	 * @Title: getPath
	 * @Description: 获得当前jvm的classloader的路径
	 * @param locator
	 *            不跟分隔符 例如： test/test.txt
	 * @param path
	 *            路径 使用/当分隔符
	 * @throws:
	 */
	public static String getPath(String packagePath) {
		String fullPath = "";
		try {
			fullPath = UploadFileHelper.class.getProtectionDomain().getClassLoader()
					.getResource(packagePath.replace("\\", "/")).getFile();
			return fullPath.substring(1);
		} catch (NullPointerException jarPath) {
			String jarPath1 = WebDriverFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();

			if (jarPath1.endsWith("jar")) {
				int index = jarPath1.lastIndexOf("/");
				fullPath = jarPath1.substring(0, index + 1) + packagePath.replace("\\", "/");
				return fullPath.substring(1);
			}
			fullPath = jarPath1;
		}
		return fullPath.substring(1);
	}
}
