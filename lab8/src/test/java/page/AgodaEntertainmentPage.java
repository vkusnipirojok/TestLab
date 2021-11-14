package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgodaEntertainmentPage extends AbstractPage
{
    public static String ENTERTAINMENT_PAGE_URL = "https://thingstodo-agoda.partner.viator.com/?utm_source=web&utm_medium=whitelabel-linkout&utm_campaign=home-header-thingstodo-links";

    @FindBy(xpath = "//*[@id=\"searchBar\"]/div/div[1]/div/div[1]/input")
    private WebElement toInput;

    @FindBy(xpath = "//*[@id=\"searchBar\"]/div/div[2]/button/span")
    private WebElement findButton;


    public TravelYandexTrainsPage(WebDriver driver)
    {
        super(driver);
    }

    public AgodaEntertainmentPage openPage()
    {
        driver.get(ENTERTAINMENT_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"searchBar\"]/div/div[1]/div/div[1]/input")));
        return this;
    }

    public AgodaEntertainmentPage enterTo(String to)
    {
        toInput.sendKeys(to);
        WebElement listElement = getMatchingListElement(to);
        listElement.click();
        return this;
    }

    public AgodaEntertainmentPage submit()
    {
        findButton.click();
        return this;
    }

    public String getDestination()
    {
        return getElement("//*[@id=\"searchBar\"]/div/div[1]/div/div[1]/input").getText();
    }

    private WebElement getMatchingListElement(String name)
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"searchBar\"]/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/span[1]","//*[@id=\"searchBar\"]/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div/span[2]"), name));
        return driver.findElement(By.xpath("//*[@id=\"searchBar\"]/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div"));
    }

    private WebElement getElement(String xpath)
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }
}
