package not.hub.aoc2021.day5;

import not.hub.aoc2021.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HydrothermalVenture1 implements Solver<List<String>, Integer> {

    static final String seperator = " -> ";

    @Override
    public Integer solve(List<String> input) {
        for (String s : input) {
            String[] raw = s.split(seperator);
            int x1 = Integer.parseInt(raw[0].split(",")[0]);
            int y1 =  Integer.parseInt(raw[0].split(",")[1]);
            int x2 =  Integer.parseInt(raw[1].split(",")[0]);
            int y2 =  Integer.parseInt(raw[1].split(",")[1]);
            IntStream range = IntStream.range(Math.min(x1, y1), Math.max(x2, y2));
            System.out.println(Arrays.toString(range.toArray()));
            // ???
        }
        return 0;
    }

}
