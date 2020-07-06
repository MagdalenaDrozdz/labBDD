package edu.iis.mto.bdd.trains.cucumber.steps;

import java.util.List;

import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.InterinaryService;
import edu.iis.mto.bdd.trains.services.InterinaryServiceImplementaion;
import edu.iis.mto.bdd.trains.services.TimetableService;
import jnr.ffi.annotations.In;
import org.joda.time.LocalTime;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;

import static org.junit.Assert.assertEquals;

public class OptimalItinerarySteps {

    private InterinaryService interinaryService;
    TimetableService timetableService;
    List<LocalTime> timesForTrains;

    @Zakładając("^pociągi linii \"(.*)\" z \"(.*)\" odjeżdżają ze stacji \"(.*)\" do \"(.*)\" o$")
    public void givenArrivingTrains(String line, String lineStart, String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) List<LocalTime> departureTimes) {
        timetableService = new InMemoryTimetableService();
        interinaryService = new InterinaryServiceImplementaion(timetableService);

    }

    @Gdy("^chcę podróżować z \"([^\"]*)\" do \"([^\"]*)\" o (.*)$")
    public void whenIWantToTravel(String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) LocalTime startTime) {
        timesForTrains = interinaryService.findNextDepartures(departure,destination,startTime);
    }

    @Wtedy("^powinienem uzyskać informację o pociągach o:$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) List<LocalTime> expectedTrainTimes) {
        assertEquals(expectedTrainTimes, timesForTrains);
    }
}
