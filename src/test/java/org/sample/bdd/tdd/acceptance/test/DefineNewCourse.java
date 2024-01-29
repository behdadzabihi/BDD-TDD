package org.sample.bdd.tdd.acceptance.test;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DefineNewCourse {

    @Given("I want to create webapi as course")
    public void createWebApi(){
        System.out.println("create webapi as course");
    }

    @When("I press add button")
    public void addButton(){
        System.out.println("add button");
    }

    @Then("webapi should be available on list")
    public void showOnList(){
        System.out.println("available on list");
    }


    @Given("I have already created webapi")
    public void AlreadyCreateWebApi(){
        System.out.println("already created webapi");
    }

    @When("I try to create it again")
    public void tryToCreate(){
        System.out.println("try to create");
    }

    @Then("webapi should not be appeared in list twice")
    public void notAppearedOnList(){
        System.out.println("not be appeared in list twice");
    }
}
