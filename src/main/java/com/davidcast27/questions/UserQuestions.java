package com.davidcast27.questions;

import com.davidcast27.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.davidcast27.utils.constants.errosMessage.IMPOSIBLE_INSTANCIAR;

public class UserQuestions {

    private UserQuestions() {
        throw new RuntimeException(IMPOSIBLE_INSTANCIAR.getMensaje());
    }

    public static Question<List<User>> allTheExpectedUsers () {
        return actor -> {
            List<User> users = SerenityRest.lastResponse()
                    .jsonPath()
                    .getList("data", User.class);
            return users;
        };
    }

    public static Question<String> theExpectedUser () {
        return actor -> {
            return SerenityRest.lastResponse()
                    .jsonPath()
                    .getString("id");
        };
    }
}
