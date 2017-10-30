package cn.chenkaix.assertion;

import java.util.Iterator;

import org.testng.internal.junit.ExactComparisonCriteria;
import org.testng.internal.junit.InexactComparisonCriteria;

public class Validate {
	public static void assertSame(Object expected, Object actual) {
		if (expected != actual) {
			fail(expected, actual);
		} else {
			ok(expected, actual);
		}
	}

	public static void assertNotSame(Object expected, Object actual) {
		if (expected == actual) {
			fail("Actual object:" + actual + ",expected a different object:" + expected);
		} else {
			ok(expected, actual);
		}
	}

	public static void assertEquals(Object expected, Object actual) {
		if (!expected.equals(actual)) {
			fail(expected, actual);
		} else {
			ok(expected, actual);
		}
	}

	public static void assertEquals(int expected, int actual) {
		assertEquals(new Integer(expected), new Integer(actual));
	}

	public static void assertEquals(long expected, long actual) {
		assertEquals(new Long(expected), new Long(actual));
	}

	public static void assertEquals(double expected, double actual) {
		assertEquals(new Double(expected), new Double(actual));
	}

	public static void assertEquals(double expected, double actual, double delta) {
		if (Math.abs(expected - actual) > delta) {
			fail(new Double(expected), new Double(actual));
		} else {
			ok(Double.valueOf(expected), Double.valueOf(actual));
		}
	}

	public static void assertEquals(float expected, float actual) {
		assertEquals(new Float(expected), new Float(actual));
	}

	public static void assertEquals(float expected, float actual, float delta) {
		if (Math.abs(expected - actual) > delta) {
			fail(new Float(expected), new Float(actual));
		} else {
			ok(Float.valueOf(expected), Float.valueOf(actual));
		}
	}

	public static void assertEquals(Iterable<?> iter1, Iterable<?> iter2) {
		assertEquals(iter1.iterator(), iter2.iterator());
	}

	public static void assertEquals(Iterator<?> iter1, Iterator<?> iter2) {
		boolean flag = false;
		while ((iter1.hasNext()) && (iter2.hasNext())) {
			if (!iter1.next().equals(iter2.next())) {
				flag = true;
			}
		}
		if (flag) {
			fail(iter1, iter2);
		} else {
			ok(iter1, iter2);
		}
	}

	public static void assertTrue(boolean condition) {
		if (!condition) {
			fail(Boolean.TRUE, Boolean.FALSE);
		} else {
			String message = "Assert true,and got true";
			ok(message, Boolean.valueOf(condition));
		}
	}

	public static void assertTrue(String message, boolean condition) {
		if (!condition) {
			fail(message);
		} else {
			ok(message);
		}
	}

	public static void assertFalse(boolean flag) {
		if (flag) {
			fail(Boolean.FALSE, Boolean.TRUE);
		} else {
			String message = "Assert false,and got false";
			ok(message);
		}
	}

	public static void assertFalse(String message, boolean condition) {
		assertTrue(message, !condition);
	}

	public static void assertNull(Object obj) {
		assertNull(null, obj);
	}

	public static void assertNotNull(Object obj) {
		if (obj == null) {
			fail(obj, null);
		} else {
			String message = "Assert not null,and got " + obj;
			ok(message);
		}
	}

	public static void assertException(Class<? extends Throwable> throwable, RetryRunner runner) {
		Class<? extends Throwable> exceptionClass = null;
		try {
			runner.run();
		} catch (Throwable e) {
			exceptionClass = e.getClass();
		}
		assertSame(throwable, exceptionClass);
	}

	public static void assertContain(String expected, String actual) {
		if ((expected == null) || (actual == null)) {
			fail("Expected actual[" + actual + "] contains [" + expected + "]");
		} else if (actual.contains(expected)) {
			ok("Expected actual[" + actual + "] contains [" + expected + "]");
		} else {
			fail("Expected actual[" + actual + "] contains [" + expected + "]");
		}
	}

	public static void fail() {
		fail("断言失败");
	}

	public static void fail(String message) {
		ResultAccumulator.INSTANCE.add(false, message);
	}

	private static void fail(Object expected, Object actual) {
		fail(null, expected, actual);
	}

