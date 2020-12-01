package com.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class NormalAlert {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	
	 NormalAlert();
	 PomptAlert();
	 ConfirmAlert();
	 BrowserClose();
	}
	
	private static void BrowserClose() {
		// TODO Auto-generated method stub
		driver.close();
	}

	private static void NormalAlert() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebElement alrtBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		
		alrtBtn.click(); 
		
		Thread.sleep(5000);  
		driver.switchTo().alert().accept(); //click on ok button
				
	}
	private static void ConfirmAlert() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebElement alrtBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		
		alrtBtn.click(); 
		
		Thread.sleep(5000); 
		driver.switchTo().alert().dismiss(); //click on cancle button
		Thread.sleep(5000);  		
	}
	private static void PomptAlert() throws InterruptedException {
		// TODO Auto-generated method stub
		
		String InputText="Test automation...";
		WebElement prmtBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		prmtBtn.click();
		Thread.sleep(5000);

		driver.switchTo().alert().sendKeys(InputText); //type on alert
		Thread.sleep(5000); 
		driver.switchTo().alert().accept(); //click on cancle button
		Thread.sleep(5000);  		
	
		String outputText=driver.findElement(By.id("result")).getText();
		
		if(outputText.contains(InputText)) {
			System.out.println("pass");
		}
		else
			System.out.println("fail");
	
	}
}
