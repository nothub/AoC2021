package not.hub.aoc2021.tests;

import not.hub.aoc2021.day6.Lanternfish1;
import not.hub.aoc2021.tests.util.AssertWrapper;
import not.hub.aoc2021.tests.util.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@DisplayName("Day 6: Lanternfish")
@Execution(ExecutionMode.CONCURRENT)
class Day6Test {

    private static final String example = InputParser.string("inputs/day6_example");
    private static final String input = InputParser.string("inputs/day6");

    @Test
    @DisplayName("Part 1 - Example")
    void part1_example(TestInfo info) {
        AssertWrapper.equals(5934, new Lanternfish1().solve(example), info);
    }
    @Test
    @DisplayName("Part 1")
    void part1(TestInfo info) {
        AssertWrapper.equals(379114, new Lanternfish1().solve(input), info);
    }

}
