import me.invite.lib.Sequences;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CombinationTests {
    @Test
    public void sampleTest() {
        Integer[][] list = Sequences.toArray(
                Arrays.asList(
                        Arrays.asList(1, 3, 4, 5),
                        Arrays.asList(2),
                        Arrays.asList(3, 4)
                ));

        Assertions.assertArrayEquals(
                Sequences.getCombination(list),
                Sequences.toArray(Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 4),
                        Arrays.asList(3, 2, 3),
                        Arrays.asList(3, 2, 4),
                        Arrays.asList(4, 2, 3),
                        Arrays.asList(4, 2, 4),
                        Arrays.asList(5, 2, 3),
                        Arrays.asList(5, 2, 4)))
        );
    }

    @Test
    public void unorderedSequence() {
        Integer[][] list = Sequences.toArray(
                Arrays.asList(
                        Arrays.asList(2, 5, 3, 1),
                        Arrays.asList(2),
                        Arrays.asList(4, 3)
                ));

        Assertions.assertArrayEquals(
                Sequences.getCombination(list),
                Sequences.toArray(Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 4),
                        Arrays.asList(2, 2, 3),
                        Arrays.asList(2, 2, 4),
                        Arrays.asList(3, 2, 3),
                        Arrays.asList(3, 2, 4),
                        Arrays.asList(5, 2, 3),
                        Arrays.asList(5, 2, 4)))
        );
    }

    @Test
    public void emptySequence() {
        Integer[][] list = Sequences.toArray(Arrays.asList());

        Integer[][] combination = Sequences.getCombination(list);
        Assertions.assertArrayEquals(
                combination,
                Sequences.toArray(Arrays.asList())
        );
    }
}
