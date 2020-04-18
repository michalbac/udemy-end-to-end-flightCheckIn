package com.michal.flightcheckin.integration.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Reservation{
    private long id;
    private boolean checkedIn;
    private int numberOfBags;
    private Passenger passenger;
    private Flight flight;
}
