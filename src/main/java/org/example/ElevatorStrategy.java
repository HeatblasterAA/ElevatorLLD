package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public interface ElevatorStrategy {
    ElevatorController select(List<ElevatorController> controllers, int floor, ElevatorDirection direction);
}
