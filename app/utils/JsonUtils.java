package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import play.Logger;

/**
 * Json's utilities.
 *
 * @author vincent
 *
 */
public final class JsonUtils {

    /**
     * Private constructor, do not use.
     */
    private JsonUtils() {
        throw new UnsupportedOperationException(
                "Private constructor, do not use it.");
    }

    /**
     * Convert object to Json string.
     *
     * @param clazz  Use for logger.
     * @param object Object to convert.
     * @return Json's string that represents object.
     */
    public static String convertToJsonString(final Class<?> clazz,
            final Object object) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            if (object == null) {
                throw new NullPointerException();
            }

            return mapper.writeValueAsString(object);
        } catch (final Exception e) {
            Logger.error("Error while converting " + clazz.getName()
                    + " to javascript.", e);
        }
        return null;
    }
}
