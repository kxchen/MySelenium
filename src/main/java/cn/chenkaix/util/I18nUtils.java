package cn.chenkaix.util;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static cn.chenkaix.util.Constants.LAGUANGE;

public class I18nUtils {
	static ApplicationContext i18n = new ClassPathXmlApplicationContext("spring-config.xml");

	public static String getI18nResourceMessage(String key, String[] result) {
		try {
			if (LAGUANGE.equals("en_US")) {
				return i18n.getMessage(key, result, Locale.US);
			}
			if (LAGUANGE.equals("zh_CN")) {
				return i18n.getMessage(key, result, Locale.CHINA);
			}
			return null;
		} catch (NoSuchMessageException e) {
		}
		return null;
	}

	public static String getI18nResourceMessage(String key) {
		try {
			if (LAGUANGE.equals("en_US")) {
				return i18n.getMessage(key, null, Locale.US);
			}
			if (LAGUANGE.equals("zh_CN")) {
				return i18n.getMessage(key, null, Locale.CHINA);
			}
			return null;
		} catch (NoSuchMessageException e) {
		}
		return null;
	}
}
