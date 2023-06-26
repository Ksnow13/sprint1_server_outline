package com.keyin.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }
}
