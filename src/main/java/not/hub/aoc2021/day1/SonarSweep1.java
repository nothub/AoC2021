package not.hub.aoc2021.day1;

import not.hub.aoc2021.Solver;

import java.util.List;
import java.util.stream.IntStream;

public class SonarSweep1 extends Solver<List<Integer>, Integer> {

    @Override
    public Integer solve(List<Integer> input) {
        return (int) IntStream
            .range(0, input.size())
            .takeWhile(i -> i < input.size() - 1)
            .filter(i -> input.get(i) < input.get(i + 1))
            .count();
    }

}
