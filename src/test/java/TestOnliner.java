import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestOnliner {
    private static final String CONDITION_ONE = "div.auth-bar__item:nth-child(1)";
    private static final String CONDITION_TWO = "div.auth-box__part:nth-child(1) > div:nth-child(1) > input:nth-child(1)";
    private static final String CONDITION_THREE = "div.schema-product__part.schema-product__part_2 >" +
            " div.schema-product__part.schema-product__part_4 > div.schema-product__title > a";
    private static final String CONDITION_FOUR = "div.offers-description__part.offers-description__part_1 > a";
    private static final String CONDITION_FIVE = "В корзину";
    private static final String CONDITION_SIX = "//*[@id=\"b-top-navigation-cart\"]/li/a/span";
    private static final String CONDITION_SEVEN = "//*[@id=\"cart-main-container\"]/div[3]/div[2]/a";
    private static final String CONDITION_EIGHT = "div.cart-product__part.cart-product__part_2 > div.cart-product-title > div > span";

    @Test
    public void checkOnliner() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/dev-tools/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://catalog.onliner.by/mobile");
        waitCssSearch(driver, CONDITION_ONE);
        driver.findElement(By.cssSelector(CONDITION_ONE)).click();
        waitCssSearch(driver, CONDITION_TWO);
        driver.findElement(By.cssSelector(CONDITION_TWO)).sendKeys("fanhead86");
        driver.findElement(By.cssSelector("div.auth-box__part:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys("123onliner");
        driver.findElement(By.xpath("/html[@class='non-responsive-layout']/body[@class='no-touch modal-visible']" +
                "/div[@id='modal-auth']/div[@class='modal-dialog']/div[@class='modal-content']/div[@id='auth-container']/div[@id='auth']" +
                "/div[@class='auth__inner']/div[@class='auth-main']/div[@class='auth-main__primary']/div[@id='auth-container__forms']" +
                "/div[@class='auth-box__inner auth-box__inner--form']/div[@class='auth-box__field']/form/div[@class='auth-box__part is-active'][2]" +
                "/div[@class='auth-box__line auth-box__line--final']/button[@class='auth-box__auth-submit auth__btn auth__btn--green']")).click();
//        sleep(30000);
        waitCssSearch(driver, CONDITION_THREE);
        driver.findElement(By.cssSelector(CONDITION_THREE)).click();
        waitCssSearch(driver, CONDITION_FOUR);
        driver.findElement(By.cssSelector(CONDITION_FOUR)).click();
        waitLinkTextSearch(driver, CONDITION_FIVE);
        driver.findElement(By.linkText(CONDITION_FIVE)).click();
        waitXpathSearch(driver, CONDITION_SIX);
        driver.findElement(By.xpath(CONDITION_SIX)).click();
        System.out.println("666");
        waitXpathSearch(driver, CONDITION_SEVEN);
        System.out.println("777");
        driver.findElement(By.cssSelector(CONDITION_EIGHT));
    }

    private void waitCssSearch(WebDriver driver, final String condition) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(By.cssSelector(condition)) != null) ? Boolean.TRUE : null;
            }
        });
    }
    private void waitLinkTextSearch(WebDriver driver, final String condition) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(By.linkText(condition)) != null) ? Boolean.TRUE : null;
            }
        });
    }
    private void waitXpathSearch(WebDriver driver, final String condition) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(By.xpath(condition)) != null) ? Boolean.TRUE : null;
            }
        });
    }
}