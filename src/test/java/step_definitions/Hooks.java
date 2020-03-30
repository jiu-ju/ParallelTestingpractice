package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Config;
import utilities.Driver;
import utilities.TempStorage;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(){
        // you can put anything that you want to run before each Scenario
        TempStorage.clear();

        System.out.println("Before hooks");
        Driver.getDriver().get(Config.getProperty("url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After hooks");
        //check if the scenario is failed

        if(scenario.isFailed()){
            //takes that screenshot
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // this takes screenshots and store it as byte
            //attach the scenario to the report
            scenario.embed(screenshot, "image/png");
        }

        Driver.quitDriver();
    }
    @After ("@database")
    public void tearDownConnection(){
        System.out.println("Closing DB connection");
        Driver.quitDriver();
    }
}


