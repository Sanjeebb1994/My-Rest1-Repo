package responseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyresponceTimeUsingHamcrestTest {
	
	@Test
	public void verifyTime() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(1360L),TimeUnit.MILLISECONDS)
			.log().all();
	}
}

