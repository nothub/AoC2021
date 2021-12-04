package not.hub.aoc2021.day4;

import not.hub.aoc2021.Solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiantSquid1 implements Solver<List<String>, Integer> {

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
        return 0;
    }

    private void print(List<int[][]> grids) {
        for (int[][] grid : grids) {
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("---");
        }
    }

}
