package co.sqasa.Steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class CambiarFocoAFrame implements Task {

    private final int frameIndex;

    // Constructor que recibe el índice del iframe
    public CambiarFocoAFrame(int frameIndex) {
        this.frameIndex = frameIndex;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obtener el driver
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();


        driver.switchTo().frame(frameIndex);
    }

    // Método estático para cambiar el foco al primer iframe (índice 0)
    public static CambiarFocoAFrame alPrimerFrame() {
        return Tasks.instrumented(CambiarFocoAFrame.class, 0);
    }
}