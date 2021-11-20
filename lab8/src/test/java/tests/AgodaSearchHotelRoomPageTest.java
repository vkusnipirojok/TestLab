package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AgodaSearchHotelRoomPage;

public class AgodaSearchHotelRoomPageTest
{
    private WebDriver driver;

    @BeforeMethod
    public void browserSetup() throws  InterruptedException {
//        ChromeOptions options = new ChromeO           ptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
//                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
//                "--disable-gpu", "--ignore-certificate-errors");
        driver = new ChromeDriver(/*options*/);
    }

    @Test
    public void testSearchHotelRoom()
    {
        String destination = "Милан";

        AgodaSearchHotelRoomPage searchHotelRoomPage = new AgodaSearchHotelRoomPage(driver)
                .openPage()
                .enterTo(destination)
                .submit();
        String sandd = searchHotelRoomPage.getDestination();

        Assert.assertTrue(
                sandd.contains(destination));
    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
