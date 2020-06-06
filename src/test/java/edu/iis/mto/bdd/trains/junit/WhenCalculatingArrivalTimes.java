package edu.iis.mto.bdd.trains.junit;

import edu.iis.mto.bdd.trains.cucumber.steps.JodaLocalTimeConverter;
import edu.iis.mto.bdd.trains.model.Line;
import edu.iis.mto.bdd.trains.services.InterinaryService;
import edu.iis.mto.bdd.trains.services.InterinaryServiceImpl;
import edu.iis.mto.bdd.trains.services.TimetableService;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenCalculatingArrivalTimes {

    InterinaryService interinaryService;
    TimetableService timetableService;

    @Before
    public void setUp() {
        timetableService = mock(TimetableService.class);
        interinaryService = new InterinaryServiceImpl(timetableService);
    }

    @Test
    public void shouldGiveMeInfoAbout3PossibleDepartueTimes() {
        String departure = "Warszawa";
        String destination = "Gdańsk";
        Line firstLine = Line.named("Pl")
                .departingFrom("Warszawa")
                .withStations("Warszawa", "Poznan", "Lodz", destination);
        Line secondLine = Line.named("Pl2")
                .departingFrom("Warszawa")
                .withStations("Warszawa", "Poznan", "Lodz", destination);
        when(timetableService.findLinesThrough(anyString(), anyString()))
                .thenReturn(List.of(firstLine, secondLine));

        JodaLocalTimeConverter jodaLocalTimeConverter = new JodaLocalTimeConverter();


        when(timetableService.findArrivalTimes(firstLine, departure))
                .thenReturn(List.of(
                        jodaLocalTimeConverter.transform("8:15"),
                        jodaLocalTimeConverter.transform("8:35"),
                        jodaLocalTimeConverter.transform("9:00")
                ));

        when(timetableService.findArrivalTimes(secondLine, departure))
                .thenReturn(List.of(
                        jodaLocalTimeConverter.transform("8:12"),
                        jodaLocalTimeConverter.transform("8:20"),
                        jodaLocalTimeConverter.transform("9:00")
                ));

        List<LocalTime> localTimes = interinaryService.findNextDepartures(departure, destination, jodaLocalTimeConverter.transform("8:10"));
        List<LocalTime> expectedLocalTimes = List.of(
                jodaLocalTimeConverter.transform("8:12"),
                jodaLocalTimeConverter.transform("8:15"),
                jodaLocalTimeConverter.transform("8:20")
        );

        assertEquals(expectedLocalTimes, localTimes);
    }
}
