package edu.berkeley.aep;

//Understands the probability of a particular outcome
public class Chance implements Bestable<Chance>{
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(probability, ((Chance) other).probability) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    public Chance and(Chance other) {
        double productProb = this.probability * other.probability;
        return new Chance(productProb);
    }

    public Chance sum(Chance other) {
        double sumProb = this.probability + other.probability;
        return new Chance(sumProb);
    }

    public Chance diff(Chance other) {
        double diffProb = this.probability - other.probability;
        return new Chance(diffProb);
    }

    public Chance or(Chance other) {
        var sum = this.sum(other);
        var prod = this.and(other);
        return sum.diff(prod);
    }

    @Override
    public boolean betterThan(Chance other) throws IllegalArgumentException {
        if (other == null) {
            throw new IllegalArgumentException("Can't compare null objects");
        }
        if (equals (other)) return true;
        return this.probability > (other).probability;
    }
}
