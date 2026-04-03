package exercise;

import exercise.in.OutputStrategy;

import java.util.Random;

public class GameSimulator
{
    private final Random random = new Random();
    private final OutputStrategy output;

    public GameSimulator(OutputStrategy output)
    {
        this.output = output;
    }

    public DiceRoll rollDice()
    {
        return new DiceRoll(
                random.nextInt(6) + 1,
                random.nextInt(6) + 1,
                random.nextInt(6) + 1,
                random.nextInt(6) + 1,
                random.nextInt(6) + 1
        );
    }

    public void simulateGame()
    {
        for (int i = 1; i <= 3; i++) {
            DiceRoll roll = rollDice();
            Category chosen = chooseCategory(roll);
            int score = chosen.score(roll.dice());

            output.print(i + ". ROLL");
            output.print("Dice: " + roll);
            output.print("You've chosen " + chosen + " as score category");
            output.print("Score: " + score);
            output.print("You've got " + (score > 0 ? chosen : "NOTHING"));
            output.print("");
        }
    }

    private Category chooseCategory(DiceRoll roll)
    {
        for (Category c : Category.values())
        {
            if (c.score(roll.dice()) > 0) return c;
        }
        return Category.CHANCE;
    }
}
