package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgodaSearchHotelRoomPage extends AbstractPage
{
    public static String SEARCH_HOTEL_ROOM_PAGE_URL = "https://www.agoda.com/ru-ru/";

    By toInputLocator = By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[1]/div/div/input");
    private WebElement toInput;

    By findButtonLocator = By.xpath("//*[@id=\"SearchBoxContainer\"]/div[2]/button");
    private WebElement findButton;

    public AgodaSearchHotelRoomPage(WebDriver driver)
    {
        super(driver);
    }

    public AgodaSearchHotelRoomPage openPage()
    {
        driver.get(SEARCH_HOTEL_ROOM_PAGE_URL);
        toInput = findElementByLocator(toInputLocator);
        findButton = findElementByLocator(findButtonLocator);
        return this;
    }

    public AgodaSearchHotelRoomPage enterTo(String to)
    {
        toInput.sendKeys(to);
        WebElement listElement = getMatchingListElement(to);
        listElement.click();
        return this;
    }

    public AgodaSearchHotelRoomPage submit()
    {
        findButton.click();
        return this;
    }

    public String getDestination()
    {
        return getElement("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[1]/div/div/input").getText();
    }

    private WebElement getMatchingListElement(String name)
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.textToBe(By.xpath("//div[contains(text(), 'London, England')]"), name));
        return driver.findElement(By.xpath("//div[@class='recent-search-terms']/descendant::div[1]"));
    }

    private WebElement getElement(String xpath)
    {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }
}
