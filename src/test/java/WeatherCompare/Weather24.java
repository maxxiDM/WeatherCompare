package WeatherCompare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Weather24 {
    WebDriver driver;


    public Weather24(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public String[] low(){
        String [] w24 = new String[4];
        String [] min = new String[4];
        int c = 0;
        for(int i =3;i<=6;i++)
        {
            w24[c] =  driver.findElement(By.xpath("//*[@id='div7DayForecast']/div/div/div["+i+"]")).getText();
            int minind = w24[c].indexOf("-");
            String sub = w24[c].substring(0,minind-3);
            int ind = sub.indexOf("y");
            min[c] = (sub.substring(ind+1,sub.length())).trim();
            c++;
        }
      return min;

    }

    public String[] high(){
        String [] w24 = new String[4];
        String [] max = new String[4];
        int c = 0;
        for(int i =3;i<=6;i++)
        {
            w24[c] =  driver.findElement(By.xpath("//*[@id='div7DayForecast']/div/div/div["+i+"]")).getText();
            int minind = w24[c].indexOf("-");
            int indC = w24[c].length()-2;
            max[c] = (w24[c].substring(minind+1,indC).trim());
            c++;
        }
        return max;
    }

}
