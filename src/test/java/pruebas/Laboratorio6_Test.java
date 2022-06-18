package pruebas;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaAlerta;

public class Laboratorio6_Test {
	String url = "https://demoqa.com/alerts";
	String driverPath = "..\\EducacionIT14May2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	PaginaAlerta alerta;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		alerta = new PaginaAlerta(driver);
	}
	
	@Test
	public void alertaNotificacion() {
		alerta.hacerClicEnNotificacion();
		
		System.out.println("Texto de la Alerta: " + alerta.obtenerTextoAlerta());
		
		alerta.aceptarAlerta();
	}
	
	@Test
	public void alertaEspera() {
		alerta.hacerClicEnEspera();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		alerta.aceptarAlerta();
	}
	
	@Test
	public void alertaConfirmacion() {
		alerta.hacerClicEnConfirmacion();
		alerta.cancelarAlerta();
	}
	
	@Test
	public void alertaEscribir() {
		alerta.hacerClicEnEscribir();
		alerta.escribirEnAlerta("Clase de Automatización");
		alerta.aceptarAlerta();
	}
}
