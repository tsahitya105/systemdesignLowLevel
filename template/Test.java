package DESIGNPATTERNS.template;

public class Test {

    public static void main(String args[]){
        PaymentTemplate p = new PayToMerchant();
        p.execute();
    }
}

abstract class PaymentTemplate{
    public abstract void validateRequest();
    public abstract void debitMoney();
    public abstract  void chargeFee();
    public abstract void creditMoney();


    //sequence of steps is defined
    public final void execute(){
        //
        validateRequest();
        //
        debitMoney();
        //
        chargeFee();
        //
        creditMoney();
    }
}


class PayToMerchant extends PaymentTemplate{

    public void validateRequest(){
        System.out.println(" validateRequest done");
    }
    public void debitMoney(){
        System.out.println(" debitMoney done");
    }
    public void chargeFee(){
        System.out.println(" chargeFee done");
    }
    public void creditMoney(){
        System.out.println(" creditMoney done");
    }
}