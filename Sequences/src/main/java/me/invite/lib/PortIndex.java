package me.invite.lib;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PortIndex {
    final List<Integer> numbers;

    public PortIndex(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public PortIndex(Integer... numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return String.format("PortIndex{%s}", numbers.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortIndex portIndex = (PortIndex) o;

        return Objects.equals(numbers, portIndex.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}