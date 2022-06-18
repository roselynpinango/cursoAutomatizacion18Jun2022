package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio5_Test {
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
		
		// Comprobar si el usuario inició sesión
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
		
		// Desloguear al usuario
		login.hacerClicEnSignOut();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT14May2022\\Datos\\DataProviderExcel.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() {
		Object[][] datos = new Object[3][2];
		
		// Completar el arreglo con los datos para la prueba (email, contraseña)
		datos[0][0] = "abc@correo.com";
		datos[0][1] = "1q2w3e4r5t";
		
		datos[1][0] = "def@correo.com";
		datos[1][1] = "0p9o8i7u6y";
		
		datos[2][0] = "ghi@correo.com";
		datos[2][1] = "qawsedrftg";
		
		return datos;
	}
}