	private static void fail(String message, Object expected, Object actual) {
		String info = "Expected \"" + expected + "\", but got \"" + actual + "\"";
		if (message != null) {
			info = message + ", " + info;
		}
		fail(info);
	}

	private static void ok(String message, Object expected, Object actual) {
		String info = "Expected \"" + expected + "\", and got \"" + actual + "\"";
		if (message != null) {
			info = message + ", " + info;
		}
		ok(info);
	}

	private static void ok(Object expected, Object actual) {
		ok(null, expected, actual);
	}

	private static void ok(String message) {
		ResultAccumulator.INSTANCE.add(true, message);
	}

	public static void assertEquals(String message, Object expected, Object actual) {
		if (equalsRegardingNull(expected, actual)) {
			ok(message, expected, actual);
			return;
		}
		if (((expected instanceof String)) && ((actual instanceof String))) {
			String cleanMessage = message == null ? "" : message;
			fail(cleanMessage, expected, actual);
		} else {
			failNotEquals(message, expected, actual);
		}
	}

	private static boolean equalsRegardingNull(Object expected, Object actual) {
		if (expected == null) {
			return actual == null;
		}
		return isEquals(expected, actual);
	}

	private static boolean isEquals(Object expected, Object actual) {
		return expected.equals(actual);
	}

	public static void assertNotEquals(String message, Object unexpected, Object actual) {
		if (equalsRegardingNull(unexpected, actual)) {
			failEquals(message, actual);
		}
		if (message != null) {
			message = message + ",Unexpected " + "\"" + unexpected + "\", and got \"" + actual + "\"";
		} else {
			message = "Unexpected \"" + unexpected + "\", and got \"" + actual + "\"";
		}
		ok(message);
	}

	public static void assertNotEquals(Object unexpected, Object actual) {
		assertNotEquals(null, unexpected, actual);
	}

	private static void failEquals(String message, Object actual) {
		String formatted = "Values should be different. ";
		if (message != null) {
			formatted = message + ". ";
		}
		formatted = formatted + "Actual: " + actual;
		fail(formatted);
	}

	public static void assertNotEquals(String message, long unexpected, long actual) {
		assertNotEquals(message, Long.valueOf(unexpected), Long.valueOf(actual));
	}

	public static void assertNotEquals(long unexpected, long actual) {
		assertNotEquals(null, unexpected, actual);
	}

	public static void assertNotEquals(String message, double unexpected, double actual, double delta) {
		if (!doubleIsDifferent(unexpected, actual, delta)) {
			failEquals(message, new Double(actual));
		} else {
			if (message != null) {
				message = message + ",Unexpected " + "\"" + unexpected + "\", and got \"" + actual + "\"";
			} else {
				message = "Unexpected \"" + unexpected + "\", and got \"" + actual + "\"";
			}
			ok(message);
		}
	}

	public static void assertNotEquals(double unexpected, double actual, double delta) {
		assertNotEquals(null, unexpected, actual, delta);
	}

	public static void assertNotEquals(float unexpected, float actual, float delta) {
		assertNotEquals(null, unexpected, actual, delta);
	}

