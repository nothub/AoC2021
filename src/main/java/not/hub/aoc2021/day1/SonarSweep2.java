package not.hub.aoc2021.day1;

import not.hub.aoc2021.Solver;

import java.util.ArrayList;
import java.util.List;

public class SonarSweep2 extends Solver<List<Integer>, Integer> {

    @Override
    public Integer solve(List<Integer> input) {

        List<Integer> windows = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (i == input.size() - 2) break;
            windows.add(input.get(i) + input.get(i + 1) + input.get(i + 2));
        }

        return new SonarSweep1().solve(windows);

    }

}
