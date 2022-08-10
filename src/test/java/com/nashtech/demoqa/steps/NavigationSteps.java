package com.nashtech.demoqa.steps;

import com.nashtech.demoqa.context.ScenarioContext;
import com.nashtech.demoqa.pages.shared.NavigatePage;

public class NavigationSteps {

    NavigatePage navigationPage = new NavigatePage();
    ScenarioContext scenarioContext;
    public NavigationSteps(ScenarioContext context){
            scenarioContext = context;
        }

}
