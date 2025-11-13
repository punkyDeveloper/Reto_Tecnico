package co.sqasa.Steps;

import co.sqasa.pageObjects.DatePickerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AbrirCalendario implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DatePickerUI.CAMPO_FECHA)
        );
    }

    public static AbrirCalendario hacerClic() {
        return Tasks.instrumented(AbrirCalendario.class);
    }
}