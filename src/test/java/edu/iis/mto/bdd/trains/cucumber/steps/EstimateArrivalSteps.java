package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import org.joda.time.LocalTime;

public class EstimateArrivalSteps {

    @Zakładając("^chcę się dostać z \"([^\"]*)\" do \"([^\"]*)\"$") public void givenFromAndTo(String from, String to)
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @I("^następny pociąg odjeżdża o \"([^\"]*)\" na linii \"([^\"]*)\"$")
    public void nextTimeAndLine(@Transform(JodaLocalTimeConverter.class) LocalTime time, String line) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Gdy("^zapytam o godzinę przyjazdu$") public void whenIAskForArrivalTime() {

    }

    @Wtedy("^powinienem uzyskać następujący szacowany czas przyjazdu: \"([^\"]*)\"$")
    public void thenIShouldHasEstimateArrivalTime(@Transform(JodaLocalTimeConverter.class) LocalTime time) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
