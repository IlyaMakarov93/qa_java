package tests;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testEatMeatException() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenThrow(new Exception());
        feline.eatMeat();
    }

    @Test
    public void testGetFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensMethodWithoutParams() {
        int expected = 1;
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetKittensMethodWithParams() {
        int expected = 2;
        int actual = feline.getKittens(2);
        Assert.assertEquals(expected, actual);
    }
}
