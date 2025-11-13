package co.sqasa.runners;

import co.sqasa.Steps.CambiarFocoAFrame;
import co.sqasa.Steps.SeleccionarFechaFutura;
import co.sqasa.pageObjects.DatePickerUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class SeleccionarFechaRunner {

    private Actor automatizador;

    @Managed(driver = "chrome")
    WebDriver herBrowser;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        automatizador = Actor.named("Automatizador");
        automatizador.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void seleccion_fecha_mes_diferente_exitosa() {
        String diaASeleccionar = "20";
        String fechaEsperada = "02/20/2026";
        int mesesANavegar = 3;

        automatizador.attemptsTo(
                Open.url("https://jqueryui.com/datepicker/"),
                CambiarFocoAFrame.alPrimerFrame()
        );

        automatizador.attemptsTo(
                SeleccionarFechaFutura.conDias(mesesANavegar, diaASeleccionar)
        );

        // ✅ SOLUCIÓN: Lambda inline que SÍ funciona
        automatizador.should(
                seeThat("La fecha en el campo",
                        actor -> DatePickerUI.CAMPO_FECHA.resolveFor(actor).getValue(),
                        equalTo(fechaEsperada))
        );
    }
}