package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {

    private final List<ElevatorController> controllers;
    private ElevatorStrategy strategy;

    public ElevatorScheduler(List<ElevatorController> controllers, ElevatorStrategy strategy){
        this.controllers = controllers;
        this.strategy = strategy;
    }

    public void setStrategy(ElevatorStrategy strategy) {
        this.strategy = strategy;
    }
    public ElevatorController assignElevator(int floor, ElevatorDirection direction){
        return strategy.select(controllers,floor, direction);
    }
}
