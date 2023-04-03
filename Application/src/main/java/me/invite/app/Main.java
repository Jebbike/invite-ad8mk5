package me.invite.app;

import me.invite.lib.Port;
import me.invite.lib.PortIndex;
import me.invite.lib.Sequences;

import java.util.*;

import static me.invite.lib.Sequences.printList;

public class Main {
    public static Map<PortIndex, Port> ports = new HashMap<>();

    public static void main(String[] args) {
        String[] indexes = new String[]{"1,3-5", "2", "3-4"};

        Integer[][] sequences = Sequences.parseSequences(indexes);

        printList(sequences, "Sequences");
        printList(Sequences.getCombination(sequences), "Combinations");
    }
}
