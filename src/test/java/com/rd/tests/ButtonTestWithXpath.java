package com.rd.tests;

        import com.rd.drivers.Driver;
        import com.rd.utils.PropertyManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.net.MalformedURLException;

public class ButtonTestWithXpath {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("ELEMENTS_URL");
    private static final By dynamicTextMessage = By.cssSelector("#dynamicClickMessage");



    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }


    @Test
    public void DemoQAOnGoogle(){

        //Buttons butonunu bul ve tıkla
        WebElement button = driver.findElement(new By.ByXPath("//span[contains(text(), 'Buttons')]"));
        button.click();

        //Click Me butonunu bul ve tıkla
        WebElement button2 = driver.findElement(new By.ByXPath("//button[starts-with(text(), 'Click Me')]"));
        button2.click();

        //Butona tıkladıktan sonra çıkan mesajı bul
        WebElement dynamicText = driver.findElement(dynamicTextMessage);

        String actualText = dynamicText.getText();
        String expectedText = "You have done a dynamic click";

        //Butona tıklandığında çıkan metnin doğrulunu karşılaştırma.
        Assert.assertEquals(actualText, expectedText, expectedText + " is not visible");

    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}

