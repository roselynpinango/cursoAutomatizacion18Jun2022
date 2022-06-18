package Edit.EducacionIT14May2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	@Test
	public void buscarEnChrome() {
		// Indicar dónde está el driver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIT14May2022\\Drivers\\chromedriver.exe");
		
		// Abrir el navegador en la página que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		
		// Escribir el valor a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void buscarEnFirefox() {
		// Indicar dónde está el driver
		System.setProperty("webdriver.gecko.driver", "..\\EducacionIT14May2022\\Drivers\\geckodriver.exe");
		
		// Abrir el navegador en la página que vamos a probar
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com");
		
		// Escribir el valor a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
