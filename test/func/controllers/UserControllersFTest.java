package func.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import play.mvc.Http.RequestBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

public class UserControllersFTest extends WithApplication {

	@Test
	public void test() {
		final RequestBuilder request = Helpers.fakeRequest("GET", "/User?email=test");
		final Result result = Helpers.route(this.provideApplication(), request);
		assertEquals(Helpers.OK, result.status());
	}
}
