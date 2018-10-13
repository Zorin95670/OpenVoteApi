package unit.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import models.User;
import services.UserService;

public class UserServiceTest {

    @Test
    public void testLoad() {
        final UserService service = new UserService();

        assertNull(service.load(null));

        final User user = new User();
        assertEquals(user, service.load(user));
    }
}
