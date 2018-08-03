package WeatherCompare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccuWeather {
    WebDriver driver;


    public AccuWeather(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public String[] min(){

        String [] min = new String[4];
        List <WebElement>  els  = driver.findElements(By.xpath("//*[@id='panel-main']/div[2]/div/div/div[2]/ul/li"));

        for(int i =0;i<4;i++)
        {
            String s = els.get(i+1).findElement(By.className("small-temp")).getAttribute("innerHTML");
            min[i] = (s.substring(1,s.length()-1)).trim();

        }
    return min;
    }

    public String[] high(){

        String [] high = new String[4];
        List <WebElement>  els  = driver.findElements(By.xpath("//*[@id='panel-main']/div[2]/div/div/div[2]/ul/li"));

        for(int i =0;i<4;i++)
        {
            String s = (els.get(i+1).findElement(By.className("large-temp")).getAttribute("innerHTML"));
            high[i] = (s.substring(0,s.length()-1)).trim();
        }
        return high;
    }

}
