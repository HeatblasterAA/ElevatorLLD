package org.example;

import org.example.enums.DoorState;

public class Door {

    private DoorState doorState;

    Door(){
        doorState = DoorState.CLOSE;


    }

    public  void openDoor(int id){
        doorState = DoorState.OPEN;
        System.out.println("Openings the doors of elevator: "+id);
    }

    public  void closeDoor(int id){
        doorState = DoorState.CLOSE;
        System.out.println("Closing the doors of elevator: "+id);
    }


}
