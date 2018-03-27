package Item3;

public class SingletonWithStaticFactory {

    private static final SingletonWithStaticFactory INSTANCE = new SingletonWithStaticFactory();

    private static int numberOfInstantiations;

    public static SingletonWithStaticFactory getInstance() {
        return INSTANCE;
    }

    private SingletonWithStaticFactory() {
        numberOfInstantiations++;
        System.out.println("This SingletonWithStaticFactory class was instantiated " + numberOfInstantiations + " times");
    }


    public void doSomething(){
        System.out.println("Object is doing something");
    }
}
