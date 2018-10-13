package controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;

/**
 * User's controller.
 *
 * @author vincent
 *
 */
public class UserController extends Controller {

    /**
     * User's service.
     */
    private final UserService service = new UserService();

    /**
     * Load one user.
     *
     * @param user User to search
     * @return User
     */
    public CompletionStage<Result> load(final User user) {

        return CompletableFuture.supplyAsync(() -> {
            final User result = this.service.load(user);
            return ok(Json.toJson(result));
        });
    }
}
