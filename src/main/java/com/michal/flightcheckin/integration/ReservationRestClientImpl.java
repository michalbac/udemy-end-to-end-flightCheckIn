package com.michal.flightcheckin.integration;

import com.michal.flightcheckin.integration.dto.Reservation;
import com.michal.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {
    private static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

    @Override
    public Reservation findReservation(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation =
                restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation =
                restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
        return reservation;
    }
}
