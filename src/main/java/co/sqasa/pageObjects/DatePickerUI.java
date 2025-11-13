package co.sqasa.pageObjects;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatePickerUI {

    // Campo de texto principal
    public static final Target CAMPO_FECHA = Target.the("campo de fecha")
            .located(By.id("datepicker"));

    // Botón para avanzar al mes siguiente
    public static final Target BOTON_MES_SIGUIENTE = Target.the("boton mes siguiente")
            .located(By.xpath("//a[@title='Next']"));

    // Botón para retroceder al mes anterior
    public static final Target BOTON_MES_ANTERIOR = Target.the("boton mes anterior")
            .located(By.xpath("//a[@title='Prev']"));

    // Contenedor del calendario emergente
    public static final Target CALENDARIO_EMERGENTE = Target.the("calendario emergente")
            .located(By.id("ui-datepicker-div"));

    // Título del mes y año actual en el calendario
    public static final Target TITULO_MES_ANIO = Target.the("titulo mes y anio")
            .located(By.className("ui-datepicker-title"));

    // Mes actual mostrado
    public static final Target MES_ACTUAL = Target.the("mes actual")
            .located(By.className("ui-datepicker-month"));

    // Año actual mostrado
    public static final Target ANIO_ACTUAL = Target.the("anio actual")
            .located(By.className("ui-datepicker-year"));

    // Método dinámico para localizar un día específico
    public static Target FECHA_ESPECIFICA(String dia) {
        return Target.the("dia " + dia)
                .located(By.xpath("//a[text()='" + dia + "']"));
    }

    // Método para verificar si una fecha está deshabilitada
    public static Target FECHA_DESHABILITADA(String dia) {
        return Target.the("dia deshabilitado " + dia)
                .located(By.xpath("//td[contains(@class, 'ui-state-disabled')]//a[text()='" + dia + "']"));
    }
}