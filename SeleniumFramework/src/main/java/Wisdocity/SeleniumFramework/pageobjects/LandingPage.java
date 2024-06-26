package Wisdocity.SeleniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;
import dev.failsafe.internal.util.Assert;
import Wisdocity.SeleniumFramework.pageobjects.Learners;


public class LandingPage extends AbstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.xpath("//a[text()='Log In']")).click();
	//WebElement userEmail = 	driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys("shreejaya@gmail.com");
	//driver.findElement(By.xpath("//a[text()='Log In']")).click();
	//WebElement passWord= driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("Abcd1234");
	//driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	//PageFactory
	@FindBy(xpath="//a[text()='Log In']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//input[@autocomplete='email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@autocomplete='current-password']")
	WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	
	public Learners loginApplication(String email, String password) 
	{
		LoginBtn.click();
		userEmail.sendKeys(email);
		passWord.sendKeys(password);
		Submit.click();
		Learners learners = new Learners(driver);
		return learners;
	}
	
	public void Goto()
	{
		driver.get("https://alpha.wisdocity.ai/");
	}
	
	@FindBy(xpath ="//span[text()='shreejaya']")
	WebElement UserName;
	
	public Boolean VerifyUserName()
	{
		String UName =UserName.getText();
		Boolean match = UName.equalsIgnoreCase("shreejaya");
		return match;
		
	}
	
	@FindBy(xpath="")
	WebElement Caret;
	public void switchBetweenProfiles() {
		Caret.click();
		//Check for expert, learnes
		
	}
	
}
