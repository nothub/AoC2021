package not.hub.aoc2021.tests;

import not.hub.aoc2021.day1.SonarSweep1;
import not.hub.aoc2021.tests.util.AssertWrapper;
import not.hub.aoc2021.tests.util.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

@DisplayName("Day 1: Sonar Sweep")
@Execution(ExecutionMode.CONCURRENT)
class Day1Test {

    private static final List<Integer> input = InputParser.integerList("inputs/day1");

    @Test
    @DisplayName("Part 1")
    void part1_input(TestInfo info) {
        AssertWrapper.equals(1342, new SonarSweep1().solve(input), info);
    }

}
