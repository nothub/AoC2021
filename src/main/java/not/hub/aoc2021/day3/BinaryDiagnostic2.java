package not.hub.aoc2021.day3;

import not.hub.aoc2021.Solver;

import java.util.ArrayList;
import java.util.List;

public class BinaryDiagnostic2 implements Solver<List<String>, Integer> {

    private static int criteria(List<String> input, int index, boolean most) {
        var o = 0;
        var z = 0;
        for (var line : input) {
            if (line.charAt(index) == '1') o++;
            else z++;
        }
        if (most) return (o >= z ? 1 : 0);
        else return (z <= o ? 0 : 1);
    }

    private static ArrayList<String> reduce(List<String> input, boolean most) {
        var output = new ArrayList<>(input);
        for (var i = 0; i < input.get(0).length(); i++) {
            final var fi = i;
            output.removeIf(s -> s.charAt(fi) != Character.forDigit(criteria(output, fi, most), 10));
            if (output.size() == 1) break;
        }
        return output;
    }

    @Override
    public Integer solve(List<String> input) {
        var o2 = reduce(input, true);
        var co2 = reduce(input, false);
        return Integer.parseInt(o2.get(0), 2) * Integer.parseInt(co2.get(0), 2);
    }

}
