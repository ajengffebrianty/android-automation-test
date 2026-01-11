package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        try {
            DriverFactory.initDriver();
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @After
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception e) {
            System.err.println("Error during driver teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
