package not.hub.aoc2021.tests;

import not.hub.aoc2021.day4.GiantSquid1;
import not.hub.aoc2021.tests.util.AssertWrapper;
import not.hub.aoc2021.tests.util.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

@DisplayName("Day 4: Giant Squid")
@Execution(ExecutionMode.CONCURRENT)
class Day4Test {

    private static final List<String> example = InputParser.stringList("inputs/day4_example");
    private static final List<String> input = InputParser.stringList("inputs/day4");

    @Test
    @DisplayName("Part 1 - Example")
    void part1_example(TestInfo info) {
        AssertWrapper.equals(4512, new GiantSquid1().solve(example), info);
    }

    @Test
    @DisplayName("Part 1")
    void part1(TestInfo info) {
        AssertWrapper.equals(-1, new GiantSquid1().solve(input), info);
    }

}
