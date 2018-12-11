package A1;

public abstract class Component implements Iterable<Component>, Cloneable {
    String name;
    float weight;
    public abstract String toString();
    abstract float getWeight();

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
