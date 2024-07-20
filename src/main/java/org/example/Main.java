package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    WebDriver driver;


    @BeforeEach
    public void beforeEach() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://stackoverflow.com");
        waitFewSeconds(driver);
    }

    @Test
    public void acceptAllCookiesAndNavigateToModeratorUsers() throws InterruptedException {

        WebElement buttonAcceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        buttonAcceptCookies.click();

        waitFewSeconds(driver);

       navigateToModeratorUsers(driver);
    }

    @Test
    public void rejectAllCookiesAndNavigateToModeratorUsers() throws InterruptedException {

        WebElement buttonRejectCookies = driver.findElement(By.id("onetrust-reject-all-handler"));
        buttonRejectCookies.click();

        waitFewSeconds(driver);

       navigateToModeratorUsers(driver);
    }

    private void navigateToModeratorUsers(WebDriver driver) throws InterruptedException {

        WebElement buttonUsers = driver.findElement(By.id("nav-users"));
        buttonUsers.click();

        waitFewSeconds(driver);

        WebElement moderators = driver.findElement(By.cssSelector("[data-value='moderators']"));
        moderators.click();

        waitFewSeconds(driver);
    }

    @AfterEach
    public void afterEach() {

        driver.quit();
    }

    private void waitFewSeconds(WebDriver driver) throws InterruptedException {

        Thread.sleep(500);
    }
}