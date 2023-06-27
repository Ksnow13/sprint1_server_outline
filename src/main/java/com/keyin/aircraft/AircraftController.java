package com.keyin.aircraft;

import com.keyin.action.ActionService;
import com.keyin.airport.Airport;
import com.keyin.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;
    @Autowired
    private HistoryService historyService; //-------------------------------------
    @Autowired
    private ActionService actionService; //-------------------------------------


    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        historyService.addToHistory("getAllAircraft()", "/aircraft", LocalDateTime.now());
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable int id) {
        String url = "/aircraft/" + String.valueOf(id);
        historyService.addToHistory("getAircraftById()", url, LocalDateTime.now());
        return aircraftService.getAircraftById(id);
    }

    @GetMapping("/aircraft/search")
    public List<Aircraft> searchAircraft(@RequestParam String toSearch){
        historyService.addToHistory("searchAircraft()", "aircraft/search", LocalDateTime.now());
        return aircraftService.searchAircraft(toSearch);
    }

    @PostMapping("/aircraft/addAircraft")
    public void addAircraft(@RequestBody Aircraft aircraft){
        actionService.addAction("aircraft", "create", Map.of("id", aircraft.getId(), "type", aircraft.getType(), "numberOfPassengers", aircraft.getNumberOfPassengers(), "allowedAirportList", aircraft.getAllowedAirportList()));
        historyService.addToHistory("addAircraft()", "/aircraft/addAircraft", LocalDateTime.now());
        aircraftService.addAircraft(aircraft);
    }

    @DeleteMapping("/aircraft/deleteAircraft/{id}")
    public List<Aircraft> deleteAirportById(@PathVariable int id) {
        String url = "/aircraft/deleteAircraft/" + String.valueOf(id);
        historyService.addToHistory("searchAircraft()", url, LocalDateTime.now());
        return aircraftService.deleteAircraftById(id);
    }

    @PutMapping("/aircraft/updateAircraft/{id}")
    public List<Aircraft> updateAircraft(@PathVariable int id, @RequestBody Aircraft aircraft){
        String url = "/aircraft/updateAircraft/" + String.valueOf(id);
        historyService.addToHistory("updateAircraft()", url, LocalDateTime.now());
        return aircraftService.updateAircraft(id, aircraft);
    }

    @PostMapping("/aircraft/addAllowedAirport")
    public Aircraft addAirport(@RequestParam String aircraftToSearch, String airportToSearch){
        historyService.addToHistory("addToAllowedList()", "/aircraft/addAllowedAirport", LocalDateTime.now());
       return aircraftService.addToAllowedList(aircraftToSearch, airportToSearch);
    }

    @PostMapping("/aircraft/removeAllowedAirport")
    public Aircraft removeAirport(@RequestParam String aircraftToSearch, String airportToSearch){
        historyService.addToHistory("removeFromAllowedList()", "/aircraft/addAirport", LocalDateTime.now());
        return aircraftService.removeFromAllowedList(aircraftToSearch, airportToSearch);
    }

}
