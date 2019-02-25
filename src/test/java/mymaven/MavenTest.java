package mymaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenTest {
	public String url="https://www.morningstar.in/membership/";
	public WebDriver driver;
	@BeforeTest
	public void testopen() {
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\dell\\Downloads\\geckodriver.exe"); 
          driver = new FirefoxDriver();
			driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
			}
			@Test
			public void verifyopenpage() {
				String ExpectedTitle="Login | Morningstar India";
				String ActualTitle=driver.getTitle();
				Assert.assertEquals(ActualTitle, ExpectedTitle);
				
			}
			
			
			@Test(priority=0)
			public void logintomorningstar() {
				//WebDriverWait wait=new WebDriverWait(driver, 10);
			       //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#ctl00_ContentPlaceHolder1_txtEmail"))).sendKeys("shyampotu@outlook.com");
			       //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#ctl00_ContentPlaceHolder1_txtPassword"))).sendKeys("shyam1267");
			       //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#ctl00_ContentPlaceHolder1_btnLogin"))).click();
				driver.findElement(By.cssSelector("input#ctl00_ContentPlaceHolder1_txtEmail")).sendKeys("shyampotu@outlook.com");
				driver.findElement(By.cssSelector("input#ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("shyam1267");
				driver.findElement(By.cssSelector("input#ctl00_ContentPlaceHolder1_btnLogin")).click();


				
			}
			@Test(priority=1)
			public void ScrollDown() {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,750)");
			
			}
			
			@Test(priority=2)
			public void idexreturn() {
		/*	WebDriverWait wait=new WebDriverWait(driver, 20);
			
			
		    Select country =new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.catreturns_ddl.ir-ddl-region"))));
		    country.selectByVisibleText("Global");
		    
		    Select period=new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.catreturns_ddl.ir-ddl-period"))));
		    period.selectByVisibleText("1 Year");
		*/	
				
				
			    Select country =new Select(driver.findElement((By.cssSelector("select.catreturns_ddl.ir-ddl-region"))));
			    country.selectByVisibleText("Global");
			    
			    Select period=new Select(driver.findElement((By.cssSelector("select.catreturns_ddl.ir-ddl-period"))));
			    period.selectByVisibleText("1 Year");
			}
			@Test(priority=3)
			public void Europe() {
			/*	WebDriverWait wait=new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#ui-id-11.ui-tabs-anchor"))).click();
			if(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#ui-id-11"))).isDisplayed())
			{
				System.out.println("Element is Visible");
			}
			else
			{
			System.out.println("Element is InVisible");
			}
			
		*/
				driver.findElement((By.cssSelector("a#ui-id-11.ui-tabs-anchor"))).click();
			if(driver.findElement((By.cssSelector("a#ui-id-11"))).isDisplayed())
			{
				System.out.println("Element is Visible");
			}
			else
			{
			System.out.println("Element is InVisible");
			}
				}
			@Test(priority=4)
			public void Currency() {
			/*	WebDriverWait wait=new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#ctl00_ContentPlaceHolder1_ucCurrency_txtCurrencyDate"))).click();
				Select year=new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.ui-datepicker-year"))));
				year.selectByVisibleText("2018");
				
				Select month=new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.ui-datepicker-month"))));
				month.selectByVisibleText("Jan");
			    
		  
				List<WebElement> day=driver.findElements(By.cssSelector("table.ui-datepicker-calendar"));

				for(WebElement ele:day)
				{
					
					String date=ele.getText();
					
					if(date.equalsIgnoreCase("8"))
					{
						ele.click();
					}
				}

			    
			    System.out.println(year+"2018");
			    System.out.println(month+"Jan");
			    System.out.println(day+"20");
			    
			if(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#currency_wrap"))).isDisplayed())
			{
				System.out.println("Currency is displayed");
			}
			else {
				System.out.println("Currency is not displayed");
			}
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#ctl00_ContentPlaceHolder1_ucCurrency_btnGo"))).submit();

			*/
				driver.findElement((By.cssSelector("input#ctl00_ContentPlaceHolder1_ucCurrency_txtCurrencyDate"))).click();
				Select year=new Select(driver.findElement((By.cssSelector("select.ui-datepicker-year"))));
				year.selectByVisibleText("2018");
				
				Select month=new Select(driver.findElement((By.cssSelector("select.ui-datepicker-month"))));
				month.selectByVisibleText("Jan");
			    
		  
				List<WebElement> day=driver.findElements(By.cssSelector("table.ui-datepicker-calendar"));

				for(WebElement ele:day)
				{
					
					String date=ele.getText();
					
					if(date.equalsIgnoreCase("8"))
					{
						ele.click();
					}
				}

			    
			    System.out.println(year+"2018");
			    System.out.println(month+"Jan");
			    System.out.println(day+"20");
			    
			if(driver.findElement((By.cssSelector("div#currency_wrap"))).isDisplayed())
			{
				System.out.println("Currency is displayed");
			}
			else {
				System.out.println("Currency is not displayed");
			}
		    driver.findElement((By.cssSelector("input#ctl00_ContentPlaceHolder1_ucCurrency_btnGo"))).submit();

				
				}

			
			@AfterTest
			public void endtest() {
			//	WebDriverWait wait=new WebDriverWait(driver, 10);
			//	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#ctl00_ucHeader_hlLogin"))).click();
				driver.findElement(By.cssSelector("a#ctl00_ucHeader_hlLogin")).click();
				driver.quit();		
	}

}
