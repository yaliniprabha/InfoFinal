package edu.berkeley.aep;

public class ArithmeticQuantity extends ScaledQuantity{
    public ArithmeticQuantity(int size, Unit unit) {
        super(size, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(size + other.convertTo(unit), unit);
    }
}
