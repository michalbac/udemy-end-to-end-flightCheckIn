package com.michal.flightcheckin.integration;

import com.michal.flightcheckin.integration.dto.Reservation;
import com.michal.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(long id);

    public Reservation updateReservation(ReservationUpdateRequest request);
}
