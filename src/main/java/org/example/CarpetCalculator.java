package org.example;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CarpetCalculator implements Calculatable {
    private float pricesquarefoot;
    private float installation;
    private ArrayList<Room> list = new ArrayList<>();
    private final NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
    private float discount;


    public CarpetCalculator(float pricesquarefoot) {
        this.pricesquarefoot = pricesquarefoot;
    }

    public CarpetCalculator(float pricesquarefoot, float installation) {
        this.pricesquarefoot = pricesquarefoot;
        this.installation = installation;

    }
    @Override
    public void addRoom(Room room) {
        list.add(room);

    }
    public float calculateTotal(){
        float total = 0.0F;
        Room room;

        for (int i =0;i<list.size();i++){
            room=list.get(i);
            total += room.getArea() * pricesquarefoot;
        }

        return total;
    }

    public float installcharge(){

        var finalsum=0.0f;
        if (installation!=0){
            finalsum=calculateTotal()+installation;

        }
        else {
            finalsum=calculateTotal();
        }
        return finalsum;
    }
    @Override
    public void addPercentDiscount(float percentDiscount) {
        discount = (installcharge())* (percentDiscount/100);

    }
    @Override
    public String getTotalCost(){

        return money.format(installcharge()-discount);
    }


}
