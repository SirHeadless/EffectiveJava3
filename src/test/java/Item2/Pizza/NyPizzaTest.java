package Item2.Pizza;

import org.junit.Test;

import static org.junit.Assert.*;

public class NyPizzaTest {


    @Test
    public void instantiateNyPizzaTest(){
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.MUSHROOM).build();

        System.out.println(nyPizza);
    }
}