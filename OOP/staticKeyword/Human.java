package OOP.staticKeyword;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;

    static void message() {
        System.out.println("Hello world");
        // System.out.println(this.age); 
        // cant use "this" over here 
        System.out.println(population);
    }

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;

        //since this is a static data we use the class to update the value not 'this' keyword it is for the instance
        Human.population += 1;
    }
}
