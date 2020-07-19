package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration {
	boolean b=false;
	boolean check=false;
	ChromeDriver driver = new ChromeDriver();

	@BeforeMethod
  public void Sign_up() {
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
	  driver.findElement(By.className("login")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("email_create")).sendKeys("qw12g6cert@gmail.com");
	  driver.findElement(By.id("SubmitCreate")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      try {
	   driver.findElement(By.id("customer_firstname"));
	   b=true;
       } catch (Exception e) {
	// TODO Auto-generated catch block
	      System.out.println("Invalid Email ID or email id already exists");
      }
  }

  @Test
  public void register() {
		
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  if(b==true) {
		  
		  //Mr/Ms
		  driver.findElement(By.id("id_gender1")).click();
		  
		  //firstname
		  String firstname="Denzil";
		  if((firstname != null) && (!firstname.equals("")) && (firstname.matches("^[a-zA-Z]*$"))) 
		  {
			  driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
		  }
		  else
		  {
			  System.out.println("Firstname is invalid");
		  }
		  
		  //lastname
		  String lname="Dsouza";
		  if((lname != null) && (!lname.equals("")) && (lname.matches("^[a-zA-Z]*$"))) 
		  {
			  driver.findElement(By.id("customer_lastname")).sendKeys(lname);
		  }
		  else
		  {
			  System.out.println("Firstname is invalid");
		  }
		  
		  //password
		  String pass="00000";
		  if(pass.length()>4) {
		  driver.findElement(By.id("passwd")).sendKeys(pass);
		  }
		  else
		  {
			  System.out.println("Password should be minimum 5 characters");
		  } 
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 
		  //other
		  driver.findElement(By.id("days")).sendKeys("12");
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		  driver.findElement(By.id("months")).sendKeys("June");
		  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		  driver.findElement(By.id("years")).sendKeys("2000");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.id("newsletter")).click();
		  driver.findElement(By.id("optin")).click();  
		  driver.findElement(By.id("company")).sendKeys("BNP");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //address
		  String add1="address line 1";
		  String add2="address line 2";
		  if(add1!=null && add2!=null && add1!="" && add2!="")
		  {
		  driver.findElement(By.id("address1")).sendKeys(add1);
		  driver.findElement(By.id("address2")).sendKeys(add2);
		  
		  }
		  else {
			  System.out.println("Please enter a proper address");
		  }
		  //city
		  driver.findElement(By.id("city")).sendKeys("Mumbai");
		  //state
		  driver.findElement(By.id("id_state")).sendKeys("Ohio");
		  
		  //postcode
		  int post=89538;
		  String postcode=Integer.toString(post);
		  if(postcode.length()>4) {
		  driver.findElement(By.id("postcode")).sendKeys(postcode);
		  }
		  else {
			  System.out.println("Post code is of format '00000' ");
		  }
		
		  //country
		  driver.findElement(By.id("id_country")).sendKeys("Uinited States");
		  
		  driver.findElement(By.id("other")).sendKeys("None");
		  
		  //phone nos
		  String pno="6147383435";
		  String mno="7186389358";
		  if((pno.matches("^[0-9]+$")&& pno.length()>1) || (mno.matches("^[0-9]+$")&&mno.length()>1)) {
		  driver.findElement(By.id("phone")).sendKeys(pno);
		  driver.findElement(By.id("phone_mobile")).sendKeys(mno);
		  check=true;
		  }
		  else {
			  System.out.println("Invalid phone no");
		  }
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.id("submitAccount")).click();;
	
	  
  }
	  
  }
  
  @AfterMethod
  public void isregistered() {
	 if(check) {
		 System.out.println("Registration successful");
	 }
	 else
	 {
		 System.out.println("Registration failed"); 
	 }
	  driver.close();
	  }
  
}
