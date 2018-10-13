package unit.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import utils.JsonUtils;

public class JsonUtilsTest {

    @Test
    public void testConstructor() {
        Throwable exception = null;

        try {
            final Constructor<JsonUtils> constructor = JsonUtils.class
                    .getDeclaredConstructor();
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (final Exception e) {
            exception = e.getCause();
        }
        assertNotNull(exception);
        assertEquals(UnsupportedOperationException.class.getName(),
                exception.getClass().getName());
        assertEquals("Private constructor, do not use it.",
                exception.getMessage());
    }

    @Test
    public void testConvertToJsonString() throws Exception {
        assertNotNull(JsonUtils.convertToJsonString(null, "test"));
        assertNull(JsonUtils.convertToJsonString(String.class, null));
    }
}
