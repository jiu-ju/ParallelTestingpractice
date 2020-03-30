package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Etsy_HomePage;
import utilities.Config;
import utilities.Driver;

public class EtsySearch_StepDefs {

    Etsy_HomePage etsy_homePage = new Etsy_HomePage();

    @Given("User is on Etsy home page")
    public void user_is_on_Etsy_home_page() {
        Driver.getDriver().get(Config.getProperty("etsyURL"));
    }

    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
// use the object to sendKeys into SearchBox
        etsy_homePage.searchBox.sendKeys("wooden spoon" + Keys.ENTER);
    }

    @Then("User should see wooden spoon in Etsy title")
    public void user_should_see_wooden_spoon_in_Etsy_title() {
// compare actual title vs expected title
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "Wooden spoon";
        // all the items in TITILE on etsy are coming with capital letter

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
    @When("User searches for {string}")
    public void user_searches_for(String searchValue) {
        etsy_homePage.searchBox.sendKeys(searchValue + Keys.ENTER);
    }

    @Then("User should see {string} in Etsy title")
    public void user_should_see_in_Etsy_title(String searchValue) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = searchValue;
        // all the items in TITILE on etsy are coming with capital letter

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
}

