package Item1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassWithStaticFactoryMethodTest {

    @Test
    public void instantiatingClassTest() {
        System.out.println(ClassWithStaticFactoryMethod.getInstance(1));
        System.out.println(ClassWithStaticFactoryMethod.getInstance(2));
        System.out.println(ClassWithStaticFactoryMethod.getInstance(3));
        System.out.println(ClassWithStaticFactoryMethod.getInstance(5));
    }

}