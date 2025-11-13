package co.sqasa.Steps;

import co.sqasa.pageObjects.DatePickerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Tasks;

public class SeleccionarFechaFutura implements Task {

    private final int meses;
    private final String dia;

    public SeleccionarFechaFutura(int meses, String dia) {
        this.meses = meses;
        this.dia = dia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Abrir el calendario haciendo clic en el input (Manipula el <input id="datepicker">)
        actor.attemptsTo(
                Click.on(DatePickerUI.CAMPO_FECHA)
        );

        // 2. Navegar 'meses' hacia adelante usando el BOTON_MES_SIGUIENTE
        for (int i = 0; i < meses; i++) {
            actor.attemptsTo(
                    Click.on(DatePickerUI.BOTON_MES_SIGUIENTE)
            );
        }

        // 3. Seleccionar el día deseado
        actor.attemptsTo(
                Click.on(DatePickerUI.FECHA_ESPECIFICA(dia))
        );
    }

    // Método estático para instrumentar la Tarea
    public static SeleccionarFechaFutura conDias(int meses, String dia) {
        return Tasks.instrumented(SeleccionarFechaFutura.class, meses, dia);
    }
}