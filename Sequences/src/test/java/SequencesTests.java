import me.invite.lib.Sequences;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SequencesTests {
    @Test
    public void sampleTest() {
        Assertions.assertArrayEquals(
                Sequences.parseSequences(new String[]{"1,3-5", "2", "3-4"}),

                Sequences.toArray(Arrays.asList(
                        Arrays.asList(1, 3, 4, 5),
                        Arrays.asList(2),
                        Arrays.asList(3, 4)
                )));
    }

    @Test
    public void emptySequenceTest() {
        Assertions.assertArrayEquals(
                Sequences.parseSequences(new String[]{}),
                Sequences.toArray(Arrays.asList())
        );
    }

    @Test
    public void singletonSequenceTest() {
        Assertions.assertArrayEquals(
                Sequences.parseSequences(new String[]{"1"}),
                Sequences.toArray(Arrays.asList(Arrays.asList(1)))
        );
    }

    @Test
    public void brokenSequenceTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Sequences.parseSequences(new String[]{"1,2,3,-4-5-,"});
        });
    }

    @Test
    public void brokenSequenceIntervalTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Sequences.parseSequences(new String[]{"5-2"});
        });
    }

    @Test
    public void brokenSequenceParseTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Sequences.parseSequences(new String[]{"5-asd"});
        });
    }
}
