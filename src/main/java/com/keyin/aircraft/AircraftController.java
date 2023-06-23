package com.keyin.aircraft;

import com.keyin.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable int id) {
        return aircraftService.getAircraftById(id);
    }

    @GetMapping("/aircraft/search")
    public List<Aircraft> searchAircraft(@RequestParam String toSearch){
        return aircraftService.searchAircraft(toSearch);
    }

    @PostMapping("/aircraft/addAircraft")
    public void addAircraft(@RequestBody Aircraft aircraft){
        aircraftService.addAircraft(aircraft);
    }

    @DeleteMapping("/aircraft/deleteAircraft/{id}")
    public List<Aircraft> deleteAirportById(@PathVariable int id) {
        return aircraftService.deleteAircraftById(id);
    }

    @PutMapping("/aircraft/updateAircraft/{id}")
    public List<Aircraft> updateAircraft(@PathVariable int id, @RequestBody Aircraft aircraft){
        return aircraftService.updateAircraft(id, aircraft);
    }


    //----------------------------------------------------------

    @PostMapping("/aircraft/addAllowedAirport")
    public Aircraft addAirport(@RequestParam String aircraftToSearch, String airportToSearch){
       return aircraftService.addToAllowedList(aircraftToSearch, airportToSearch);
    }

    @PostMapping("/aircraft/removeAllowedAirport")
    public Aircraft removeAirport(@RequestParam String aircraftToSearch, String airportToSearch){
        return aircraftService.removeFromAllowedList(aircraftToSearch, airportToSearch);
    }

}
