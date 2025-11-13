package co.sqasa.questions;

import co.sqasa.pageObjects.DatePickerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EstadoCalendario implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return DatePickerUI.CALENDARIO_EMERGENTE.resolveFor(actor).isVisible();
    }

    public static EstadoCalendario esVisible() {
        return new EstadoCalendario();
    }
}