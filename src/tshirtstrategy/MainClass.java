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

public class MainClass {

    public static void main(String[] args) {
        generateAllTShirtsAndStrategies(getAllTShirtCombos()).forEach(action
                -> {
            System.out.println(" // ----------- //");
            action.entrySet().forEach(entry
                    -> {
                System.out.println(entry.getKey() + " Price: " + entry.getValue());
            });
        });

    }

    public static List<TShirt> getAllTShirtCombos() {
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
                    tShirts.add(new TShirt(getRandomName(), color, size, fabric, getRandomNumberInRange(0, 20)));
                }
            }
        }
        return tShirts;

    }

    public static List<HashMap<String, Float>> generateAllTShirtsAndStrategies(List<TShirt> tShirtList) {
        List<HashMap<String, Float>> allTshirtAndStrategies = new ArrayList<HashMap<String, Float>>();
        for (int i = 0; i < tShirtList.size(); i++) {
            allTshirtAndStrategies.add(generateTShirtAndStategies(tShirtList.get(i)));
        }
        return (allTshirtAndStrategies);
    }

    public static HashMap<String, Float> generateTShirtAndStategies(TShirt t1) {
        HashMap<String, Float> allPayments = new HashMap<>();
        List<IPayment> payments = Arrays.asList(new IPayment[]{new CardPaymentImpl(), new BankPaymentImpl(), new CashPaymentImpl()});   // new ArrayList<>();
        Context contextAll = new Context(payments);
        allPayments = contextAll.executePayments(t1.getPrice(), t1.getColor(), t1.getSize(), t1.getFabric());
        return (allPayments);
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

        return (generatedString);
    }

    private static Color getRandomColor() {
        Color color1 = Color.values()[getRandomNumberInRange(0, 6)];
        return color1;
    }

    private static Size getRandomSize() {
        Size size1 = Size.values()[getRandomNumberInRange(0, 6)];
        return size1;
    }

    private static Fabric getRandomFabric() {
        Fabric fabric1 = Fabric.values()[getRandomNumberInRange(0, 6)];
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
