package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;

public class Hooks {

    private BasePage basePage;

    @Before
    public void setUp() throws Exception {
        try {
            if (!DriverFactory.isDriverInitialized()) {
                DriverFactory.initDriver();
            }
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @After
    public void resetApp() {
        try {
            basePage = new BasePage();
            basePage.backToHome();
        } catch (Exception e) {
            System.err.println("Error during driver teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
