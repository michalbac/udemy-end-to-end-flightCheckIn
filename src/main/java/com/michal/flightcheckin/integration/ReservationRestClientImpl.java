package com.michal.flightcheckin.integration;

import com.michal.flightcheckin.integration.dto.Reservation;
import com.michal.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    @Value("${com.michal.flightcheckin.integration.reservationREST.URL}")
    private String RESERVATION_REST_URL;

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
