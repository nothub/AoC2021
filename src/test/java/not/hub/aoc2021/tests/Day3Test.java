package not.hub.aoc2021.tests;

import not.hub.aoc2021.day3.BinaryDiagnostic1;
import not.hub.aoc2021.day3.BinaryDiagnostic2;
import not.hub.aoc2021.tests.util.AssertWrapper;
import not.hub.aoc2021.tests.util.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

@DisplayName("Day 3: Binary Diagnostic")
@Execution(ExecutionMode.CONCURRENT)
class Day3Test {

    private static final List<String> example = InputParser.stringList("inputs/day3_example");
    private static final List<String> input = InputParser.stringList("inputs/day3");

    @Test
    @DisplayName("Part 1 - Example")
    void part1_example(TestInfo info) {
        AssertWrapper.equals(198, new BinaryDiagnostic1().solve(example), info);
    }

    @Test
    @DisplayName("Part 1")
    void part1(TestInfo info) {
        AssertWrapper.equals(2972336, new BinaryDiagnostic1().solve(input), info);
    }

    @Test
    @DisplayName("Part 2 - Example")
    void part2_example(TestInfo info) {
        AssertWrapper.equals(230, new BinaryDiagnostic2().solve(example), info);
    }

    @Test
    @DisplayName("Part 2")
    void part2(TestInfo info) {
        AssertWrapper.equals(3368358, new BinaryDiagnostic2().solve(input), info);
    }

}
