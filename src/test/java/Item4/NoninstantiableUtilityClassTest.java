package Item4;

import Item3.SingletonWithPublicFinalField;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoninstantiableUtilityClassTest {

//    @Test
//    public void instantiateSingletonWithPublicFinalField(){
//        NoninstantiableUtilityClass shouldNotCompile = new NoninstantiableUtilityClass();
//    }

    @Test
    public void doSomethingTest(){
        NoninstantiableUtilityClass.utilityMethod();
    }
}