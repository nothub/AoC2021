package not.hub.aoc2021.tests;

import not.hub.aoc2021.day3.BinaryDiagnostic1;
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

    private static final List<String> input = InputParser.stringList("inputs/day3");

    @Test
    @DisplayName("Part 1")
    void part1(TestInfo info) {
        AssertWrapper.equals(2972336, new BinaryDiagnostic1().solve(input), info);
    }

}
