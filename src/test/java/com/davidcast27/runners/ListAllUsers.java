package com.davidcast27.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/list_all_users.feature"},
        glue = {"com.davidcast27.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class ListAllUsers {

}