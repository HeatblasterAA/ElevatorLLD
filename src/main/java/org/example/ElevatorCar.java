package org.example;

import org.example.enums.ElevatorDirection;
import org.example.Door;

public class ElevatorCar {
    private final int id;
    private int currentFloor;

    public int getId() {
        return id;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }

    public void setMovingDirection(ElevatorDirection movingDirection) {
        this.movingDirection = movingDirection;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public ElevatorDirection getMovingDirection() {
        return movingDirection;
    }

    public int getcurrentFloor() {
        return currentFloor;
    }

    public void setcurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    private int nextFloor;
    ElevatorDirection movingDirection;
    Door door;

    public  ElevatorCar(int id){
        this.id = id;
        currentFloor = 0;
        movingDirection = ElevatorDirection.IDLE;
        door = new Door();
    }

    public void showDisplay(){
        System.out.println("Elevator: "+id+" Current Floor: "+currentFloor+" going: "+ movingDirection);

    }

    void moveElevator(int destinationFloor){
        this.nextFloor = destinationFloor;

        if(currentFloor==nextFloor){
            door.openDoor(id);
            return;
        }

        int startFloor = currentFloor;
        door.closeDoor(id);
        if(nextFloor>=currentFloor){
            //move up
            movingDirection = ElevatorDirection.UP;
            showDisplay();
            for(int i=startFloor+1;i<=nextFloor;i++){
                try{
                    Thread.sleep(5);

                }catch (Exception e){


                }
                setcurrentFloor(i);
                showDisplay();
            }
        }else{
            movingDirection = ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor-1;i>=nextFloor;i--){
                try {
                    Thread.sleep(5);
                }catch (Exception e){

                }
                setcurrentFloor(i);
                showDisplay();
            }

        }
        door.openDoor(id);

    }

}
