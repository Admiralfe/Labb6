package A2;

public class A2Main {
    /*
    public static class Test extends Human {

        Test() {
            super();
        }

        public String toString() { return null; }
    }
    */

    public static void main(String[] args) {
        Human fysiker1 = Human.create("a", "F16", 15);
        Human datalog1 = Human.create("b", "D96", 20);

        System.out.println(fysiker1.toString());
        System.out.println(datalog1.toString());

        //Human.Datalog datalog = new Human.Datalog();
        //Human.Fysiker fysiker = new Human.Fysiker();
    }
}
