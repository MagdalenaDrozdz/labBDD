package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;

import java.util.List;
import java.util.stream.Collectors;

public class InterinaryServiceImpl implements InterinaryService {

    TimetableService timetableService;

    public InterinaryServiceImpl(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @Override
    public List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime) {
        List<Line> lines = timetableService.findLinesThrough(departure, destination);
        return lines.stream()
                .map(line -> timetableService.findArrivalTimes(line, departure))
                .flatMap(List::stream)
                .filter(arrivalTime -> arrivalTime.isAfter(startTime) && arrivalTime.isBefore(startTime.plusMinutes(EXPECTED_TIME_ARRIVAL)))
                .sorted(this::compereLocalTimes)
                .collect(Collectors.toList());
    }

    private int compereLocalTimes(LocalTime a, LocalTime b){
        if(a.isBefore(b)){
            return -1;
        } else if(a.isAfter(b)){
            return 1;
        } else {
            return 0;
        }
    }
}
