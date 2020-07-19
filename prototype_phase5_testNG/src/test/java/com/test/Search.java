package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Search {
	
	ChromeDriver driver = new ChromeDriver();
	
	@Test
	public void search() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("submit_search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println(driver.findElement(By.className("heading-counter")).getText());
		String check=driver.findElement(By.className("heading-counter")).getText();
		if(check.charAt(0)=='0') {
			System.out.println("No elements for the search");
		}
		driver.close();
	}

}
