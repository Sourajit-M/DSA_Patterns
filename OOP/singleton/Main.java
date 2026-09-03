package oop.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance(1);
        System.out.println(obj1);

        Singleton obj2 = Singleton.getInstance(2);
        System.out.println(obj2);

        System.out.println(obj1.id);
        System.out.println(obj2.id);
        //value of the obj2 is not updated since we haven't added any update function

        //both object point to the same reference
    }
}
