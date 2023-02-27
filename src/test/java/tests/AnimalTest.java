package tests;

import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Unknown");
    }
}
