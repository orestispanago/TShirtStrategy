/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.models.TShirt;
import tshirtstrategy.strategy.BankPaymentImpl;
import tshirtstrategy.strategy.CardPaymentImpl;
import tshirtstrategy.strategy.CashPaymentImpl;
import tshirtstrategy.strategy.IPayment;

/**
 *
 * @author mac
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        TShirt tShirt = new TShirt("AAA", Color.ORANGE, Size.XL, Fabric.LINEN, 11);
       
//        System.out.println(" // ----------- //");
//        List<IPayment> payments = Arrays.asList(new IPayment[] {new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()});   // new ArrayList<>();
//        HashMap<String, Float> allPayments = new HashMap<>();
//        Context contextAll = new Context(payments);
//        allPayments = contextAll.executePayments(tShirt.getPrice(), 
//          tShirt.getColor(), tShirt.getSize(), tShirt.getFabric());
//        
//        HashMap<String, Float> allPayments2 = generateTShirtAndStategies();
//        
        /*
            from HashMap<String, Float> tht is filled from executePayments....
            we ask for a Set which contains a
            Map<String, Float>
            On this Map we call forEach in order to iterate within the Map
            Map.forEach returns an entry within the Map
        
        */
        
//        allPayments.entrySet().forEach(
//            entry->
//            {
//                System.out.println(entry.getKey() + " Price: " + entry.getValue());  
//            });
        
        
//        System.out.println(" // ----------- //");
        
//        allPayments2.entrySet().forEach(
//            entry->
//            {
//                System.out.println(entry.getKey() + " Price: " + entry.getValue());  
//            });
        
        
//        System.out.println(" // ----------- //");
        generateTShirtsAndStrategies(15).forEach(action->
        {
            System.out.println(" // ----------- //");
            action.entrySet().forEach(entry->
            {
                System.out.println(entry.getKey() + " Price: " + entry.getValue());
            });
        });
        
        // getAllPossibleCombinations fo TShirts and implement all strategies
        
        List<TShirt> tShirts = new ArrayList<TShirt>();
        // Color
        for (int i = 0; i < 7; i++) {
            Color color = Color.values()[i];
            // Size
            for (int j = 0; j < 7; j++) {
                Size size = Size.values()[j];
                // Fabric
                for (int k = 0; k < 7; k++) {
                    Fabric fabric = Fabric.values()[k];
                    tShirts.add(new TShirt(getRandomName(), color, size, fabric, getRandomNumberInRange(0,20)));
                }
                
            }
            
        }
    }
    
    public static List<HashMap<String, Float>> generateTShirtsAndStrategies(int noOfTShirts) {
        List<HashMap<String, Float>> aaa = new ArrayList<HashMap<String, Float>>();
        for(int i = 0; i < noOfTShirts; i++) {
            aaa.add(generateTShirtAndStategies());
        }
        return(aaa);
    }
    
    public static HashMap<String, Float> generateTShirtAndStategies() {
        // generate dynamically TShirts with all the implemented Payment strategies
        // Random number 0 - 6
        Color color = getRandomColor();
        Size size = getRandomSize();
        Fabric fabric = getRandomFabric();
                
        TShirt t1 = new TShirt(getRandomName(), color, size, fabric, getRandomNumberInRange(0,20));
        List<IPayment> payments = Arrays.asList(new IPayment[] {new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()});   // new ArrayList<>();
        HashMap<String, Float> allPayments = new HashMap<>();
        Context contextAll = new Context(payments);
        allPayments = contextAll.executePayments(t1.getPrice(), 
          t1.getColor(), t1.getSize(), t1.getFabric());
        return(allPayments);
        
    }
    
    public static String getRandomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return(generatedString);
    }
    
    private static Color getRandomColor() {
        Color color1 = Color.values()[getRandomNumberInRange(0,6)];
//        Color[] colors = Color.values();
//        Color color1 = null;
//        for (Color color : colors) {
//            if(getRandomNumberInRange(0,6) == color.ordinal()) {
//                color1 = color;
//            }
//        }
        return color1;
    }
    
    private static Size getRandomSize() {
        Size size1 = Size.values()[getRandomNumberInRange(0,6)];
        return size1;
    }
    
    private static Fabric getRandomFabric() {
        Fabric fabric1 = Fabric.values()[getRandomNumberInRange(0,6)];
        return fabric1;
    }
    
    private static int getRandomNumberInRange(int min, int max) {

	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }
}
