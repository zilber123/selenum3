import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.Keys.CONTROL;
import static org.openqa.selenium.Keys.TAB;
public class Homework {
    private Object args;


    @Test
    public void openBrowser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.get(Helper.WEB);


        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        Thread.sleep(400);
        WebElement loginField = driver.findElement(By.xpath(Helper.BOOKS));
        Thread.sleep(400);
        loginField.click();
        //switch with the help of actions class
        Actions action = new Actions(driver);
        action.keyDown(CONTROL).sendKeys(TAB).build().perform(); //opening the URL saved.

        WebElement loginField1 = driver.findElement(By.xpath(Helper.HOME));
        driver.manage().window().maximize();
        Thread.sleep(600);
        loginField1.click();
        driver.manage().window().maximize();
        WebElement loginField2 = driver.findElement(By.xpath(Helper.ABOUT));

        Thread.sleep(600);
        loginField2.click();
        driver.manage().window().maximize();
        WebElement loginField3 = driver.findElement(By.xpath(Helper.FOLLOW));

        Thread.sleep(600);
        loginField3.click();
        WebElement loginField4 = driver.findElement(By.xpath(Helper.Development));
        loginField4.click();



            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(3));
            Thread.sleep(600);
            {
                driver.get(Helper.projectScreenshots);
                Thread.sleep(600);
                //Take the screenshot
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Thread.sleep(600);
                //Copy the file to a location and use try catch block to handle exception
                try {
                    FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }driver.close();
        }

    }

//test2
            @Test
            public void openBrowser2() throws InterruptedException {
                WebDriver driver = new ChromeDriver();
                Thread.sleep(800);
                driver.get(Helper.WEB2);
                driver.manage().window().fullscreen();
                Thread.sleep(800);
                driver.manage().window().maximize();
                WebElement loginField1 = driver.findElement(By.xpath(Helper.CLICK2));
                loginField1.sendKeys(Helper.TAP );
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,250)", "300");
                Thread.sleep(800);
                WebElement loginField2 = driver.findElement(By.xpath(Helper.play));
                loginField2.click();
            }

     @Test
    public static void createFolder(String folderName, WebDriver driver) throws IOException {
        driver.manage().window().maximize();
        driver.get(Helper.WIKI);
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(4));
        String worksheets = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.WIKI2))).getText();
        File file = new File(Helper.FOLDER + Helper.TXT);
        FileWriter writer = new FileWriter(file);
        writer.write(worksheets);
        writer.close();
    }
    @Test
    public static void createFile(String pathname, String filename, String text) {
        File file = new File(pathname + filename);
        try {
            if (file.createNewFile()) {
                System.out.println("file was created");
            } else {
                System.out.println("file already exists");
            }
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}




















