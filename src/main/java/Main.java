import org.openqa.selenium.*;
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
        driver.get("https://www.avito.ru");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitTime(5);

        driver.manage().window().maximize();

        System.out.println("Мы на странице " + driver.getTitle());

        //Выбрать в выпадающем списке “категория”  значение оргтехника и расходники
        WebElement elementСategory = driver.findElement(By.id("category"));
        Select select = new Select(elementСategory);
        select.selectByVisibleText("Оргтехника и расходники");

        //В поле поиск по объявлению ввести значение “Принтер”
        WebElement searchSearch = driver.findElement(By.id("search"));
        searchSearch.sendKeys("Принтер");
        searchSearch.sendKeys(Keys.RETURN);


        //Нажать на поле город
        driver.findElement(By.className("main-text-2PaZG")).click();

        waitTime(3);

        //Заполнить значением “Владивосток” поле город  в открывшемся окне и кликнуть по первому предложенному варианту.
        // Нажать на кнопку “Показать объявления”
        driver.findElement(By.className("suggest-input-3p8yi")).sendKeys("Владивосток");
        waitTime(4);
        driver.findElement(By.className("suggest-suggests-bMAdj")).findElements(By.tagName("li")).get(0).click();
        waitTime(3);
        driver.findElement(By.className("popup-buttons-NqjQ3")).click();
        waitTime(6);

        //Прокрутка страницы
        WebElement checkDelivery = driver.findElement(By.xpath("//div[@data-marker=\"delivery-filter/container\"]"));
        js.executeScript("arguments[0].scrollIntoView();", checkDelivery);

        //Проверить, активирован ли чекбокс, и если не активирован – активировать и нажать кнопку “Показать объявления”
        if (!driver.findElement(By.xpath("//span[contains(text(), 'С Авито Доставкой')]")).isSelected()) {
            driver.findElement(By.xpath("//span[contains(text(), 'С Авито Доставкой')]")).click();
        }

        waitTime(5);

        //Эмуляция нажатия кнопки "Показать Х элементов"
        driver.findElement(By.xpath("//button[contains(@data-marker,'search-filters')]")).click();

        waitTime(5);

        //Выбор фильтрации по убыванию
        WebElement elementSelect = driver.findElement(By.xpath("//select[contains(@class,'select-select-3CHiM')]"));
        elementSelect.findElement(By.xpath("//option[. = 'Дороже']")).click();

        //Печать в консоль название и цену 3 самых дорогих принтеров
        List<WebElement> name = driver.findElements(By.xpath("//h3[contains(@itemprop,'name')]"));
        List<WebElement> cost = driver.findElements(By.xpath("//span[contains(@class,'price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo')]"));
        for (int i = 0; i < 3; i++) {
            System.out.println(name.get(i).getText() + " цена " + cost.get(i).getText());
        }

        driver.quit();

    }

    public static void waitTime(Integer sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
        }
    }
}
