package not.hub.aoc2021.day4;

import not.hub.aoc2021.PuzzleException;
import not.hub.aoc2021.Solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiantSquid1 implements Solver<List<String>, Integer> {

    static List<Integer> parseLucky(List<String> input) {
        return Arrays.stream(input.get(0).split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    static List<int[][]> parseGrids(List<String> input) {
        List<int[][]> grids = new ArrayList<>();
        for (int i = 0; i < input.size(); i = i + 5) {
            int[][] grid = new int[5][5];
            for (int j = 0; j < 5; j++) {
                grid[j] = Arrays.stream(input.get(i + j).split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
            }
            grids.add(grid);
        }
        return grids;
    }

    static boolean isWinner(int[][] grid) {
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
        List<Integer> lucky = parseLucky(input);
        input.remove(0);
        input.removeIf(String::isEmpty);
        List<int[][]> grids = parseGrids(input);
        for (Integer l : lucky) {
            for (int[][] grid : grids) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == l) grid[i][j] = -1;
                    }
                }
                if (isWinner(grid)) {
                    return Arrays.stream(grid).mapToInt(row -> Arrays.stream(row).filter(i -> i != -1).sum()).sum() * l;
                }
            }
        }
        throw new PuzzleException("no solution");
    }

}
