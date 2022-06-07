package org.example;

public class Room {
    private int width;
    private int length;
    public Room (int width, int length){
        this.width=width;
        this.length=length;
    }


    public int getArea() {
        return width*length;
    }
}

