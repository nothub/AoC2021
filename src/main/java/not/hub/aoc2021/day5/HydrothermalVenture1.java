package not.hub.aoc2021.day5;

import not.hub.aoc2021.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HydrothermalVenture1 implements Solver<List<String>, Integer> {

    static final String seperator = " -> ";

    @Override
    public Integer solve(List<String> input) {
        int[][] grid = new int[1000][1000];
        for (String s : input) {
            String[] raw = s.split(seperator);
            String[] xRaw = raw[0].split(",");
            int x1 = Integer.parseInt(xRaw[0]);
            int y1 = Integer.parseInt(xRaw[1]);
            String[] yRaw = raw[1].split(",");
            int x2 = Integer.parseInt(yRaw[0]);
            int y2 = Integer.parseInt(yRaw[1]);
            if (x1 == x2) {
                IntStream.range(Math.min(y1, y2), Math.max(y2, y1) + 1).forEach(y -> grid[x1][y] += 1);
            } else if (y1 == y2) {
                IntStream.range(Math.min(x1, x2), Math.max(x2, x1) + 1).forEach(x -> grid[x][y1] += 1);
            }
        }
        return Arrays
            .stream(grid)
            .mapToInt(ints -> (int) Arrays
                .stream(ints)
                .filter(i -> i > 1)
                .count())
            .sum();
    }

}
