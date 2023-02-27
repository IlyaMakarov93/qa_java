package tests;

import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String animalKind;
    private final List<String> expected;

    public AnimalParameterizedTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);
        Assert.assertEquals(expected, actual);
    }
}
