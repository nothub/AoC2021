package not.hub.aoc2021.day4;

import not.hub.aoc2021.PuzzleException;
import not.hub.aoc2021.Solver;

import java.util.*;
import java.util.stream.Collectors;

import static not.hub.aoc2021.day4.GiantSquid1.isWinner;

public class GiantSquid2 implements Solver<List<String>, Integer> {

    @Override
    public Integer solve(List<String> input) {
        List<Integer> lucky = Arrays.stream(input.get(0).split(",")).map(Integer::valueOf).collect(Collectors.toList());
        List<int[][]> grids = new ArrayList<>();
        input.remove(0);
        input.removeIf(String::isEmpty);
        for (int i = 0; i < input.size(); i = i + 5) {
            int[][] grid = new int[5][5];
            for (int j = 0; j < 5; j++) {
                grid[j] = Arrays.stream(input.get(i + j).split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
            }
            grids.add(grid);
        }
        int winner = -1;
        Set<Integer> winners = new HashSet<>();
        for (Integer l : lucky) {
            for (int k = 0; k < grids.size(); k++) {
                if (winners.contains(k)) continue;
                int[][] grid = grids.get(k);
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == l) grid[i][j] = -1;
                    }
                }
                if (isWinner(grid)) {
                    winners.add(k);
                    winner = Arrays.stream(grid).mapToInt(row -> Arrays.stream(row).filter(i -> i != -1).sum()).sum() * l;
                }
            }
        }
        if (winner == -1) throw new PuzzleException("no solution");
        return winner;
    }

}
