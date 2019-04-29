package edu.berkeley.aep;

public class Path implements Comparable<Path> {

    static final Path UNREACHABLE = new Path(-1);

    public int value;

    public Path(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Path)) return false;
        return value == ((Path) other).value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public int compareTo(Path other) {
        if (this.equals(other)) {
            return 0;
        } else if (other.equals(UNREACHABLE)){
            return -1;
        } else if (this.value < other.value){
            return -1;
        } else {
            return 1;
        }
    }
}
