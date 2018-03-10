package cn.chenkaix.util;

public final class Constants {
	private Constants() {
	    
	}
	public static final int COUNT = 5;
	public static final int INTERVAL = 500;
	
	
	//测试应用配置信息
	public static final String URL = ReadProperties.getConfig("url");
	public static final String USERNAME = ReadProperties.getConfig("username");
	public static final String PASSWORD = ReadProperties.getConfig("password");
	public static final String LAGUANGE = ReadProperties.getConfig("laguange");
	public static final String BROWSER = ReadProperties.getConfig("browser");
	
	//数据库配置信息
	public static final String JDBC_DRIVERCLASSNAME = ReadProperties.getConfig("jdbc.driverClassName");
	public static final String JDBC_URL = ReadProperties.getConfig("jdbc.url");
	
	/**
	 * 数据库连接用户名
	 */
	public static final String JDBC_USERNAME = ReadProperties.getConfig("jdbc.username");
	public static final String JDBC_PASSWORD = ReadProperties.getConfig("jdbc.password");
	public static final String DATABASE_TYPE = ReadProperties.getConfig("datebase.type");
	
	//脚本调试配置信息
	public static final String RESULT_PRINT = ReadProperties.getConfig("result.print");
	public static final String VALIDATE = ReadProperties.getConfig("validate");
	
	//浏览器配置信息
	public static final String FIREFOX_DRIVER_PATH= ReadProperties.getConfig("firefox.driver.path");
	public static final String FIREROX_APP_PATH=ReadProperties.getConfig("firefox.app.path");
	public static final String CHROME_DRIVER_PATH=ReadProperties.getConfig("chrome.driver.path");
	public static final String CHROME_APP_PATH=ReadProperties.getConfig("chrome.app.path");
	public static final String IE_DRIVER_PATH=ReadProperties.getConfig("ie.driver.path");
	public static final String IE_APP_PATH=ReadProperties.getConfig("ie.app.path");
	

}
