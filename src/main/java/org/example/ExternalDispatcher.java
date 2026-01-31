package org.example;

import org.example.enums.ElevatorDirection;

public class ExternalDispatcher {
    ElevatorScheduler scheduler;
    public  ExternalDispatcher(ElevatorScheduler scheduler){
        this.scheduler = scheduler;
    }

    public  void submit(int floor, ElevatorDirection direction){
//       e scheduler.assignElevator(floor,direction);
        ElevatorController controller = scheduler.assignElevator(floor, direction);
        controller.submitRequest(floor);
    }

}
