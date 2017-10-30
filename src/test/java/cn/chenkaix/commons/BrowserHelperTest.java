package cn.chenkaix.commons;

import org.junit.Test;

import cn.chenkaix.commons.helper.BrowserHelper;
import cn.chenkaix.commons.helper.InputHelper;
import cn.chenkaix.commons.helper.SleepHelper;

public class BrowserHelperTest {
	@Test
	public void testStsrt() throws Exception {
		BrowserHelper.start("firefox");
		BrowserHelper.open("http://www.cnblogs.com/xrq730/");
		SleepHelper.sleep("homepage1_HomePageDays_ctl00_DayList_TitleUrl_0", 5, 2000);
		InputHelper.click("homepage1_HomePageDays_ctl00_DayList_TitleUrl_0");
		
	}



}
