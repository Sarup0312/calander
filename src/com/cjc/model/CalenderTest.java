package com.cjc.model;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CalenderTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Main Starts ");
		System.out.println("This is the code for calender prog");
		System.setProperty("webdriver.chrome.driver", "E:\\soft\\chrome_new\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		List<WebElement> ls=driver.findElements(By.tagName("iframe"));
		int count1=ls.size();

		System.out.println("The number of iframes are:"+count1);
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-datepicker-month']")).getText().contains("August"))
		{
			driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> ls2=driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
	    int count2=ls2.size();
	    System.out.println("The no of days in calender is:"+count2);
	    
	    
	    for(int i=0;i<=count2;i++)
	    {
	    	String day=driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
	    	if(day.equalsIgnoreCase("2"))
	    	{
	    		driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
	    	}
	    }
				
		
		
	}

}
