package Item1;

import java.util.HashMap;
import java.util.Map;

public class ClassWithStaticFactoryMethod {

    private static final ClassWithStaticFactoryMethod CWSFMforUNone = new ClassWithStaticFactoryMethod(5);
    private static final ClassWithStaticFactoryMethod CWSFMforUNtwo = new ClassWithStaticFactoryMethod(10);

    private static Map<Integer,ClassWithStaticFactoryMethod> somethingLikeACash
            = new HashMap<Integer, ClassWithStaticFactoryMethod>()
    {
        {
            put(1, CWSFMforUNone);
            put(2, CWSFMforUNtwo);
        }
    };

    private int uselessNumber;

    private ClassWithStaticFactoryMethod(int uselessNumber) {
        this.uselessNumber = uselessNumber;
    }

    public static ClassWithStaticFactoryMethod getInstance(int uselessNumber) {
        ClassWithStaticFactoryMethod instance = somethingLikeACash.get(uselessNumber);

        return instance != null ? instance : new ClassWithStaticFactoryMethod(uselessNumber);
    }

    @Override
    public String toString() {
        return "ClassWithStaticFactoryMethod{" +
                "uselessNumber=" + uselessNumber +
                '}';
    }
}
