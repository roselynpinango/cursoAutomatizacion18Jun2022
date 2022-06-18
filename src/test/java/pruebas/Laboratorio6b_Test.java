package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaTabla;

public class Laboratorio6b_Test {
	String url = "https://demo.guru99.com/test/table.html";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void consultarValoresTabla() {
		PaginaTabla tabla = new PaginaTabla(driver);
		
		System.out.println(tabla.obtenerTextoCelda12()); // 2
		System.out.println(tabla.obtenerTextoCelda23()); // 6
		System.out.println(tabla.obtenerTextoCelda43()); // 8
	}
}
