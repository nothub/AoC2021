package not.hub.aoc2021.day2;

import not.hub.aoc2021.PuzzleException;
import not.hub.aoc2021.Solver;

import java.util.List;

public class Dive2 implements Solver<List<String>, Integer> {

    @Override
    public Integer solve(List<String> input) {
        int x = 0;
        int y = 0;
        int aim = 0;
        for (String s : input) {
            String[] raw = s.split(" ");
            switch (raw[0]) {
                case "forward" -> {
                    x = x + Integer.parseInt(raw[1]);
                    y = y + (aim * Integer.parseInt(raw[1]));
                }
                case "down" -> aim = aim + Integer.parseInt(raw[1]);
                case "up" -> aim = aim - Integer.parseInt(raw[1]);
                default -> throw new PuzzleException("unknown direction");
            }
        }
        return x * y;
    }

}
