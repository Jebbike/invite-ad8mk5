package me.invite.lib;

import java.util.*;

public class Sequences {

    public static Integer[][] parseSequences(String[] indexes) {
        List<List<Integer>> sequences = new ArrayList<>();

        for (String index : indexes) {
            sequences.add(parseSequence(index));
        }

        return toArray(sequences);
    }
    private static List<List<Integer>> sortedList(List<List<Integer>> lists) {
        lists.sort((o1, o2) -> {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        });

        return lists;
    }

    private static List<Integer> parseSequence(String sequenceString) {
        List<Integer> sequence = new ArrayList<>();

        String[] compressedSequences = sequenceString.split(",");
        for (String compressedSequence : compressedSequences) {
            sequence.addAll(decompress(compressedSequence));
        }

        return sequence;
    }

    private static List<Integer> decompress(String compressedSequence) {
        try {
            String[] split = compressedSequence.split("-");
            if (split.length > 2) {
                throw new IllegalArgumentException("Wrong compression: " + compressedSequence);
            }

            if (split.length == 1) {
                return Arrays.asList(Integer.parseInt(compressedSequence));
            }

            List<Integer> sequence = new ArrayList<>();
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);

            if (from >= to) {
                throw new IllegalArgumentException(String.format("Wrong compression: from(%s) >= to(%s): ", from, to));
            }
            for (int n = from; n <= to; n++) {
                sequence.add(n);
            }

            return sequence;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid subsequence: " + compressedSequence);
        }
    }
    public static Integer[][] getCombination(Integer[][] list) {
        return toArray(getCombination(0, list));
    }

    public static Integer[][] toArray(List<List<Integer>> list) {
        return list.stream()
                .map(arr -> arr.toArray(new Integer[0]))
                .toArray(Integer[][]::new);
    }

    private static List<List<Integer>> getCombination(int currentIndex, List<List<Integer>> list) {
        if (currentIndex == list.size()) {
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(new ArrayList<>());
            return combinations;
        }
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> containerItemList = list.get(currentIndex);
        List<List<Integer>> suffixList = getCombination(currentIndex + 1, list);

        for (Integer containerItem : containerItemList) {
            for (List<Integer> suffix : suffixList) {
                List<Integer> nextCombination = new ArrayList<>();
                nextCombination.add(containerItem);
                nextCombination.addAll(suffix);
                combinations.add(nextCombination);
            }
        }

        return sortedList(combinations);
    }

    private static List<List<Integer>> getCombination(int currentIndex, Integer[][] list) {
        if (currentIndex == list.length) {
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(new ArrayList<>());
            return combinations;
        }
        List<List<Integer>> combinations = new ArrayList<>();
        Integer[] sublist = list[currentIndex];
        List<List<Integer>> suffixList = getCombination(currentIndex + 1, list);

        for (Integer number : sublist) {
            for (List<Integer> suffix : suffixList) {
                List<Integer> nextCombination = new ArrayList<>();
                nextCombination.add(number);
                nextCombination.addAll(suffix);
                combinations.add(nextCombination);
            }
        }
        return sortedList(combinations);
    }

    public static void printList(Integer[][] lists, String name) {
        System.out.println(name + ":");
        for (Integer[] s : lists)
            System.out.print(Arrays.toString(s) + " ");
        System.out.print('\n');
    }

    @Deprecated
    private static List<List<Integer>> toList(Integer[][] integers) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (Integer[] integer : integers) {
            numbers.add(new ArrayList<>(Arrays.asList(integer)));
        }
        return numbers;
    }
}
