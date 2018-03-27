package Item3;

public class SingletonWithPublicFinalField {

    public static final SingletonWithPublicFinalField INSTANCE = new SingletonWithPublicFinalField();

    private static int numberOfInstantiations;

    private SingletonWithPublicFinalField(){
        numberOfInstantiations++;
        System.out.println("This SingletonWithPublicFinalField class was instantiated " + numberOfInstantiations + " times");
    }

    public void doSomething(){
        System.out.println("Object is doing something");
    }
}
