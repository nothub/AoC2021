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
            var command = s.split(" ");
            var direction = command[0];
            var value = Integer.parseInt(command[1]);
            switch (direction) {
                case "forward" -> {
                    x += value;
                    y += (aim * value);
                }
                case "down" -> aim += value;
                case "up" -> aim -= value;
                default -> throw new PuzzleException("unknown direction");
            }
        }
        return x * y;
    }

}
