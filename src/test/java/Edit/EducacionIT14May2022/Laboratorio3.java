package Edit.EducacionIT14May2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT14May2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Verificar la sección Contactanos", priority=200)
	public void irAContactanos() {	
		// Pasos para ir a Contactanos
		driver.findElement(By.linkText("Contact us")).click();
		
		Select lista = new Select(driver.findElement(By.id("id_contact")));
		lista.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("correob@mailinator.com");
		driver.findElement(By.id("message")).sendKeys("Comentarios del Contacto");
		
		// Subir un archivo - Escribir en el campo deshabilitado donde va el nombre del archivo
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
	}
	
	@Test(description="CP02 - Verificar la búsqueda de productos", priority=100)
	public void buscarPalabra() {		
		// Pasos para buscar Palabra
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Comprobar que la busqueda se realizó
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl();
		
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(urlActual, urlEsperada);
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		// Assert.assertEquals(numRegistrosBD, 1);
		
		/*
		 * assertEquals
		 * assertNotEquals
		 * assertTrue(2 + 2 == 4)
		 * assertFalse
		 * assertNull
		 * assertNotNull
		 * */
	}
	
	@AfterSuite
	public void cerrarPagina() {
		//driver.close();
	}
}
