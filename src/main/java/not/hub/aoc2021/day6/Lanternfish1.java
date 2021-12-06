package not.hub.aoc2021.day6;

import not.hub.aoc2021.Solver;

import java.util.Arrays;

public class Lanternfish1 implements Solver<String, Long> {

    static Long solve(String input, int days) {
        long[] fishies = new long[9];
        for (String s : input.split(",")) {
            int i = Integer.parseInt(s);
            fishies[i] = fishies[i] + 1;
        }
        while (days > 0) {
            fishies = evolve(fishies);
            days--;
        }
        return Arrays.stream(fishies).sum();
    }

    private static long[] evolve(long[] lastGen) {
        long[] nextGen = new long[9];
        for (int i = 0; i <= 8; i++) {
            long v = lastGen[(i + 1) % 9];
            if (i == 6) v += lastGen[0];
            nextGen[i] = v;
        }
        return nextGen;
    }

    @Override
    public Long solve(String input) {
        return solve(input, 80);
    }

}
