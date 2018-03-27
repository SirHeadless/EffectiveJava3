package Item3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonSingleElementEnumTest {

    @Test
    public void instantiateSingletonSingleElementEnum(){
        SingletonSingleElementEnum singleton = SingletonSingleElementEnum.INSTANCE;
        singleton.doSomething();
        SingletonSingleElementEnum singleton2 = SingletonSingleElementEnum.INSTANCE;
        singleton2.doSomething();

        assertTrue(singleton == singleton2);
    }
}