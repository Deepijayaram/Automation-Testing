package org.example;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class FunctionalTesting {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.dealsdray.com/");
        driver.findElement(By.className("css-l8vkz1")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.className("css-r71t31")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.cssSelector(".MuiButton-containedSizeMedium")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@class='sidenavHoverShow css-1s178v5']")).click();
        driver.findElement(By.className("css-13ded6j")).click();
        Thread.sleep(2000);

        WebElement Fullweb=driver.findElement(By.id("root"));
        Fullweb.click();

        driver.findElement(By.xpath("//*[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-vwfva9']")).click();
        Thread.sleep(2000);
        WebElement choosefile= driver.findElement(By.className("css-uodm64"));
        choosefile.click();
        Thread.sleep(3000);
//        choosefile.sendKeys("C:/Users/DELL/Downloads/demo-data");

        Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\UploadFile.exe");
        Thread.sleep(5000);
        driver.findElement(By.className("css-6aomwy")).click();
        driver.findElement(By.className("css-6aomwy")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
        driver.findElement(By.className("css-adjfm3")).click();
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.xpath("//button[text()='Next']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", e);

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(screenshotFile, new File("C:\\Users\\DELL\\Desktop\\Automation Testing\\Functional Testing\\FunctionalTesting1.png"));
         driver.close();
         driver.quit();
    }
}
