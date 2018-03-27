package Item3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonWithStaticFactoryTest {
    
    @Test
    public void instantiateSingletonWithStaticFactory(){
        SingletonWithStaticFactory singleton = SingletonWithStaticFactory.getInstance();
        singleton.doSomething();
        SingletonWithStaticFactory singleton2 = SingletonWithStaticFactory.getInstance();
        singleton2.doSomething();

        assertTrue(singleton == singleton2);
    }
}