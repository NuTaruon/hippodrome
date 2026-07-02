import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Objects.isNull;
@Log4j2
public class Hippodrome {

    private static final Logger log = LogManager.getLogger(Hippodrome.class);
    private final List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        if (isNull(horses)) {
            log.error("Horses cannot be null.");
            throw new IllegalArgumentException();
        } else if (horses.isEmpty()) {
            log.error("Horses cannot be empty.");
            throw new IllegalArgumentException();
        }

        this.horses = horses;
        log.debug("Создание Hippodrome, лошадей [" + horses.size() + "]");
    }

    public List<Horse> getHorses() {
        return Collections.unmodifiableList(horses);
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .get();
    }
}
