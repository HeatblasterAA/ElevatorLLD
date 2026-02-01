package org.example;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Floor> floors;
    public Building(int totalFloors, ExternalDispatcher dispatcher) {

        floors = new ArrayList<>();
        for (int i = 1; i <= totalFloors; i++) {
            floors.add(new Floor(i, dispatcher));
        }
    }

    public Floor getFloor(int floor) {
        return floors.get(floor-1);
    }



}
