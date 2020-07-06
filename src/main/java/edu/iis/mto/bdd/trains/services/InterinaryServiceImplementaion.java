package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

public class InterinaryServiceImplementaion implements InterinaryService {

    private TimetableService timetableService;

    public InterinaryServiceImplementaion(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @Override public List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime) {
        List<Line> lines = timetableService.findLinesThrough(departure, destination);
        List<LocalTime> validArrivals = new ArrayList<>();
        List<LocalTime> arrivalTimes;

        for (Line line : lines) {
            arrivalTimes = timetableService.findArrivalTimes(line,departure);
            for (LocalTime localTime : arrivalTimes) {
                if(localTime.isAfter(startTime) && localTime.minusMinutes(EXPECTED_TIME_ARRIVAL).isBefore(startTime)){
                        validArrivals.add(localTime);
                }
            }
        }
        return validArrivals;
    }

}
