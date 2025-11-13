package co.sqasa.StepDef;

import co.sqasa.Steps.AbrirCalendario;
import co.sqasa.Steps.CambiarFocoAFrame;
import co.sqasa.Steps.SeleccionarFechaAtras;
import co.sqasa.Steps.SeleccionarFechaFutura;
import co.sqasa.pageObjects.DatePickerUI;
import co.sqasa.questions.EstadoCalendario;
import io.github.bonigarcia.wdm.WebDriverManager;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DatePickerStepDef {

    @Managed(driver = "chrome")
    private WebDriver herBrowser;

    private Actor user;

    @Before
    public void setTheStage() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("User");
        user.can(BrowseTheWeb.with(herBrowser));
    }

    @Given("^the user opens the Datepicker page$")
    public void theUserOpensTheDatepickerPage() {
        user.attemptsTo(
                Open.url("https://jqueryui.com/datepicker/"),
                CambiarFocoAFrame.alPrimerFrame()
        );
    }

    @When("^the user selects day \"([^\"]*)\" navigating \"([^\"]*)\" months forward$")
    public void theUserSelectsDayNavigatingMonthsForward(String day, String months) {
        user.attemptsTo(
                SeleccionarFechaFutura.conDias(Integer.parseInt(months), day)
        );
    }

    @When("^the user clicks on the date field$")
    public void theUserClicksOnTheDateField() {
        user.attemptsTo(
                AbrirCalendario.hacerClic()
        );
    }

    @When("^the user navigates \"([^\"]*)\" months backward and selects day \"([^\"]*)\"$")
    public void theUserNavigatesMonthsBackward(String months, String day) {
        user.attemptsTo(
                SeleccionarFechaAtras.conDias(Integer.parseInt(months), day)
        );
    }

    @Then("^the user should see the date \"([^\"]*)\" in the field$")
    public void theUserShouldSeeTheDateInTheField(String expectedDate) {
        user.should(
                seeThat("The date in the field",
                        actor -> DatePickerUI.CAMPO_FECHA.resolveFor(actor).getValue(),
                        equalTo(expectedDate))
        );
    }

    @Then("^the calendar should be visible$")
    public void theCalendarShouldBeVisible() {
        user.should(
                seeThat("The calendar is visible",
                        EstadoCalendario.esVisible(),
                        is(true))
        );
    }
}