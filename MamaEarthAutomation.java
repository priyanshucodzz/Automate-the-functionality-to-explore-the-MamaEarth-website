import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MamaEarthAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mamaearth.in/");

        
        if (driver.getTitle().contains("Mamaearth")) {
            System.out.println("Landed on the correct page");
            System.out.println("URL: " + driver.getCurrentUrl());
            System.out.println("Title: " + driver.getTitle());
        } else {
            System.out.println("Landed on the wrong page");
        }

      
        try {
            WebElement faceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Face']")));
            new Actions(driver).moveToElement(faceElement).perform();

            WebElement faceWashLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Face Wash']")));
            faceWashLink.click();
            System.out.println("Successfully navigated to Face Wash category");
        } catch (NoSuchElementException e) {
            System.out.println("Error navigating to Face Wash: Element not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error navigating to Face Wash: " + e.getMessage());
        }

       
        try {
            WebElement teaTreeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__next']/div[6]/div[6]/div/div/button[4]")));
            teaTreeCheckbox.click();
            System.out.println("Successfully sorted by Tea Tree");
        } catch (NoSuchElementException e) {
            System.out.println("Error sorting by Tea Tree: Element not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error sorting by Tea Tree: " + e.getMessage());
        }

        
        try {
            WebElement firstFaceWash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__next']/div[6]/div[8]/div[1]/section/section/div[1]/div[2]/div/div[2]/button")));
            firstFaceWash.click();
            System.out.println("Successfully selected a Face Wash");
        } catch (NoSuchElementException e) {
            System.out.println("Error selecting a Face Wash: Element not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error selecting a Face Wash: " + e.getMessage());
        }

       
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.get("https://mamaearth.in/");
        try {
            WebElement hairElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Hair']")));
            new Actions(driver).moveToElement(hairElement).perform();

            WebElement conditionerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Conditioner']")));
            conditionerLink.click();
            System.out.println("Successfully navigated to Conditioner category");
        } catch (NoSuchElementException e) {
            System.out.println("Error navigating to Conditioner: Element not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error navigating to Conditioner: " + e.getMessage());
        }

        // Sort by Henna
        try {
            WebElement hennaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__next']/div[6]/div[5]/div/div/button[8]")));
            hennaCheckbox.click();
            System.out.println("Successfully sorted by Henna");
        } catch (NoSuchElementException e) {
            System.out.println("Error sorting by Henna: Element not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error sorting by Henna: " + e.getMessage());
        }

       
        try {
            WebElement firstConditioner = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ProductCardWrapper")));
            firstConditioner.click();
            System.out.println("Successfully selected a Conditioner");

            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to Cart')]")));
            addToCartButton.click();
            System.out.println("Successfully added conditioner to cart");
        } catch (NoSuchElementException e) {
            System.out.println("Error adding conditioner to cart: Element not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error adding conditioner to cart: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}