package Item3;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class SingletonWithPublicFinalFieldTest {

    @Test
    public void instantiateSingletonWithPublicFinalField(){
        SingletonWithPublicFinalField singleton = SingletonWithPublicFinalField.INSTANCE;
        singleton.doSomething();
        SingletonWithPublicFinalField singleton2 = SingletonWithPublicFinalField.INSTANCE;
        singleton2.doSomething();

        assertTrue(singleton == singleton2);
    }


    @Test
    public void invokePrivateConstructorReflectively() {
        SingletonWithPublicFinalField singletonNormalInstantiated = SingletonWithPublicFinalField.INSTANCE;

        Class<? extends SingletonWithPublicFinalField> cl = null;

//            cl = (Class<? extends SingletonWithPublicFinalField>) Class.forName("SingletonWithPublicFinalField");
        cl = singletonNormalInstantiated.getClass();

        Constructor<? extends SingletonWithPublicFinalField> constructor = null;

        try {
            constructor = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        SingletonWithPublicFinalField singletonReflecttivelyInstantiated = null;
        try {
            //It is not working here. It throws an exception that you have no access to the modifier of this class
            singletonReflecttivelyInstantiated = constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        assertTrue(singletonNormalInstantiated == singletonReflecttivelyInstantiated);
    }
}