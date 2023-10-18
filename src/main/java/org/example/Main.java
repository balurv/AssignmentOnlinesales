package org.example;




import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        //Accept input of dice possibilities
        Map<Integer, Integer> diceRoll = new HashMap<>();
        diceRoll.put(1, 8);
        diceRoll.put(2, 30);
        diceRoll.put(3, 15);
        diceRoll.put(4, 15);
        diceRoll.put(5, 30);
        diceRoll.put(6, 2);


        // Number of dice rolls
        int totalRolls = 1000;


        // Simulate the dice rolls and count the occurrences of each outcome
        Map<Integer, Integer> outcomeCounts = Dice.simulateDiceRoll(diceRoll, totalRolls);


        // Print the results
        System.out.println("Simulation results for biased dice roll:");
        for (int i = 1; i <= 6; i++) {
            int count = outcomeCounts.getOrDefault(i, 0);
            System.out.println("Outcome " + i + " appeared " + count + " times.");
        }
    }
}
