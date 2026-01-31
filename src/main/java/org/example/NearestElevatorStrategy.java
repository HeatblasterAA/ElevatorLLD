package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy {

    public ElevatorController select(List<ElevatorController> controllers, int floor, ElevatorDirection direction){


        ElevatorController best = null;
        int mini = Integer.MAX_VALUE;

        for(ElevatorController controller: controllers){
            int nextfloor = controller.getElevator().getNextFloor();
            boolean isSameDirection =
                    controller.getElevator().getMovingDirection()==direction && ((direction== ElevatorDirection.UP && floor<=nextfloor)||(direction==ElevatorDirection.DOWN && floor>=nextfloor));
            int dist = Math.abs(nextfloor-floor);

            if(isSameDirection && dist<mini){
                mini = dist;
                best = controller;
            }
        }
        if(best==null){
            for(ElevatorController controller: controllers){
                if(controller.getElevator().getMovingDirection()==ElevatorDirection.IDLE){
                    best = controller;
                    break;
                }
            }
        }
        if(best == null) best = controllers.get(0);
        return best;
    }
}
