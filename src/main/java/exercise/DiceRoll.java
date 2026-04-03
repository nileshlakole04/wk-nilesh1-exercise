package exercise;
public record DiceRoll(int... dice)
{
    public DiceRoll
    {
        if (dice.length != 5) throw new IllegalArgumentException("Must roll 5 dice");
    }
}


