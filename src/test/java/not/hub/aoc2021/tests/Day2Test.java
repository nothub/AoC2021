package not.hub.aoc2021.tests;

import not.hub.aoc2021.day2.Dive1;
import not.hub.aoc2021.day2.Dive2;
import not.hub.aoc2021.tests.util.AssertWrapper;
import not.hub.aoc2021.tests.util.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

@DisplayName("Day 2: Dive!")
@Execution(ExecutionMode.CONCURRENT)
class Day2Test {

    private static final List<String> input = InputParser.stringList("inputs/day2");

    @Test
    @DisplayName("Part 1")
    void part1(TestInfo info) {
        AssertWrapper.equals(1604850, new Dive1().solve(input), info);
    }

    @Test
    @DisplayName("Part 2")
    void part2(TestInfo info) {
        AssertWrapper.equals(1685186100, new Dive2().solve(input), info);
    }

}
