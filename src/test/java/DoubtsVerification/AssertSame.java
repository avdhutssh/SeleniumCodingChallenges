package DoubtsVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertSame {
	@Test
	public void AssertSameVerify() {
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");

		Assert.assertSame(str1, str2); // Passes
		Assert.assertSame(str1, str3); // Fails

	}
}
