package org.example;


import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import java.util.Set;

public class Firefoxresolutiontest {
    public static WebDriver driver;



    public static void main(String[] args) throws IOException {



        Map<Integer, String> ex = new HashMap<Integer, String>();
        ex.put(1, "https://www.getcalley.com/calley-call-from-browser/");
        ex.put(2, "https://www.getcalley.com/pricing/");
        ex.put(3, "https://www.getcalley.com/best-auto-dialer-app/");
        ex.put(4,"https://www.getcalley.com/calley-pro-features/");
        ex.put(5,"https://www.getcalley.com/");

        Set<Map.Entry<Integer, String>> s = ex.entrySet();
        for(Map.Entry<Integer, String> x:s){

            System.out.println(x.getValue());

            driver = new FirefoxDriver();



            driver.get(x.getValue());
            driver.manage().window().maximize();

            Dimension[] resolutions = {new Dimension(1920, 1080),
                    new Dimension(1366, 768),
                    new Dimension(1536, 864),
                    new Dimension(360,640),
                    new Dimension(414,896),
                    new Dimension(375,667)};

            for(Dimension k:resolutions){
                driver.manage().window().setSize(k);
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

                File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

                String uniqueFileName2 = "_" + x.getKey() + "_" + k.getHeight() + "-" + k.getWidth();
                FileUtils.copyFile(screenshotFile, new File("C:\\Users\\DELL\\Desktop\\Automation Testing\\FirefoxUI Testing\\UITesting2"+uniqueFileName2+".png"));


            }

            driver.close();
            driver.quit();


        }
    }

}

