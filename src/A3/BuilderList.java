package A3;

import java.util.ArrayList;
import java.util.LinkedList;

public class BuilderList<T> {
    private LinkedList<T> linkedList = new LinkedList<>();
    private Object[] array;
    private boolean adding = true;

    BuilderList() {
    }

    void add(int index, T element) {
        linkedList.add(index, element);
    }

    Object get(int index) {
        if (adding) {
            setGetting();
        }

        return array[index];
    }

    private void setGetting() {
        adding = false;
        array = linkedList.toArray();
    }
}
