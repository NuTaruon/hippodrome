import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


class HorseTest {

    @Test
    void nullNameException() {
           IllegalArgumentException e =  Assertions.assertThrows(IllegalArgumentException.class, () -> {
              new Horse(null,10,10);
            });

           Assertions.assertEquals("Name cannot be null.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","  ","\n\n\n", "\t\t\t"})
    void blankNameException(String str) {
        IllegalArgumentException e =  Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse(str,10,10);
        });

        Assertions.assertEquals("Name cannot be blank.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5000, -300})
    void negativeParameterConstruction(int number){
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Name", number , 10);
        });
        Assertions.assertEquals("Speed cannot be negative.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Name", 10, number);
        });
        Assertions.assertEquals("Distance cannot be negative." , e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Gera", "Pol", "Kukla"})
    void getNameTest(String name){
       Horse horse = new Horse(name, 1 ,1);
       Assertions.assertEquals(name, horse.getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 20, 49})
    void getNumberParameters(int number){
        Horse horse = new Horse("name", number ,1);
        Assertions.assertEquals(number, horse.getSpeed());
        horse = new Horse("name", 1 , number);
        Assertions.assertEquals(number, horse.getDistance());
    }

}
