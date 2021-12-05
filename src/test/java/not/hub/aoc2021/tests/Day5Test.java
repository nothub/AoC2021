package not.hub.aoc2021.tests;

import not.hub.aoc2021.day5.HydrothermalVenture1;
import not.hub.aoc2021.day5.HydrothermalVenture2;
import not.hub.aoc2021.tests.util.AssertWrapper;
import not.hub.aoc2021.tests.util.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DisplayName("Day 5: Hydrothermal Venture")
@Execution(ExecutionMode.CONCURRENT)
class Day5Test {

    private static final List<String> example = Collections.unmodifiableList(InputParser.stringList("inputs/day5_example"));
    private static final List<String> input = Collections.unmodifiableList(InputParser.stringList("inputs/day5"));

    @Test
    @DisplayName("Part 1 - Example")
    void part1_example(TestInfo info) {
        //AssertWrapper.equals(5, new HydrothermalVenture1().solve(new ArrayList<>(example)), info);
    }

    @Test
    @DisplayName("Part 1")
    void part1(TestInfo info) {
        //AssertWrapper.equals(-1, new HydrothermalVenture1().solve(new ArrayList<>(input)), info);
    }

    @Test
    @DisplayName("Part 2 - Example")
    void part2_example(TestInfo info) {
        //AssertWrapper.equals(-1, new HydrothermalVenture2().solve(new ArrayList<>(example)), info);
    }

    @Test
    @DisplayName("Part 2")
    void part2(TestInfo info) {
        //AssertWrapper.equals(-1, new HydrothermalVenture2().solve(new ArrayList<>(input)), info);
    }

}
