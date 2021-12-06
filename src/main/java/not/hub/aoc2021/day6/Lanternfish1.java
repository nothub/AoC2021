package not.hub.aoc2021.day6;

import not.hub.aoc2021.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lanternfish1 implements Solver<String, Integer> {

    @Override
    public Integer solve(String input) {
        List<Integer> fishies = Arrays.stream(input.split(",")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        int days = 80;
        while (days > 0) {
            int newFish = 0;
            for (int i = 0; i < fishies.size(); i++) {
                if (fishies.get(i) == 0) {
                    fishies.set(i, 6);
                    newFish++;
                } else fishies.set(i, fishies.get(i) - 1);
            }
            for (int i = 0; i < newFish; i++) {
                fishies.add(8);
            }
            days--;
        }
        return fishies.size();
    }

}
