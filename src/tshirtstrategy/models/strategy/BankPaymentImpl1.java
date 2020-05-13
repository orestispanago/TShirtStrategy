package tshirtstrategy.models.strategy;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;

public class BankPaymentImpl1 implements IPayment {

    @Override
    public float pay(float basePrice,Color color, Size size, Fabric fabric) {
        float result = basePrice;
        // implementation via cards
        result += color.getColorPrice(color.ordinal());
        result += size.getSizePrice(size.ordinal());
        result += fabric.getFabricPrice(fabric.ordinal());
        result *= 1.01f;
        return result;
    }

}
