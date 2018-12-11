package A2;

public abstract class Human {
    String name;
    int age;

    private Human() {
    }

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String toString();
    public int getAge() { return age; }
    public String getName() { return name; }

    public static class Fysiker extends Human {
        private int year;

        private Fysiker(String name, int age, int year) {
            this.name = name;
            this.age = age;
            this.year = year;
        }

        public int getYear() { return year; }

        public String toString() {
            return name + ", ålder " + age + " år, började fysik " + year;
        }
    }

    public static class Datalog extends Human {
        private int year;

        private Datalog(String name, int age, int year) {
            this.name = name;
            this.age = age;
            this.year = year;
        }

        public int getYear() { return year; }

        public String toString() {
            return name + ", ålder " + age + " år, började data " + year;
        }
    }

    public static Human create(String name, String year, int age) {
        char firstLetter = year.charAt(0);
        int yearInt = Integer.parseInt(year.substring(1));
        if (yearInt < 32) {
            yearInt += 2000;
        } else {
            yearInt += 1900;
        }

        switch (firstLetter) {
            case 'F':
                return new Fysiker(name, age, yearInt);
            case 'D':
                return new Datalog(name, age, yearInt);
            default:
                return null;
        }
    }
}
