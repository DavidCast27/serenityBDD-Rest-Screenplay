package com.davidcast27.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/find_a_user.feature"},
        glue = {"com.davidcast27.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class FindAUser {

}