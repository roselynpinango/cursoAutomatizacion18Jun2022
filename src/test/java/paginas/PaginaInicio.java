package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la página
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;     // Todo esto reemplaza al driver.findElement...
	
	@FindBy(css="#search_query_top")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer sobre los elementos de la página
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
}
