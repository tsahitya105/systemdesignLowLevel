package DESIGNPATTERNS.decorator;

public class Test2 {

    public static void main(String args[]){
        Pizza pizza =  new HalaTopping(new HalaTopping(new MozaTopping(new PizzaImpl())));
        System.out.println(pizza.decorate());
    }

}

interface Pizza{
    String decorate();
}


class PizzaImpl implements Pizza{
    public String decorate(){
        return "YO base pizza";
    }
}

abstract class PizzaDecorator implements Pizza{
    Pizza pizza;
    PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }
}

class MozaTopping extends PizzaDecorator{
    MozaTopping(Pizza pizza){
        super(pizza);
    }

    public String decorate(){
        return pizza.decorate() + " + moza topping";
    }
}

class HalaTopping extends PizzaDecorator{
    HalaTopping(Pizza pizza){
        super(pizza);
    }

    public String decorate(){
        return pizza.decorate() + " + hala topping";
    }
}