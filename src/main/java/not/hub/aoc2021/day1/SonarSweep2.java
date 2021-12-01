package not.hub.aoc2021.day1;

import not.hub.aoc2021.Solver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SonarSweep2 implements Solver<List<Integer>, Long> {

    @Override
    public Long solve(List<Integer> input) {
        return new SonarSweep1().solve(
            IntStream
                .range(0, input.size() - 2)
                .mapToObj(i -> input.get(i) + input.get(i + 1) + input.get(i + 2))
                .collect(Collectors.toList())
        );
    }

}
