package not.hub.aoc2021.day6;

import not.hub.aoc2021.Solver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lanternfish1 implements Solver<String, Long> {

    static Long solve(String input, int days) {
        List<Integer> start = Arrays
            .stream(input.split(","))
            .mapToInt(Integer::valueOf)
            .boxed()
            .collect(Collectors.toList());
        Map<Integer, Long> fishies = new HashMap<>();
        for (Integer fish : start) {
            fishies.put(fish, fishies.getOrDefault(fish, 0L) + 1);
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
            tick(lastGen, nextGen, i, (i + 1) % 9);
        }
        return nextGen;
    }

    private static void tick(Map<Integer, Long> lastGen, Map<Integer, Long> nextGen, int currentDay, int lastDay) {
        nextGen.put(currentDay,
            currentDay == 6
                ? lastGen.getOrDefault(lastDay, 0L) + lastGen.getOrDefault(0, 0L)
                : lastGen.getOrDefault(lastDay, 0L)
        );
    }

    @Override
    public Long solve(String input) {
        return solve(input, 80);
    }

}
