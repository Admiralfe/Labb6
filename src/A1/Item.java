package A1;

import java.util.Arrays;
import java.util.Iterator;

public class Item extends Component {

    Item(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }
    public String toString() {
        return "a " + name;
    }

    float getWeight() {
        return weight;
    }

    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Component next() {
                throw new UnsupportedOperationException("Cannot iterate through item.");
            }
        };
    }
}
