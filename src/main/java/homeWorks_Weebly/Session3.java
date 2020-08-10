package homeWorks_Weebly;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Session3{
	WebDriver driver;
	@Before
	public void launch() {
System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("http://www.techfios.com/ibilling/?ng=admin/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

@Test
public void Login() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys("demo@techfios.com");
	driver.findElement(By.id("password")).sendKeys("abc123");
	driver.findElement(By.name("login")).click();

	driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();

	driver.findElement(By.xpath("//a[contains(text(),'Transfer')]")).click();
	Select select = new Select(driver.findElement(By.xpath("//select[@id='faccount']")));
	select.selectByVisibleText("3373");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[contains(text(),'New Expense')]")).click();

	Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='account']")));
	sel2.selectByVisibleText("3088");
	driver.findElement(By.xpath("//a[contains(text(),'Transfer')]")).click(); // a[contains(text(),'Transfer')]
	
	Select sel3 = new Select(driver.findElement(By.xpath("//select[@id='faccount']")));
	sel3.selectByVisibleText("5639");
	Thread.sleep(2000);
 
	driver.findElement(By.xpath("//a[contains(text(),'View Transactions')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Balance Sheet')]")).click();
	driver.findElement(By.xpath("//h5[contains(text(),'Balance Sheet')]")).click();
	//driver.findElement(By.xpath("//tbody/tr[2]/td[contains(text(),'rforty4567856799')]"))).getText();
	//tbody/tr[2]/td[1]
	
	String before_path="//tbody/tr[";
	String after_path="]/td[1]";
	for(int i=2;i<=5;i++) {
	String Account=driver.findElement(By.xpath( before_path +i+ after_path)).getText();	
	if(Account.contentEquals(Account)) {
		System.out.println("Account created");
	}
	}

  
  
  }

}

