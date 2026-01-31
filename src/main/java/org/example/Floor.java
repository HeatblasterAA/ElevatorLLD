package org.example;

import org.example.enums.ElevatorDirection;

public class Floor {
    private int id;
    ExternalButton upButton;
    ExternalButton downButton;

    public Floor(int id, ExternalDispatcher dispatcher){
        this.id=id;
        upButton = new ExternalButton(dispatcher);
        downButton = new ExternalButton(dispatcher);
    }

    public void pressUpButton(){
        upButton.pressButton(id, ElevatorDirection.UP);
    }
    public void pressDownButton(){
        downButton.pressButton(id, ElevatorDirection.DOWN);
    }
}
