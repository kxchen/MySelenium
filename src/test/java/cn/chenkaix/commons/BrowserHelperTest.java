package cn.chenkaix.commons;

import org.junit.Test;

import cn.chenkaix.commons.helper.BrowserHelper;
import cn.chenkaix.commons.helper.InputHelper;

public class BrowserHelperTest {
	@Test
	public void testStsrt() throws Exception {
		BrowserHelper.start("firefox");
		BrowserHelper.open("http://www.cnblogs.com/xrq730/");
		InputHelper.click("homepage1_HomePageDays_ctl00_DayList_TitleUrl_0");

	}



}
