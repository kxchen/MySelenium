package cn.chenkaix.assertion;

public class ExactComparisonCriteria extends ComparisonCriteria {
	protected void assertElementsEqual(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}
}
