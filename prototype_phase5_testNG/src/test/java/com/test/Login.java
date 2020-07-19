package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void login() {
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com/index.php");
		 driver.findElement(By.className("login")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.id("email")).sendKeys("denzildsouza@gmail.com");
		 driver.findElement(By.id("passwd")).sendKeys("00000");
		 driver.findElement(By.id("SubmitLogin")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 if(driver.getCurrentUrl().toString().equals("http://automationpractice.com/index.php?controller=my-account")) {
			 System.out.println("Login Successful");
		 }
		 if(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication")) {
			 System.out.println("Authentication failed");
		 }
		 
		 driver.close();
	}

}
//test@abcde.com 00000
//http://automationpractice.com/index.php?controller=authentication
//try {
//driver.findElement(By.className("icon-list-ol"));
//
//}
//catch(Exception e){
//System.out.println("Authentication failed.");
//}