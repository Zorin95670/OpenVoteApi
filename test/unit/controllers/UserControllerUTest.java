package unit.controllers;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

import org.junit.Test;
import org.mockito.Mockito;

import controllers.UserController;
import models.User;
import play.mvc.Result;
import services.UserService;
import utils.JsonUtils;

public class UserControllerUTest {
    @Test
    public void test() throws Exception {
        final User user = new User();
        user.setEmail("test@gmail.com");

        final UserService mock = Mockito.mock(UserService.class);
        Mockito.when(mock.load(user)).thenReturn(user);

        final Result result = new UserController().load(user)
                .toCompletableFuture().get();
        assertEquals(OK, result.status());
        assertEquals("application/json", result.contentType().get());
        assertEquals(JsonUtils.convertToJsonString(User.class, user),
                contentAsString(result));
    }

}
