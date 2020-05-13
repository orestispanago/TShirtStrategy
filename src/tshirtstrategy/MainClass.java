package tshirtstrategy;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.models.strategy.CardPaymentImpl;
import tshirtstrategy.models.strategy.IPayment;


public class MainClass {


    public static void main(String[] args) {
        TShirt tshirt1 = new TShirt("AAA",Color.ORANGE,Size.XL,Fabric.LINEN,10);
        IPayment payment = new CardPaymentImpl();
        float price = payment.pay(tshirt1.getPrice(), tshirt1.getColor(),tshirt1.getSize(),tshirt1.getFabric());
        System.out.println("Price:"+price);
    }

}
