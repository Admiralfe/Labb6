package A3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class A3Main {
    private static final int n = 500000;
    private static void linkedListTest() {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }

        long addTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(n - 1));
        }

        long finishedTime = System.nanoTime() - startTime;
        long addingTime = addTime - startTime;
        System.out.println("Linked list test");
        System.out.println("Adding time in ms: " + addingTime / 1_000_000f);
        System.out.println("Total time in ms: " + finishedTime / 1_000_000f);
    }

    private static void arrayListTest() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }

        long addTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(n - 1));
        }

        long finishedTime = System.nanoTime() - startTime;
        long addingTime = addTime - startTime;
        System.out.println("Array list test");
        System.out.println("Adding time in ms: " + addingTime / 1_000_000f);
        System.out.println("Total time in ms: " + finishedTime / 1_000_000f);
    }

    private static void builderListTest() {
        Random random = new Random();
        BuilderList<Integer> list = new BuilderList<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }

        long addTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(n - 1));
        }

        long finishedTime = System.nanoTime() - startTime;
        long addingTime = addTime - startTime;
        System.out.println("Builder list test");
        System.out.println("Adding time in ms: " + addingTime / 1_000_000f);
        System.out.println("Total time in ms: " + finishedTime / 1_000_000f);
    }

    public static void main(String args[]) {
        linkedListTest();
        arrayListTest();
        builderListTest();
    }
}
