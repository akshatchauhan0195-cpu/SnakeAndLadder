# Snake and Ladder (Java, Terminal)

A classic Snake and Ladder game for 2 to 4 players, written in plain Java and played entirely in the terminal.

## Rules

- The board has 100 squares. Every player starts at 0 and moves up toward square 100.
- On your turn, roll a die (1 to 6) and move forward that many squares.
- Land on the bottom of a **ladder** and you climb to its top.
- Land on the head of a **snake** and you slide down to its tail.
- Rolling a **6** gives you an extra turn.
- You must reach **exactly 100** to win. If your roll would take you past 100, you stay where you are.

## Snakes and ladders

| Snakes (head → tail) | Ladders (bottom → top) |
|----------------------|------------------------|
| 99 → 54              | 2 → 38                 |
| 95 → 75              | 7 → 14                 |
| 92 → 73              | 8 → 31                 |
| 74 → 53              | 15 → 26                |
| 64 → 60              | 21 → 42                |
| 62 → 19              | 28 → 84                |
| 49 → 11              | 36 → 44                |
| 46 → 25              | 51 → 67                |
| 16 → 6               | 71 → 91                |
|                      | 78 → 98                |

## Requirements

- JDK 17 or newer (developed with Java 21)

## Run

```bash
javac SnakeAndLadder.java
java SnakeAndLadder
```

You can also run the source file directly:

```bash
java SnakeAndLadder.java
```

The class name must match the file name. If you rename the file (for example to `Snake.java`), rename the class inside it to match.

## How to play

1. Enter the number of players (2 to 4).
2. On each turn, press **Enter** to roll the dice.
3. The game prints where you moved and whether you hit a snake or a ladder.
4. The first player to land exactly on 100 wins.

Example output:

```
Player 1 (at 0), press Enter to roll...
  Rolled a 2
  Ladder! Climbed from 2 to 38
```

## Customizing the board

Edit the `static` block at the top of `SnakeAndLadder.java`:

```java
snakes.put(99, 54);   // head, tail
ladders.put(2, 38);   // bottom, top
```

Keep every snake head and ladder bottom on its own square, and don't put one on square 100.

## Project structure

```
.
├── SnakeAndLadder.java
└── README.md
```

## Ideas for improvement

- Print the board as a grid in the terminal after every turn
- Add a computer-controlled player
- Let players enter their own names
- Add a graphical version (for example with Java Swing)
