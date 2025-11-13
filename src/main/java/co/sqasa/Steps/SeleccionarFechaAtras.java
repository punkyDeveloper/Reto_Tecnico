package co.sqasa.Steps;

import co.sqasa.pageObjects.DatePickerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarFechaAtras implements Task {

    private final int meses;
    private final String dia;

    public SeleccionarFechaAtras(int meses, String dia) {
        this.meses = meses;
        this.dia = dia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DatePickerUI.CAMPO_FECHA));

        for (int i = 0; i < meses; i++) {
            actor.attemptsTo(Click.on(DatePickerUI.BOTON_MES_ANTERIOR));
        }

        actor.attemptsTo(Click.on(DatePickerUI.FECHA_ESPECIFICA(dia)));
    }

    public static SeleccionarFechaAtras conDias(int meses, String dia) {
        return Tasks.instrumented(SeleccionarFechaAtras.class, meses, dia);
    }
}