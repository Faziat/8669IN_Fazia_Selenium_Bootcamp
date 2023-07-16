package test_contactus;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends BasePage {
    private WebDriver driver;

    @Test(priority = 2)
    public void testContactUsFunctionality() {

        driver.get("https://www.bankofamerica.com/");

       WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
        contactUsLink.click();

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("John Doe");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("johndoe@example.com");

        WebElement messageField = driver.findElement(By.id("message"));
        messageField.sendKeys("This is a test message.");

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Thank you for your message.')]"));
       Assert.assertTrue(successMessage.isDisplayed(), "Contact form submission failed");
    }


    }

