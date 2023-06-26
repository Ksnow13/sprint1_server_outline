package com.keyin.history;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class HistoryService {

    private List<History> historyList = new ArrayList<>();

    private Stack<History> historyStack = new Stack<>();


    public void addToHistory(String calledMethod, String url, LocalDateTime timestamp) {
        History history = new History(calledMethod, url, timestamp);
        historyList.add(history);
        historyStack.add(history);
    }

    public List<History> getAllHistory() {
        return historyList;
    }


}

