package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Game {
    public void startGame() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter the size of the board");
            int boardSize = sc.nextInt();
            if (boardSize <= 1) {
                System.out.println("Board size must be greater than 1. Restart the game setup.");
                return;
            }

            System.out.println("Enter the size of the dice");
            int diceSize = sc.nextInt();
            if (diceSize <= 1) {
                System.out.println("Dice size must be greater than 1. Restart the game setup.");
                return;
            }

            System.out.println("Enter total number of players");
            int totalPlayers = sc.nextInt();
            sc.nextLine(); 
            if (totalPlayers < 2) {
                System.out.println("At least two players are required to start the game.");
                return;
            }

            List<Player> players = new ArrayList<>();
            for (int i = 1; i <= totalPlayers; i++) {
                System.out.println("Enter the name of Player " + i);
                String name = sc.nextLine();
                players.add(new Player(i, name));
            }

            System.out.println("Enter total number of ladders");
            int totalLadders = sc.nextInt();
            Map<Integer, Integer> ladders = new HashMap<>();
            for (int i = 1; i <= totalLadders; i++) {
                System.out.println("Enter the start and end point of the Ladder " + i);
                int start = sc.nextInt();
                int end = sc.nextInt();
                if (checkLadder(start, end, boardSize) && isValidPosition(start, end, ladders, ladders)) {
                    ladders.put(start, end);
                } else {
                    System.out.println("Enter valid and non-conflicting start and end points for the Ladder " + i);
                    i--;
                }
            }

            System.out.println("Enter total number of snakes");
            int totalSnakes = sc.nextInt();
            Map<Integer, Integer> snakes = new HashMap<>();
            for (int i = 1; i <= totalSnakes; i++) {
                System.out.println("Enter the start and end point of the Snake " + i);
                int start = sc.nextInt();
                int end = sc.nextInt();
                if (checkSnake(start, end, boardSize) && isValidPosition(start, end, snakes, ladders)) {
                    snakes.put(start, end);
                } else {
                    System.out.println("Enter valid and non-conflicting start and end points for the Snake " + i);
                    i--;
                }
            }

            Board board = new Board(boardSize, diceSize, players, snakes, ladders);
            board.play();
        }
    }

    public boolean checkLadder(int start, int end, int boardSize) {
        return (start > 0 && end > 0 && start <= boardSize && end <= boardSize && start < end);
    }

    public boolean checkSnake(int start, int end, int boardSize) {
        return (start > 0 && end > 0 && start <= boardSize && end <= boardSize && start > end);
    }

    public boolean isValidPosition(int start, int end, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        return !(snakes.containsKey(start) || ladders.containsKey(start) || snakes.containsValue(start) || ladders.containsValue(start)
              || snakes.containsKey(end) || ladders.containsKey(end) || snakes.containsValue(end) || ladders.containsValue(end));
    }
}
