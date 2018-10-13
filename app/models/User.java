package models;

import java.util.Map;
import java.util.Optional;

import play.mvc.QueryStringBindable;
import utils.JsonUtils;

/**
 * User's model.
 *
 * @author vincent
 *
 */
public class User implements QueryStringBindable<User> {

    /**
     * User's email.
     */
    private String email;

    /**
     * Get user's email.
     *
     * @return User's email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set user's email.
     *
     * @param email Email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public final Optional<User> bind(final String key,
            final Map<String, String[]> data) {
        if (data.containsKey("email")) {
            this.setEmail(data.get("email")[0]);
        }
        return Optional.of(this);
    }

    @Override
    public final String unbind(final String key) {
        return new StringBuilder().append("email=").append(this.getEmail())
                .toString();
    }

    @Override
    public final String javascriptUnbind() {
        return JsonUtils.convertToJsonString(this.getClass(), this);
    }
}
