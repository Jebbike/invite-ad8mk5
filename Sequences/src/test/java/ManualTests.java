import me.invite.lib.Sequences;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static me.invite.lib.Sequences.printList;


@Disabled
public class ManualTests {
    @Test
    public void simpleManualTest() {
        String[] indexes = new String[]{"1,3-33", "2,4,5,6-12", "3-4,11,12-15"};

        Integer[][] sequences = Sequences.parseSequences(indexes);

        printList(sequences, "Sequences");
        printList(Sequences.getCombination(sequences), "Combinations");
    }
}
