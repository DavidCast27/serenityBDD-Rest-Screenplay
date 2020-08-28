package com.davidcast27.task;

import com.davidcast27.models.User;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.davidcast27.utils.constants.errosMessage.IMPOSIBLE_INSTANCIAR;


public class UserTasks {

    private UserTasks() {
        throw new RuntimeException(IMPOSIBLE_INSTANCIAR.getMensaje());
    }

    public static Performable findUserById(int id) {
        return Task.where("{0} fetches the user with id #id",
                Get.resource("/users/{id}")
                        .with( request -> request.pathParam("id", id))
        );
    }

    public static Performable listAllUsers() {
        return Task.where("{0} fetches all users",
                Get.resource("/users")
        );
    }

    public static Performable addUser(String firstName, String lastName) {
        User newUser = new User(firstName, lastName);
        return Task.where("{0} fetches the user with id #id",
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body(newUser)
                        )
        );
    }


}
