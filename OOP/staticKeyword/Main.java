package OOP.staticKeyword;

//data or methods from another class in the same package need not to be imported
public class Main {
    public static void main(String[] args) {
        // Human kunal = new Human(22, "Kunal", 10000, false);
        // System.out.println(Human.population);
        // Human rahul = new Human(34, "Rahul", 15000, true);
        // System.out.println(Human.population);
        // Human arpit = new Human(34, "Arpit", 15000, true);
        // System.out.println(Human.population);

        Main funn = new Main();
        funn.fun2();

        fun();
    }

    // this is not dependent on objects
    static void fun() {
//        greeting(); // you cant use this because it requires an instance
        // but the function you are using it in does not depend on instances

        // you cannot access non static stuff without referencing their instances in
        // a static context

        // hence, here I am referencing it
        Main obj = new Main();
        obj.greeting();

        new Main().greeting();
    }

    void fun2() {
        //non static methods can call other non static methods since anyways we will need to create a instance of the class to call the method
        greeting();
    }

    // we know that something which is not static, belongs to an object
    void greeting() {
//        fun();
        System.out.println("Hello world");
    }
}
