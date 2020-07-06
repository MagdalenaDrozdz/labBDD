package edu.iis.mto.bdd.trains.services;

import org.joda.time.LocalTime;

import java.util.List;

public interface InterinaryService {

    int EXPECTED_TIME_ARRIVAL = 15;
    List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime);

}
