package not.hub.aoc2021.day3;

import not.hub.aoc2021.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryDiagnostic1 implements Solver<List<String>, Integer> {

    @Override
    public Integer solve(List<String> input) {
        int wordLength = input.get(0).length();
        int[] rotated = new int[wordLength];
        for (int i = 0; i < wordLength; i++) {
            for (String s : input) {
                rotated[i] += Integer.parseInt(s.substring(i, i + 1));
            }
        }
        int[] common = new int[wordLength];
        for (int i = 0; i < rotated.length; i++) {
            if (rotated[i] > input.size() / 2) common[i] = 1;
            else common[i] = 0;
        }
        int gamma = Integer.parseInt(Arrays.stream(common).mapToObj(i -> "" + i).collect(Collectors.joining()), 2);
        int[] inverted = new int[wordLength];
        for (int i = 0; i < common.length; i++) {
            if (common[i] == 1) inverted[i] = 0;
            else inverted[i] = 1;
        }
        int epsilon = Integer.parseInt(Arrays.stream(inverted).mapToObj(i -> "" + i).collect(Collectors.joining()), 2);
        return gamma * epsilon;
    }

}
