package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
public class WebTablesWithCSS {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("WEBTABLES_URL");




    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }


    @Test
    public void WebTablesCSS(){

        //Yeni Kayıt eklemek için Add butonunu bul ve tıkla
        WebElement button = driver.findElement(new By.ByCssSelector("#addNewRecordButton"));
        button.click();

        WebElement firstName = driver.findElement(new By.ByCssSelector("#firstName"));
        firstName.sendKeys("Aysu");
        WebElement lastName = driver.findElement(new By.ByCssSelector("#lastName"));
        lastName.sendKeys("Murat");
        WebElement userEmail = driver.findElement(new By.ByCssSelector("#userEmail"));
        userEmail.sendKeys("aysumuratoglu@gmail.com");
        WebElement age = driver.findElement(new By.ByCssSelector("#age"));
        age.sendKeys("29");
        WebElement salary = driver.findElement(new By.ByCssSelector("#salary"));
        salary.sendKeys("10000");
        WebElement department = driver.findElement(new By.ByCssSelector("#department"));
        department.sendKeys("IT");
        WebElement submit = driver.findElement(new By.ByCssSelector("#submit"));
        submit.click();

        WebElement edit = driver.findElement(new By.ByCssSelector("#edit-record-4"));
        edit.click();

        WebElement editLastName = driver.findElement(new By.ByCssSelector("#lastName"));
        editLastName.clear();
        editLastName.sendKeys("Muratoğlu");

        WebElement editSubmit = driver.findElement(new By.ByCssSelector("#submit"));
        editSubmit.click();

    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