	public static void assertArrayEquals(String message, Object[] expecteds, Object[] actuals) throws AssertionError {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(Object[] expecteds, Object[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, boolean[] expecteds, boolean[] actuals) {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(boolean[] expecteds, boolean[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, byte[] expecteds, byte[] actuals) {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(byte[] expecteds, byte[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, char[] expecteds, char[] actuals) {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(char[] expecteds, char[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, short[] expecteds, short[] actuals) {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(short[] expecteds, short[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, int[] expecteds, int[] actuals) {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(int[] expecteds, int[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, long[] expecteds, long[] actuals) {
		internalArrayEquals(message, expecteds, actuals);
	}

	public static void assertArrayEquals(long[] expecteds, long[] actuals) {
		assertArrayEquals(null, expecteds, actuals);
	}

	public static void assertArrayEquals(String message, double[] expecteds, double[] actuals, double delta) {
		try {
			new InexactComparisonCriteria(delta).arrayEquals(message, expecteds, actuals);

			ok(message);
		} catch (Error e) {
			fail(e.getMessage());
		}
	}

	public static void assertArrayEquals(double[] expecteds, double[] actuals, double delta) {
		assertArrayEquals(null, expecteds, actuals, delta);
	}

	public static void assertArrayEquals(String message, float[] expecteds, float[] actuals, float delta) {
		try {
			new InexactComparisonCriteria(delta).arrayEquals(message, expecteds, actuals);

			ok(message);
		} catch (Error e) {
			fail(e.getMessage());
		}
	}

	public static void assertArrayEquals(float[] expecteds, float[] actuals, float delta) {
		assertArrayEquals(null, expecteds, actuals, delta);
	}

	private static void internalArrayEquals(String message, Object expecteds, Object actuals) {
		try {
			new ExactComparisonCriteria().arrayEquals(message, expecteds, actuals);

			ok(message);
		} catch (Error e) {
			fail(e.getMessage());
		}
	}

	public static void assertEquals(String message, double expected, double actual, double delta) {
		if (doubleIsDifferent(expected, actual, delta)) {
			failNotEquals(message, new Double(expected), new Double(actual));
		} else {
			ok(message);
		}
	}

	public static void assertEquals(String message, float expected, float actual, float delta) {
		if (floatIsDifferent(expected, actual, delta)) {
			failNotEquals(message, new Float(expected), new Float(actual));
		} else {
			ok(message);
		}
	}

	public static void assertNotEquals(String message, float unexpected, float actual, float delta) {
		if (!floatIsDifferent(unexpected, actual, delta)) {
			failEquals(message, new Float(actual));
		} else {
			ok(message);
		}
	}

	private static boolean doubleIsDifferent(double d1, double d2, double delta) {
		if (Double.compare(d1, d2) == 0) {
			return false;
		}
		if (Math.abs(d1 - d2) <= delta) {
			return false;
		}
		return true;
	}

	private static boolean floatIsDifferent(float f1, float f2, float delta) {
		if (Float.compare(f1, f2) == 0) {
			return false;
		}
		if (Math.abs(f1 - f2) <= delta) {
			return false;
		}
		return true;
	}

	public static void assertEquals(String message, long expected, long actual) {
		assertEquals(message, Long.valueOf(expected), Long.valueOf(actual));
	}

	public static void assertNotNull(String message, Object object) {
		assertTrue(message, object != null);
	}

	public static void assertNull(String message, Object object) {
		if (object == null) {
			ok(message);
		} else {
			failNotNull(message, object);
		}
	}

	private static void failNotNull(String message, Object actual) {
		String formatted = "";
		if (message != null) {
			formatted = message + " ";
		}
		fail(formatted + "expected null, but was:<" + actual + ">");
	}

	public static void assertSame(String message, Object expected, Object actual) {
		if (expected == actual) {
			ok(message);
		} else {
			failNotSame(message, expected, actual);
		}
	}

	public static void assertNotSame(String message, Object unexpected, Object actual) {
		if (unexpected == actual) {
			failSame(message);
		} else {
			ok(message);
		}
	}

	private static void failSame(String message) {
		String formatted = "";
		if (message != null) {
			formatted = message + " ";
		}
		fail(formatted + "expected not same");
	}

	private static void failNotSame(String message, Object expected, Object actual) {
		String formatted = "";
		if (message != null) {
			formatted = message + " ";
		}
		fail(formatted + "expected same:<" + expected + "> was not:<" + actual + ">");
	}

	private static void failNotEquals(String message, Object expected, Object actual) {
		fail(format(message, expected, actual));
	}

	static String format(String message, Object expected, Object actual) {
		String formatted = "";
		if ((message != null) && (!message.equals(""))) {
			formatted = message + " ";
		}
		String expectedString = String.valueOf(expected);
		String actualString = String.valueOf(actual);
		if (expectedString.equals(actualString)) {
			return formatted + "expected: " + formatClassAndValue(expected, expectedString) + " but was: "
					+ formatClassAndValue(actual, actualString);
		}
		return formatted + "expected:<" + expectedString + "> but was:<" + actualString + ">";
	}

	private static String formatClassAndValue(Object value, String valueString) {
		String className = value == null ? "null" : value.getClass().getName();
		return className + "<" + valueString + ">";
	}
}
