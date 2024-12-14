package observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        StockPricePublisher stockPricePublisher=new StockPricePublisher();
        Subscriber subscriber=new Subscriber();
        Subscriber subscriber2=new Subscriber();
        stockPricePublisher.addSubscriber(subscriber);
        stockPricePublisher.addSubscriber(subscriber2);

        stockPricePublisher.setPrice(50);
        
    }
}

class StockPricePublisher{
    List<Subscriber>subscribers;
    double currentPrice;

    StockPricePublisher(){
        this.subscribers=new ArrayList<>();
        this.currentPrice=40;
    }
    void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    void removeSubscriber(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    void notifySubs(double changedPrice,double oldprice){
        for(Subscriber sub :subscribers){
            sub.update(changedPrice,oldprice);
        }
    }

    void setPrice(double price){
        double oldprice=currentPrice;
        this.currentPrice=price;
        this.notifySubs(price, oldprice);
    }

}


class Subscriber {

    double currentPrice;

    void update(double changedPrice,double oldprice){
        System.out.println("System notification ");
        System.out.println("Old price : "+oldprice);
        System.out.println("New Price :"+changedPrice);
        this.currentPrice=changedPrice;
    }
}