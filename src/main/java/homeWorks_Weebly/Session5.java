package homeWorks_Weebly;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session5 {
	WebDriver driver;

	@Before
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void Login() {

		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		driver.findElement(By.xpath("	//span[contains(text(),'Bank & Cash')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("11Snt0112234");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("11Monthly Bsaving011234");

		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("11$1234");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("11AE804352011234");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("11MSunita011234");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys(")11123456011234");
		driver.findElement(By.xpath("//input[@id='ib_url']"))
				.sendKeys("http://a1utotechnotes.weebly.com/class-notes.html");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		System.out.println(driver.getTitle());
		String Actual = "Accounts- iBilling";

		Assert.assertEquals(driver.getTitle(), Actual);
		System.out.println("Page Validated");
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,2000)");

		driver.findElement(By.xpath("//ul/li[10]/ul/li[2]/a")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		int tablerows = rows.size();
		System.out.println("number of rows=" + tablerows);

		String before_path1 = "//tbody/tr[";
		String after_path1 = "]/td[1]";
		for (int i = 2; i <= 5; i++) {
			String name = driver.findElement(By.xpath(before_path1 + i + after_path1)).getText();
			System.out.println(name);
			if (name.contains(name)) {
				driver.findElement(By.xpath("// tbody/tr[" + i + "]/td[3]/a[2]")).click();
				System.out.println("welldone");

			}
		}
		/// tbody/tr[2]/td[2]
		
		
		String description_before_Xpath="//tbody/tr[";		String description_After_Xpath = "]/td[2]";
		for (int j = 2; j <= 8; j++) {
			String description = driver.findElement(By.xpath(description_before_Xpath + j + description_After_Xpath))
					.getText();
			System.out.println(description);
			if (description.equalsIgnoreCase("Buy a Home")) {
				driver.findElement(By.xpath("// tbody/tr[" + j + "]/td[3]/a[2]")).click();

			}
			
				System.out.println("not found");

		}

//		// method:2 for dynamic web handling
//		driver.findElement(By.xpath("//tbody/tr[6]/td[1]/parent::tr/child::td[3]/a[2]")).click();
//		driver.findElement(By.xpath("//td[contains(text(),'AhmedHamoud')]/parent::tr/child::td[3]/a[2]")).click();
	}
}
