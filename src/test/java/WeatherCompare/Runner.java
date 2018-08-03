package WeatherCompare;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.IOException;

public class Runner {
    WebDriver accDriver;
    WebDriver driver24;
    String [] low24;
    String [] high24;
    String [] lowacc;
    String [] highacc;
    boolean [] resmin = new boolean[4];
    boolean [] resmax = new boolean[4];


    @Test
    public void tester(){
        weath24(driver24);
        accw(accDriver);
        Compare();
// what we gonna test - call it here - this is like the main
        createXML objXML = new createXML();
        try {
            objXML.xmlcreate(lowacc,highacc,low24,high24,resmin,resmax);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void setupBeforeTest() throws IOException
    {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver/chromedriver.exe");
       driver24 = new ChromeDriver();
       String baseURL24 = "http://weather.news24.com/sa/richards-bay";
        driver24.get(baseURL24);
        accDriver = new ChromeDriver();
        String baseURL = "https://www.accuweather.com/en/za/richards-bay/4565/daily-weather-forecast/4565";
        accDriver.get(baseURL);
    }

    @After
    public void tearDown(){
        // TODO do not forget to close driver
        driver24.close();
        accDriver.close();
    }

    public void weath24(WebDriver driver){
        Weather24 weather24;
        weather24 = new Weather24(driver);
        low24 = weather24.low();
        high24 = weather24.high();


    }

    public void accw(WebDriver driver)
    {
        AccuWeather accuWeather;
        accuWeather = new AccuWeather(driver);
        lowacc = accuWeather.min();
        highacc = accuWeather.high();

    }


    public void Compare()
    {
      for(int i =0; i<4; i++)
      {
          resmin[i] = low24[i].equals(lowacc[i]);
          resmax[i] = highacc[i].equals(high24[i]);
      }
    }

}
