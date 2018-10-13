package unit.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

import models.User;
import utils.JsonUtils;

public class UserTest {

    @Test
    public void testGetterAndSetter() {
        final User user = new User();
        assertNull(user.getEmail());

        user.setEmail("test");
        assertEquals("test", user.getEmail());
    }

    @Test
    public void testBind() {
        Optional<User> opt;
        final User user = new User();
        final Map<String, String[]> map = new HashMap<>();

        opt = user.bind("key", map);
        assertNotNull(opt);
        assertTrue(opt.isPresent());
        assertNull(opt.get().getEmail());

        map.put("test", null);
        opt = user.bind("key", map);
        assertNotNull(opt);
        assertTrue(opt.isPresent());
        assertNull(opt.get().getEmail());

        map.put("email", new String[] { "test" });
        opt = user.bind("key", map);
        assertNotNull(opt);
        assertTrue(opt.isPresent());
        assertEquals("test", opt.get().getEmail());
    }

    @Test
    public void testUnBind() {
        final User user = new User();

        assertNotNull(user.unbind(null));
        assertEquals("email=null", user.unbind(null));

        user.setEmail("test");

        assertNotNull(user.unbind(null));
        assertEquals("email=test", user.unbind(null));
    }

    @Test
    public void testJavascriptUnbind() {
        final User user = new User();

        assertNotNull(user.javascriptUnbind());
        assertEquals(JsonUtils.convertToJsonString(User.class, user),
                user.javascriptUnbind());

        user.setEmail("test");

        assertNotNull(user.javascriptUnbind());
        assertEquals(JsonUtils.convertToJsonString(User.class, user),
                user.javascriptUnbind());
    }
}
