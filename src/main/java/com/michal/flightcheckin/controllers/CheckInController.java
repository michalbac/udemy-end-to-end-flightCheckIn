package com.michal.flightcheckin.controllers;

import com.michal.flightcheckin.integration.ReservationRestClient;
import com.michal.flightcheckin.integration.dto.Reservation;
import com.michal.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    ReservationRestClient reservationRestClient;

    @RequestMapping("/showStartCheckIn")
    public String showCheckIn(){
        return "startCheckIn";
    }

    @RequestMapping("/startCheckIn")
    public String startCheckIn(@RequestParam("reservationId") long id, ModelMap modelMap){
        Reservation reservation = reservationRestClient.findReservation(id);
        modelMap.addAttribute("reservation", reservation);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam long reservationId, @RequestParam int numberOfBags){
        ReservationUpdateRequest request = new ReservationUpdateRequest();
        request.setId(reservationId);
        request.setCheckedIn(true);
        request.setNumberOfBags(numberOfBags);
        reservationRestClient.updateReservation(request);
        return "checkInConfirmation";
    }
}
