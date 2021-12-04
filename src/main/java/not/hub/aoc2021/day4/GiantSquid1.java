package not.hub.aoc2021.day4;

import not.hub.aoc2021.PuzzleException;
import not.hub.aoc2021.Solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiantSquid1 implements Solver<List<String>, Integer> {

    private static int sumUnmarked(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) {
            sum += Arrays.stream(row).filter(i -> i != -1).sum();
        }
        return sum;
    }

    private static boolean isWinner(int[][] grid) {
        int[][] gridRotated = rotate(grid);
        for (int i = 0; i < grid.length; i++) {
            if (Arrays.stream(grid[i]).sum() == -5) return true;
            if (Arrays.stream(gridRotated[i]).sum() == -5) return true;
        }
        return false;
    }

    private static void print(List<int[][]> grids) {
        for (int[][] grid : grids) {
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("---");
        }
    }

    static int[][] rotate(int[][] in) {
        final int m = in.length;
        final int n = in[0].length;
        int[][] out = new int[n][m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                out[c][m - 1 - r] = in[r][c];
            }
        }
        return out;
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
        print(grids);
        for (Integer l : lucky) {
            for (int[][] grid : grids) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == l) grid[i][j] = -1;
                    }
                }
                if (isWinner(grid)) return sumUnmarked(grid) * l;
            }
        }
        throw new PuzzleException("no solution");
    }

}
