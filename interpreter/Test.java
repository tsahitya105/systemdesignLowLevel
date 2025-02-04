package DESIGNPATTERNS.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String args[]){
        Context context = new Context();
        context.put("a",4);
        context.put("b",5);

        context.put("c",1);
        context.put("d",2);

        Expression e1 = new MultiplyNonTerminalExpression(new NumberTerminalExpression("a"), new NumberTerminalExpression("b"));
        Expression e2 = new MultiplyNonTerminalExpression(new NumberTerminalExpression("c"), new NumberTerminalExpression("d"));
        Expression e3 = new MultiplyNonTerminalExpression(e1, e2);

        System.out.println(e3.interpret(context));
    }
}

class Context{
    Map<String,Integer> hm = new HashMap<>();

    public void put(String s,Integer i){
        hm.put(s,i);
    }
}

interface Expression{
    public int interpret(Context c);
}


class MultiplyNonTerminalExpression implements Expression{
    Expression left;
    Expression right;
    MultiplyNonTerminalExpression(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }

    public int interpret(Context c){
        return left.interpret(c)*right.interpret(c);
    }
}

class NumberTerminalExpression implements Expression{
    String val;

    NumberTerminalExpression(String val) {
        this.val = val;
    }

    public int interpret(Context c){
        return c.hm.get(this.val);
    }
}