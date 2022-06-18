package Edit.EducacionIT14May2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio4b {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT14May2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT14May2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void abrirPagina(String navegador) {
		if (navegador.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
