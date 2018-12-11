package A1;

public class Main {
    public static void main(String[] args) {
        Container suitcase = new Container("suitcase", 5);
        Container bag = new Container("bag", 1);
        Container knapsack = new Container("knapsack", 2);
        Container plasticBag = new Container("plastic bag", 0.01f);

        Item comb = new Item("comb", 0.1f);
        Item toothBrush = new Item("toothbrush", 0.05f);
        Item razor = new Item("razor", 0.1f);
        Item toothPaste = new Item("toothpaste", 0.2f);
        Item tshirt = new Item("t-shirt", 1f);
        Item trousers = new Item("trousers", 0.5f);

        suitcase.add(bag);
        suitcase.add(knapsack);
        suitcase.add(tshirt);
        suitcase.add(trousers);
        bag.add(plasticBag);
        plasticBag.add(toothBrush);
        plasticBag.add(toothPaste);
        knapsack.add(razor);
        knapsack.add(comb);

        System.out.println(suitcase.toString());
        System.out.println("Total weight: " + suitcase.getWeight());

        for (Component c : suitcase) {
            System.out.println(c.name);
        }

        Container copy;
        try {
            copy = (Container) suitcase.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Clone not supported.");
            return;
        }

        for (Component c : copy) {
            System.err.println("Hash codes for copy elements " + c.hashCode());
        }

        for (Component c: suitcase) {
            System.err.println("Hash codes for original elements " + c.hashCode());
        }
    }
}
