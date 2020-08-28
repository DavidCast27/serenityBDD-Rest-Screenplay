package com.davidcast27.stepdefinitions;

import com.davidcast27.exceptions.UserAssertionErros;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.davidcast27.exceptions.UserAssertionErros.*;
import static com.davidcast27.questions.UserQuestions.allTheExpectedUsers;
import static com.davidcast27.questions.UserQuestions.theExpectedUser;
import static com.davidcast27.task.UserTasks.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class WhenManagingUsers {

    @When("she/he find a user with id {int}")
    public void findAUserWithId(int id) {
        theActorInTheSpotlight().attemptsTo(findUserById(id));
    }

    @Then("user whit first name {string} and last name {string} should be correct")
    public void findAnIndividualUserWith(String firstName, String lastName) {
        theActorInTheSpotlight().should(
                seeThatResponse("User details should be correct",
                        response -> response
                                .body("data.first_name", equalTo(firstName))
                                .body("data.last_name", equalTo(lastName)))
                        .orComplainWith(UserAssertionErros.class, USER_DETAIL_NOT_CORRECT)
        );
    }


    @When("he/she list all users")
    public void listUsers() {
        theActorInTheSpotlight().attemptsTo(listAllUsers());
    }

    @Then("all {int} the expected users should be returned")
    public void allTheExpectedUsersShouldBeReturned(int size) {
        theActorInTheSpotlight().should(
                seeThat("all the expected users should be returned",
                        allTheExpectedUsers(), hasSize(size))
                        .orComplainWith(UserAssertionErros.class, NUMBER_USERS_RETURNED_DIFERENTS)
        );
    }

    @When("add a user with first name {string} and last name {string}")
    public void addUserWith(String firstName, String lastName) {
        theActorInTheSpotlight().attemptsTo(addUser(firstName, lastName));
    }

    @Then("the user was saved correctly")
    public void theUserWasSavedCorrectly() {
        theActorInTheSpotlight().should(
                seeThat("the user with first and last name was saved correctly",
                        theExpectedUser(), not(isEmptyString()))
                        .orComplainWith(UserAssertionErros.class, USER_NOT_SAVED)
        );
    }

    @Then("response status code is {int}")
    public void responseStatusCodeIs(int status) {
        theActorInTheSpotlight().should(
                seeThatResponse("Status code should be correct",
                        response -> response.statusCode(status))
                        .orComplainWith(UserAssertionErros.class, STATUS_CODE_NOT_CORRECT)
        );
    }

}
