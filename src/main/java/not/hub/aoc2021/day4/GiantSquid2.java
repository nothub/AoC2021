package not.hub.aoc2021.day4;

import not.hub.aoc2021.PuzzleException;
import not.hub.aoc2021.Solver;

import java.util.*;
import java.util.stream.Collectors;

public class GiantSquid2 implements Solver<List<String>, Integer> {

    private static boolean isWinner(int[][] grid) {
        int[][] gridRotated = rotate(grid);
        for (int i = 0; i < grid.length; i++) {
            if (Arrays.stream(grid[i]).sum() == -5) return true;
            if (Arrays.stream(gridRotated[i]).sum() == -5) return true;
        }
        return false;
    }

    private static int[][] rotate(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][] gridRotated = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gridRotated[j][m - 1 - i] = grid[i][j];
            }
        }
        return gridRotated;
    }

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
