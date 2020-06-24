package edu.iis.mto.bdd.trains.cucumber;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import edu.iis.mto.bdd.trains.cucumber.steps.JodaLocalTimeConverter;
import org.joda.time.LocalTime;

public class TimeEstimate {


    @Zakładając("^Następny pociąg odjeżdża o (.*) na lini (.*), Chcę się dostać  z (.*) do (.*)$")
    public void anotherTrainStartsAtTime( @Transform(JodaLocalTimeConverter.class) LocalTime departureTime,
                                          String line, String from, String to) {
        throw new PendingException();
    }


    @Gdy("^Zapytam o godzinę przyjazdu")
    public void iAskWhatTimeIArrive() {
        throw new PendingException();
    }

    @Wtedy("^Powinienem uzyskać czas przyjazdu (.*)$")
    public void iShouldReceiveCorrectArrivingTime( @Transform(JodaLocalTimeConverter.class) LocalTime departureTimes) {
        throw new PendingException();
    }
}
