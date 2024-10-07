package DoubtsVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertThrows {
	@Test
	public void AssertThrowsVerify() {
		String str1 = null;
		String str2 = "abc";
		Assert.assertThrows(NullPointerException.class, () -> {
			str1.length(); // This code should throw a NullPointerException
		}); // Passes

		Assert.assertThrows(NullPointerException.class, () -> {
			int num = Integer.parseInt(str2); // This code should throw a java.lang.NumberFormatException
		}); // Fails because parseInt() doesn't throw a NullPointerException
		// java.lang.AssertionError: Expected NullPointerException to be thrown, but
		// NumberFormatException was thrown
	}

}
