import java.util.*;

public class Snake{

    static final int WIN = 100;
    static final Map<Integer, Integer> snakes = new HashMap<>();
    static final Map<Integer, Integer> ladders = new HashMap<>();

    static {
        // snakes: head -> tail
        snakes.put(99, 54);
        snakes.put(95, 75);
        snakes.put(92, 73);
        snakes.put(74, 53);
        snakes.put(64, 60);
        snakes.put(62, 19);
        snakes.put(49, 11);
        snakes.put(46, 25);
        snakes.put(16, 6);

        // ladders: bottom -> top
        ladders.put(2, 38);
        ladders.put(7, 14);
        ladders.put(8, 31);
        ladders.put(15, 26);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(78, 98);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n = 0;
        while (n < 2 || n > 4) {
            System.out.print("Number of players (2-4): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                sc.next();
            }
        }
        sc.nextLine(); // clear leftover newline

        int[] pos = new int[n];
        int turn = 0;

        System.out.println("\n=== SNAKE AND LADDER ===");
        System.out.println("Reach exactly square " + WIN + " to win. Roll a 6 for an extra turn!\n");

        while (true) {
            System.out.print("Player " + (turn + 1) + " (at " + pos[turn] + "), press Enter to roll...");
            sc.nextLine();

            int dice = rand.nextInt(6) + 1;
            System.out.println("  Rolled a " + dice);

            int next = pos[turn] + dice;

            if (next > WIN) {
                System.out.println("  Need an exact roll to reach " + WIN + ". Stay at " + pos[turn] + ".");
            } else {
                pos[turn] = next;

                if (snakes.containsKey(next)) {
                    pos[turn] = snakes.get(next);
                    System.out.println("  Snake! Slid down from " + next + " to " + pos[turn]);
                } else if (ladders.containsKey(next)) {
                    pos[turn] = ladders.get(next);
                    System.out.println("  Ladder! Climbed from " + next + " to " + pos[turn]);
                } else {
                    System.out.println("  Moved to " + pos[turn]);
                }
            }

            if (pos[turn] == WIN) {
                System.out.println("\n*** Player " + (turn + 1) + " wins! ***");
                break;
            }

            if (dice == 6) {
                System.out.println("  Six! Roll again.\n");
            } else {
                turn = (turn + 1) % n;
                System.out.println();
            }
        }

        sc.close();
    }
}
