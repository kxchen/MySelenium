package cn.chenkaix.util;

import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;

public class ReadProperties {
	private static final Logger log = Logger.getLogger(ReadProperties.class);
	private final static String APP = "app"; // 属性文件名称

	/**
	 * 方法描述 获取配置文件信息
	 * 
	 * @author HEC263
	 * @time 2018年3月8日 上午10:44:05
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfig(String key) {
		try {
			PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle.getBundle(APP);
			log.debug("输入: " + key + "  =====>>   获取到：" + prb.getString(key));
			return prb.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		return null;

	}

}
