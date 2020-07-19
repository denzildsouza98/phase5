package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtoCart {
	ChromeDriver driver = new ChromeDriver();
	@BeforeClass
	public void login() {
		driver.manage().window().maximize();
		 driver.get("http://automationpractice.com/index.php");
		 driver.findElement(By.className("login")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.id("email")).sendKeys("denzildsouza@gmail.com");
		 driver.findElement(By.id("passwd")).sendKeys("00000");
		 driver.findElement(By.id("SubmitLogin")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 if(driver.getCurrentUrl().toString().equals("http://automationpractice.com/index.php?controller=my-account")) {
			 System.out.println("Login Successful");
		 }
		 if(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication")) {
			 System.out.println("Authentication failed");
		 }
		 
	}
	
	@Test
	public void addtocart()  {
		 	driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
			driver.findElement(By.cssSelector("button[type=submit]")).click();	
			driver.findElement(By.xpath("//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/a/img")).click();
			driver.findElement(By.id("add_to_cart")).click();
			driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
			driver.navigate().to("http://automationpractice.com/index.php");
			driver.close();
		
	}
}













//*[@id="homefeatured"]/li[2]/div/div[1]/div/a[1]/img
//*[@id="homefeatured"]/li[2]/div/div[2]/div[2]/a[1]/span
//*[@id="homefeatured"]/li[2]/div/div[1]/div/a[1]/img
//WebDriverWait wait=new WebDriverWait(driver, 10);
		//driver.get("http://automationpractice.com/index.php");
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"))).click();
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"special_block_right\"]/div/ul/li/a/img"))).click();
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add_to_cart\"]/button"))).click();
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']/span"))).click();

//driver.findElement(By.cssSelector("img[title=\"Blouse\"]")).click();
//driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
//driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]/span")).click();
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")).click();;