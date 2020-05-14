/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtstrategy;

import java.util.HashMap;
import java.util.List;
import tshirtstrategy.models.Color;
import tshirtstrategy.models.Fabric;
import tshirtstrategy.models.Size;
import tshirtstrategy.strategy.IPayment;

/**
 *
 * @author mac
 */
public class Context {
    IPayment payment;
    List<IPayment> payments;
    
    public Context(IPayment payment) {
        this.payment = payment;
    }
    
    public Context(List<IPayment> payments) {
        this.payments = payments;
    }
    
    public float executePayment(float basePrice, Color color, Size size, Fabric fabric) {
        return payment.pay(basePrice, color, size, fabric);
    }
    
    // executePayments(float basePrice, Color color, Size size, Fabric fabric)
    public HashMap<String, Float> executePayments(float basePrice, Color color, Size size, Fabric fabric) {
        HashMap<String, Float> pays = new HashMap<>();
        for(IPayment payment: payments) {
           pays.put(payment.getClass().getSimpleName(), payment.pay(basePrice, color, size, fabric));
        }
        return pays;
    }
    
    
    
}
