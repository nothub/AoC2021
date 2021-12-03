package not.hub.aoc2021.day3;

import not.hub.aoc2021.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryDiagnostic1 implements Solver<List<String>, Integer> {

    private static int[] rotate(List<String> input) {
        int[] rotated = new int[input.get(0).length()];
        for (int i = 0; i < input.get(0).length(); i++) {
            for (String s : input) {
                rotated[i] += Integer.parseInt(s.substring(i, i + 1));
            }
        }
        return rotated;
    }

    private static int[] invert(int[] common) {
        int[] inverted = new int[common.length];
        for (int i = 0; i < common.length; i++) {
            if (common[i] == 1) inverted[i] = 0;
            else inverted[i] = 1;
        }
        return inverted;
    }

    private static int parse(int[] arr) {
        return Integer.parseInt(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()), 2);
    }

    @Override
    public Integer solve(List<String> input) {
        int[] rotated = rotate(input);
        int[] common = new int[input.get(0).length()];
        for (int i = 0; i < rotated.length; i++) {
            if (rotated[i] > input.size() / 2) common[i] = 1;
            else common[i] = 0;
        }
        return parse(common) * parse(invert(common));
    }

}
