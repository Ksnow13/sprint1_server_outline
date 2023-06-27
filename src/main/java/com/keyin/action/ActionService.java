package com.keyin.action;

import com.keyin.aircraft.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Stack;

@Service
public class ActionService {

    private Stack<Action> actionStack = new Stack<>();

    @Autowired
    public AircraftService aircraftService; // Autowired to get the data from AircraftService

    public Stack<Action> getActionStack() {
        return actionStack;
    }

    public void addAction(String objectName, String operation, Map<String, Object> theObject) {
        Action action = new Action(objectName, operation, theObject);
        actionStack.push(action);
        System.out.println("the action has been added to the stack " + actionStack.peek().getObjectName() + " " + actionStack.peek().getOperation() + " object id: " + actionStack.peek().getParameters().get("id"));
    }

    public void undoAction() {

        if(actionStack.size() > 0) {
            if (actionStack.peek().getObjectName() == "aircraft") {
                if (actionStack.peek().getOperation() == "create") {
                    System.out.println("reached");
                    aircraftService.deleteAircraftById((Integer) actionStack.peek().getParameters().get("id"));
                    System.out.println("deleted");
                    actionStack.pop();
                    System.out.println("popped");
                }
            }
        } else {
            System.out.println("Sorry the stack is empty.");
        }

    }
}
