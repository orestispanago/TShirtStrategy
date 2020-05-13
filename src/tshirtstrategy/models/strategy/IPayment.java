package tshirtstrategy.models.strategy;

import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;


public interface IPayment {
    float pay(float basePrice,Color color, Size size,Fabric fabric);
}
