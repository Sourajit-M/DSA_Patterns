package oop.singleton;

//a class can have only one instance is called Singleton class
public class Singleton {
    int id;
    private Singleton(int id){
        this.id = id;
    }

    static Singleton instance;

    static Singleton getInstance(int id){
        //if any instance is not created then create else just return instance which was created before
        if(instance == null)
            instance = new Singleton(id);

        return instance;
    }
}
