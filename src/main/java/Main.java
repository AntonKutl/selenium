import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().
                implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/vladivostok/orgtehnika_i_rashodniki?q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80");

        waitTime(12);

       // driver.manage().window().maximize();

       // System.out.println("Мы на странице " + driver.getTitle());


        /*WebElement elementСategory = driver.findElement(By.id("category"));
        Select select = new Select(elementСategory);
        select.selectByVisibleText("Оргтехника и расходники");

        waitTime(7);

        WebElement searchSearch = driver.findElement(By.id("search"));
        searchSearch.sendKeys("Принтер");
        searchSearch.sendKeys(Keys.RETURN);

        waitTime(7);

        driver.findElement(By.className("main-text-2PaZG")).click();

        waitTime(7);

        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");

        waitTime(7);

        driver.findElement(By.className("suggest-suggests-bMAdj")).findElements(By.tagName("li")).get(0).click();

        waitTime(7);

        driver.findElement(By.className("popup-buttons-NqjQ3")).click();*/



/*         if (!driver.findElement(By.xpath("//span[contains(text(), 'С Авито Доставкой')]")).isSelected()){

            driver.findElement(By.xpath("//span[contains(text(), 'С Авито Доставкой')]")).click();
        }


        waitTime(5);*/


        driver.findElement(By.xpath("//button[contains(@data-marker,'search-filters')])"));



        //driver.quit();

    }

    public static void waitTime(Integer sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
        }
    }
}
