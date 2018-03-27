package Item2;

import Item2.NutritionFacts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class NutritionFactsTest {

    @Test
    public void createNutritionFactsTest() {
        NutritionFacts  nutritionFacts = new NutritionFacts.Builder(2,3).calories(4).fat(10).build();
        System.out.println(nutritionFacts);
    }

}
