package not.hub.aoc2021.day6;

import not.hub.aoc2021.Solver;

import java.util.HashMap;
import java.util.Map;

public class Lanternfish1 implements Solver<String, Long> {

    static Long solve(String input, int days) {
        Map<Integer, Long> fishies = new HashMap<>();
        for (String s : input.split(",")) {
            int i = Integer.parseInt(s);
            fishies.put(i, fishies.getOrDefault(i, 0L) + 1);
        }
        while (days > 0) {
            fishies = evolve(fishies);
            days--;
        }
        return fishies.values().stream().mapToLong(Long::valueOf).sum();
    }

    private static Map<Integer, Long> evolve(Map<Integer, Long> lastGen) {
        Map<Integer, Long> nextGen = new HashMap<>();
        for (int i = 0; i <= 8; i++) {
            long v = lastGen.getOrDefault((i + 1) % 9, 0L);
            if (i == 6) v += lastGen.getOrDefault(0, 0L);
            nextGen.put(i, v);
        }
        return nextGen;
    }

    @Override
    public Long solve(String input) {
        return solve(input, 80);
    }

}
