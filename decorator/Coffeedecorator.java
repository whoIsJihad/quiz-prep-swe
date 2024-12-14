package decorator;
//dynamically add new behavior or responsibilities without altering its structure 
interface Coffee {
    String getDescription();

    double getCost();
}

public abstract class Coffeedecorator implements Coffee{
    protected Coffee coffee;

    public Coffeedecorator(Coffee coffee){
        this.coffee=coffee;
    }

    public  String getDescription(){
        return this.coffee.getDescription();
    }
    public  double getCost(){
        return this.coffee.getCost();
    }
}


class MilkDecorator extends Coffeedecorator {
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    public String getDescription(){
        return this.coffee.getDescription()+" with added milk";
    }

    public double getCost(){
        return this.coffee.getCost()+2;
    }
}
class WhippedCreamDecorator extends Coffeedecorator {
    public WhippedCreamDecorator(Coffee coffee){
        super(coffee);
    }

    public String getDescription(){
        return this.coffee.getDescription()+" with added cream";
    }

    public double getCost(){
        return this.coffee.getCost()+3;
    }
}

class BlackCoffee implements Coffee {
    double cost;
    String description;

    BlackCoffee(double cost, String description) {
        this.cost = cost;
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }
    public String getDescription(){
        return this.description;
    }
}

class ColdCoffee implements Coffee {
    double cost;
    String description;

    ColdCoffee(double cost, String description) {
        this.cost = cost;
        this.description = description;
    }

    public double getCost() {
        return this.cost;
    }
    public String getDescription(){
        return this.description;
    }
}

class Main{
    public static void main(String[] args) {
        ColdCoffee coldCoffee=new ColdCoffee(34, "So cold coffee that it will give you chills ");
        BlackCoffee blackCoffee=new BlackCoffee(234, "Black coffee and it is so caffeinated");

        System.out.println(coldCoffee.getDescription()+" price : "+coldCoffee.getCost());
        MilkDecorator coffeeWithMilk=new MilkDecorator(blackCoffee);
        System.out.println(coffeeWithMilk.getDescription());
    }
}