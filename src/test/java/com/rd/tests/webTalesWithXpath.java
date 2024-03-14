package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
public class webTalesWithXpath {
    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("WEBTABLES_URL");
    private static final By dynamicTextMessage = By.cssSelector("#dynamicClickMessage");



    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void WebTablesXpath(){

        //Yeni Kayıt eklemek için Add butonunu bul ve tıkla
        WebElement button = driver.findElement(new By.ByXPath("//button[@id=\"addNewRecordButton\"]"));
        button.click();

        //Form elemanlarını bul, tıkla, doldur ve kaydet
        WebElement firstName = driver.findElement(new By.ByXPath("//input[@id=\"firstName\"]"));
        firstName.sendKeys("Aysu");
        WebElement lastName = driver.findElement(new By.ByXPath("//input[@id=\"lastName\"]"));
        lastName.sendKeys("Murat");
        WebElement userEmail = driver.findElement(new By.ByXPath("//input[@id=\"userEmail\"]"));
        userEmail.sendKeys("aysumuratoglu@gmail.com");
        WebElement age = driver.findElement(new By.ByXPath("//input[@id=\"age\"]"));
        age.sendKeys("29");
        WebElement salary = driver.findElement(new By.ByXPath("//input[@id=\"salary\"]"));
        salary.sendKeys("10000");
        WebElement department = driver.findElement(new By.ByXPath("//input[@id=\"department\"]"));
        department.sendKeys("IT");
        WebElement submit = driver.findElement(new By.ByXPath("//button[@id=\"submit\"]"));
        submit.click();

        //Yapılan kaydı bul ve düzenle
        WebElement edit = driver.findElement(new By.ByXPath("//span[@id=\"edit-record-3\"]"));
        edit.click();

        WebElement editLastName = driver.findElement(new By.ByXPath("//input[@id=\"lastName\"]"));
        editLastName.clear();
        editLastName.sendKeys("Muratoğlu");

        WebElement editSubmit = driver.findElement(new By.ByXPath("//button[@id=\"submit\"]"));
        editSubmit.click();

    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
