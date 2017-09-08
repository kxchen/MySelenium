package cn.chenkaix.commons.helper;

import cn.chenkaix.commons.WebDriverFactory;

/**
 * @ClassName: DownloadHelper
 * @Description: TODO
 * @author: 15255391553@163.com
 * @date: 2017年9月4日
 * @bolg: https://kxchen.github.io
 * 
 */
public class DownloadHelper {
	//我用的这个版本的selenium没有实现，有空在写
	public static void downloadFile(String href, String path, String file) {
		//
		WebDriverFactory.getMyDriverInst().downloadFile(href, path, file);
	}
}
