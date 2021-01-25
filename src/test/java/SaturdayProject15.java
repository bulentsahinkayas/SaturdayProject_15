import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class SaturdayProject15 {
    public static void main(String[] args) {
            // Navigate to https://test.campus.techno.study/
       System.setProperty("webdriver.chrome.driver",MyConstant.DRIVER_PATH);
       WebDriver driver = new ChromeDriver();
       driver.get("https://test.campus.techno.study/");
        WebDriverWait wait = new WebDriverWait(driver,10);
        // Dismiss the cookie message by clicking on "Got it!" button
        WebElement gotIt;
       gotIt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cookieconsent div div a")));
       gotIt.click();

       driver.manage().window().maximize();
                // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
       driver.findElement(By.id("mat-input-0")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("TechnoStudy123@");
        driver.findElement(By.cssSelector("form > button > span.mat-button-wrapper")).click();

                    // Click on Setup in the left menu
        WebElement setUp1;
        setUp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.navbar-content div div a span")));
        setUp1.click();

                        // Click on School Setup
        WebElement schoolSetup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2)")));
        schoolSetup.click();

                        // Click on Departments
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".group-items > :nth-child(1) fuse-nav-vertical-collapsable:nth-child(2) > div > fuse-nav-vertical-item:nth-child(6) > a"))).click();

                        // Click on "+" button to add a school department
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-table-toolbar > div ms-add-button"))).click();

                        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code.
        WebElement enterSchoolName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")));
        enterSchoolName.sendKeys("High School");
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.CODE'] > input")).sendKeys("HS-1");

                        // Click on "Section" tab
        WebElement enterSection = driver.findElement(By.xpath("//div[text()='Section']"));
        enterSection.click();
                    // Click on "+" button to ad a new section.
                    // Type "Junior Classes" for the name of the section and "Juniors" for the short name and click on "Add" button to create the section.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ms-text-field-2"))).sendKeys("Junior Classes");
        driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input")).sendKeys("Juniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();
                // Create another section with the name "Senior Classes" and the short name "Seniors" similarly.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#ms-text-field-2"))).sendKeys("Senior Classes");
        driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.SHORTNAME']>input")).sendKeys("Seniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();
        // Click on "Save" for creating the school department.
        driver.findElement(By.cssSelector("ms-save-button>button")).click();

        // Verify if the department with the name "High School" created. It should write "School Department successfully created." on the console.
        WebElement displayHS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='High School']")));
        if(displayHS.isDisplayed()){
            System.out.println("School Department successfully created.");
        } else {
            System.out.println("A problem has occurred while creating a new school department!");
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='alertdialog']")));

                // Click on "+" button to add a school department AGAIN
        driver.findElement(By.cssSelector("ms-add-button[tooltip=\"SCHOOL_DEPARTMENT.TITLE.ADD\"]")).click();

            // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code AGAIN
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"name\"]>input")).sendKeys("High School");
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"code\"]>input")).sendKeys("HS-1");

        // Click on "Save" for TRYING to create a school department with the same name.
        driver.findElement(By.cssSelector("ms-save-button>button")).click();

        // Verify that a dialog box occurs with a message "There is already Department with "High School" name!". It should write the message of the dialog box on the console.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='alertdialog']")));
              System.out.println(driver.findElement(By.cssSelector("div[role='alertdialog']")).getText());

                    // Click on "Save" for TRYING to create a school department with the same name.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Close dialog']"))).click();
        // Click on edit button (or the row) of the "High School" department to edit it.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody[role='rowgroup']>tr:first-child ms-edit-button"))).click();

            // Edit the school department name as "High School Classes" and department code as "HSC-1" and click on "Save"
        WebElement editSchoolSetup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ms-text-field-12 > input")));
        editSchoolSetup.clear();
        editSchoolSetup.sendKeys("High School Classes");

        WebElement editSchoolCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='GENERAL.FIELD.CODE'] > input")));
        editSchoolCode.clear();
        editSchoolCode.sendKeys("HSC-1");
        driver.findElement(By.cssSelector("ms-save-button>button")).click();
                // Verify if the department name was edited as "High School Classes" and department code was edited as "HSC-1"
                // It should write "School Department name successfully edited." on the console.
                // And it should write "School Department code successfully edited." on the console.
        if(displayHS.isDisplayed()){
            System.out.println("School Department successfully created.");
        } else {
            System.out.println("A problem has occurred while creating a new school department!");
        }
        WebElement codeDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()=' HSC-1 ']")));
        if (codeDisplay.isDisplayed()) {
            System.out.println("School Department code successfully edited.");
        } else {
            System.out.println("A problem has occurred while editing the school department code!");
        }
            // Click on corresponding trash icon
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-delete-button.ng-star-inserted>button>span>fa-icon>svg"))).click();
                // Click on "Yes" for deleting the school department.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mat-dialog-4 app-simple-dialog div div button"))).click();
            // Verify the department is deleted. (it should not be present in the table anymore)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='alertdialog']")));
        List<WebElement> departmentNames = driver.findElements(By.cssSelector("td:nth-child(2)"));
        boolean isDeleted = true;
        for (WebElement departmentName : departmentNames) {
            if (departmentName.getText().equals("High School Classes")) {
                System.out.println(departmentName.getText());
                isDeleted = false;
                break;
            }
        }
        if (isDeleted) {
            System.out.println("School Department successfully deleted.");
        } else {
            System.out.println("A problem has occurred while deleting the school department!");
        }

        // Close the browser
        driver.quit();
    }
}


