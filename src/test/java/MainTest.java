import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class MainTest {
    @Disabled
    @Timeout(value = 22, unit = TimeUnit.SECONDS)
    @Test
    void workingTimeClass(){
        try {
            Main.main(null);
        } catch (Exception e){
            Assertions.fail();
        }
    }
}
