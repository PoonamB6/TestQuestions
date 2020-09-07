package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestQuestion2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pbokadia\\Desktop\\java\\Test2_QA\\Files\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		
		driver.manage().window().maximize();
	
		WebDriverWait wait=new WebDriverWait(driver, 60);
		WebElement dropdownlist;
		dropdownlist= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"ui-select-container ui-select-bootstrap dropdown ng-not-empty ng-valid ng-valid-required\"]")));
		dropdownlist.click();
	
		WebElement Dropdown1 = driver.findElement(By.xpath("(//div[@class=\"ng-binding ng-scope\"])[1]"));
		String Dropdown1Value = Dropdown1.getText();
		System.out.println("Dropdown has its first value as " +Dropdown1Value);
		
		WebElement Dropdown2 = driver.findElement(By.xpath("(//div[@class=\"ng-binding ng-scope\"])[2]"));
		String Dropdown2Value = Dropdown2.getText();
		System.out.println("Dropdown has its second value as " +Dropdown2Value);
		
		Dropdown1.click();
		
		WebElement Name = driver.findElement(By.xpath("//input[@name=\"name\"]"));
		Name.sendKeys("Poonam");
		
		WebElement orgName = driver.findElement(By.xpath("//input[@name=\"orgName\"]"));
		orgName.sendKeys("Poonam");
		
		WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
		email.sendKeys("poonamb@yahoo.com");
		
		WebElement iAgree = driver.findElement(By.xpath("//span[@class=\"black-color ng-binding\"]"));
		iAgree.click();
		
		WebElement submit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		submit.click();	
		
		WebElement alertMessage;
		alertMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alert alert-danger alert-custom\"]//span[@class=\"ng-binding\"]")));
			
		
		System.out.println(alertMessage.getText());
		if(alertMessage.getText().equals("A welcome email has been sent. Please check your email."))
			
		{
			System.out.println("Test Passed.");
		}
		
		else
		{
			System.out.println("Test Failed!!!");
		}
		
	}

}
