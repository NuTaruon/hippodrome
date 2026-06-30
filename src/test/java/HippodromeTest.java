import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class HippodromeTest {

    @Test
    void nullValueConstruction (){
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Hippodrome(null);
        });
        Assertions.assertEquals("Horses cannot be null.",e.getMessage());
    }

    @Test
    void blankValueConstruction (){
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(new ArrayList<>());
        });
        Assertions.assertEquals("Horses cannot be empty.",e.getMessage());
    }

    @Test
    void getHorsesTest(){
        List <Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("" + i,1,1));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertArrayEquals(horses.toArray(), hippodrome.getHorses().toArray());
    }

    @Test
    void getWinnerTest(){
        Horse winner = null;
        double distance = 0;
        List <Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Horse horse = new Horse("" + i,1, Math.random() * 5000);
            if(horse.getDistance()> distance){
                winner = horse;
                distance = horse.getDistance();
            }
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        Assertions.assertEquals(winner,hippodrome.getWinner());

    }

}
