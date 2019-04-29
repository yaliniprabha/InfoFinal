package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final int size;
    protected final Unit unit;

    public ScaledQuantity(int size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        return equals((ScaledQuantity) other);
    }

    public boolean equals(ScaledQuantity other) {
        return this.size == other.convertTo(unit);
    }

    protected int convertTo(Unit toUnits) {
        return unit.convertTo(toUnits, size);
    }

    @Override
    public String toString() {
        return size + " " + unit;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(size);
    }

    @Override
    public boolean betterThan(ScaledQuantity other) throws IllegalArgumentException {
        if (other == null)
            throw new IllegalArgumentException("Can't compare null object");
        if (equals (other)) {
            return true;
        }
        return this.size > other.convertTo(unit);
    }
}
