package not.hub.aoc2021.day1;

import not.hub.aoc2021.Solver;

import java.util.List;

public class SonarSweep1 extends Solver<List<Integer>, Integer> {

    @Override
    public Integer solve(List<Integer> input) {

        int increases = 0;
        for (int i = 0; i < input.size(); i++) {
            if (i == input.size() - 1) break;
            if (input.get(i) < input.get(i + 1)) increases++;
        }

        return increases;

    }

}
