package org.example;

import org.example.enums.ElevatorDirection;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController {
    //each elevator has its own elevator controller

   private final PriorityBlockingQueue<Integer>upMinPQ;
   private final PriorityBlockingQueue<Integer>downMaxPQ;
    private final ElevatorCar elevatorCar;

   private final Object monitor = new Object();


    public ElevatorCar getElevator() {
        return elevatorCar;
    }

    public PriorityBlockingQueue<Integer> getUpMinPQ() {
        return upMinPQ;
    }

    public PriorityBlockingQueue<Integer> getDownMaxPQ() {
        return downMaxPQ;
    }

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityBlockingQueue<>();
        downMaxPQ = new PriorityBlockingQueue<>(10,(a,b)->b-a);

    }
    public void submitRequest(int destinationFloor){
        enqueueRequst(destinationFloor); //put into PQ
    }

    public  void enqueueRequst(int destinationFloor){
        System.out.println("Request details-> destinationFloor: " + destinationFloor + " accepted by elevator:" + elevatorCar.getId());
        if(destinationFloor==elevatorCar.getcurrentFloor()) return;

        if(destinationFloor>=elevatorCar.getcurrentFloor()){
            if(!upMinPQ.contains(destinationFloor)){
                upMinPQ.add(destinationFloor);
            }
        }else{
            if(!downMaxPQ.contains(destinationFloor)){
                downMaxPQ.add(destinationFloor);
            }
        }

        synchronized (monitor) {
            monitor.notify();
        }


    }
//    @Override
    public void run() {
        controlElevator();
    }

    public void controlElevator(){


        while(true){

            synchronized (monitor){
                //no request sleep
                while(upMinPQ.isEmpty() && downMaxPQ.isEmpty()){
                   try {
                       System.out.println("Elevator: " + elevatorCar.getId() + " is IDLE");
                       elevatorCar.setMovingDirection(ElevatorDirection.IDLE);
                       monitor.wait();
                   }catch (InterruptedException e){

                   }
                }

                while(!upMinPQ.isEmpty()){
                    int floor = upMinPQ.poll();
                    System.out.println("Elevator: "+elevatorCar.getId()+" Going to floor: "+floor);
                    elevatorCar.moveElevator(floor);
                }

                while(!downMaxPQ.isEmpty()){
                    int floor = downMaxPQ.poll();
                    System.out.println("Elevator: "+elevatorCar.getId()+" Going to floor: "+floor);
                    elevatorCar.moveElevator(floor);
                }
            }



        }
    }

}
