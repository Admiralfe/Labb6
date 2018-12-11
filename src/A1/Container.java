package A1;

import com.sun.prism.impl.QueuedPixelSource;

import java.util.*;

public class Container extends Component{

    private ArrayList<Component> children;

    Container(String name, float weight) {
        this.name = name;
        this.weight = weight;

        this.children = new ArrayList<>();
    }

    void add(Component component) {
        children.add(component);
    }

    public String toString() {
        String res = "a " + name;
        if (children.isEmpty()) {
            res += " that is empty.";
        } else {
            res += " which contains ";
            if (children.size() == 1) {
                res += children.get(0).toString();
            } else {
                for (int i = 0; i < children.size(); i++) {
                    //For all but the last element, add commas.
                    if (i < children.size() - 1) {
                        res += children.get(i).toString() + ", ";
                    }
                    //For the last element we add "and ", so that the string becomes somewhat grammatically correct.
                    else {
                        res = res.substring(0, res.length() - 2);
                        res += " and " + children.get(i).toString();
                    }
                }
            }
        }

        return res;
    }

    float getWeight() {
        //Add the containers own weight
        float total = weight;

        for (Component c : children) {
            total += c.getWeight();
        }

        return total;
    }

    public Object clone() throws CloneNotSupportedException{
        Container copy = (Container) super.clone();
        //Copies the array, does not create children of the referenced object, which we need to do ourselves.
        copy.children = (ArrayList<Component>) this.children.clone();

        for (int i = 0; i < this.children.size(); i++) {
            //Clones each of the children (this will recurse when another container is encountered, ensuring a deep copy.
            copy.children.set(i, (Component) copy.children.get(i).clone());
        }

        return copy;
    }

    @Override
    public Iterator<Component> iterator() {
        return DFiterator();
        //return BFiterator();
    }

    private Iterator<Component> BFiterator() {
        Queue<Component> queue = new LinkedList<>();
        for (Component c : children) {
            queue.add(c);
        }

        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Component next() {
                Component c = queue.poll();
                if (c instanceof Container) {
                    for (Component child : ((Container) c).children) {
                        queue.add(child);
                    }
                }

                return c;
            }
        };
    }

    private Iterator<Component> DFiterator() {
        Stack<Component> stack = new Stack<>();
        for (Component c : children) {
            stack.add(c);
        }

        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Component next() {
                Component c = stack.pop();
                if (c instanceof Container) {
                    for (Component child : ((Container) c).children) {
                        stack.add(child);
                    }
                }

                return c;
            }
        };
    }

}
