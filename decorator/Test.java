package DESIGNPATTERNS.decorator;

public class Test {
    public static void main(String args[]){
        ChristmasTree christmasTree = new Garland(new BubbleLights(new ChristmasTreeImpl()));

        System.out.println(christmasTree.decorate());
    }
}


interface ChristmasTree{
    String decorate();
}

class ChristmasTreeImpl implements ChristmasTree{

    public String decorate(){
        return "Christmas tree";
    }
}

abstract class ChristmasTreeDecorator implements ChristmasTree{
    ChristmasTree christmasTree;

    public ChristmasTreeDecorator(ChristmasTree christmasTree){
        this.christmasTree = christmasTree;
    }

    @Override
    public String decorate(){
        return christmasTree.decorate();
    }

}


class Garland extends ChristmasTreeDecorator{

    public Garland(ChristmasTree christmasTree){
        super(christmasTree);
    }

    @Override
    public String decorate(){
        return christmasTree.decorate() + decorateWIthGarland();
    }

    public String decorateWIthGarland(){
        return " with Garland";
    }
}

class BubbleLights extends ChristmasTreeDecorator{

    public BubbleLights(ChristmasTree christmasTree){
        super(christmasTree);
    }

    @Override
    public String decorate(){
        return christmasTree.decorate() + decorateWIthBubbleLights();
    }

    public String decorateWIthBubbleLights(){
        return " with BubbleLights";
    }
}