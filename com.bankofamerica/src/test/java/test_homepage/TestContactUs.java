package test_homepage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUs extends BasePage {
    private WebDriver driver;

    @Test(priority = 1)
    public void testContactUsFunctionality() {
        // Step 1: Open the Bank of America website
        driver.get("https://www.bankofamerica.com/");

        // Step 2: Click on the "Contact Us" link
       WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
        contactUsLink.click();

        // Step 3: Fill in the contact form
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("John Doe");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("johndoe@example.com");

        WebElement messageField = driver.findElement(By.id("message"));
        messageField.sendKeys("This is a test message.");

        // Step 4: Submit the contact form
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        // Step 5: Verify the success message
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Thank you for your message.')]"));
       Assert.assertTrue(successMessage.isDisplayed(), "Contact form submission failed");
    }


    }

