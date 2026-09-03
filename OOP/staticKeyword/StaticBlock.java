package OOP.staticKeyword;

// this is a demo to show initialisation of static variables
public class StaticBlock {
    static int a = 4;
    static int b;

    // will only run once, when the first obj is create i.e. when the class is loaded for the first time
    static {
        System.out.println("I am in static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;

        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();
        // System.out.println(StaticBlock.a + " " + StaticBlock.b); we can also call with var_name as they are static
        System.out.println(a + " " + b);
        // System.out.println(obj2.a + " " + obj2.b); we can also call this way but not recommended
    }

}
