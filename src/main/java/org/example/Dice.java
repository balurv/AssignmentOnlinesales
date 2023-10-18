package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public static Map<Integer, Integer> simulateDiceRoll(Map<Integer, Integer> outcomesProbabilities, int totalRolls) {
        // Validate that the probabilities sum up to 100
        int totalProbability = outcomesProbabilities.values().stream().mapToInt(Integer::intValue).sum();
        if (totalProbability != 100) {
            throw new IllegalArgumentException("Probabilities must sum up to 100");
        }


        // Create a list of outcomes based on probabilities
        List<Integer> possibleOutcomes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : outcomesProbabilities.entrySet()) {
            int probability = entry.getValue();
            for (int i = 0; i < probability; i++) {
                possibleOutcomes.add(entry.getKey());
            }
        }
        System.out.println(possibleOutcomes);
        // Simulate the dice rolls and count the occurrences of each outcome
        Map<Integer, Integer> outcomeCounts = new HashMap<>();
        for (int i = 0; i < totalRolls; i++) {
            //Generate a random integer within the range
            //[0, possibleOutcomes.size() -1
            int randomIndex = ThreadLocalRandom.current().nextInt(possibleOutcomes.size());
            int outcome = possibleOutcomes.get(randomIndex);
            outcomeCounts.put(outcome, outcomeCounts.getOrDefault(outcome, 0) + 1);
        }


        return outcomeCounts;
    }
}


