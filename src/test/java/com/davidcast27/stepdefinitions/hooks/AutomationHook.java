package com.davidcast27.stepdefinitions.hooks;


import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutomationHook {

    private static final String DEFAULT_ENVIROMENT = "restapi.baseurl";
    private static final String DEFAULT_PATH = "https://reqres.in/api";

    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;


    @Before
    public void prepareScenario() {
        OnStage.setTheStage(new OnlineCast());
        theRestApiBaseUrl = environmentVariables.optionalProperty(DEFAULT_ENVIROMENT)
                .orElse(DEFAULT_PATH);
        theActorCalled("actor");
        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
    
}
