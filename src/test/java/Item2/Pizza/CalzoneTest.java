package Item2.Pizza;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalzoneTest {

    @Test
    public void instantiateCalzonePizza() {
        Calzone calzone = new Calzone.Builder(true)
                .addTopping(Pizza.Topping.MUSHROOM)
                .addTopping(Pizza.Topping.HAM).build();

        System.out.println(calzone);
    }

}