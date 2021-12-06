package not.hub.aoc2021.day6;

import not.hub.aoc2021.Solver;

public class Lanternfish2 implements Solver<String, Long> {

    @Override
    public Long solve(String input) {
        return Lanternfish1.solve(input, 256);
    }

}
