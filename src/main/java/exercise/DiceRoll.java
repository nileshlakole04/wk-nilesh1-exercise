package exercise;
public record DiceRoll(int... dice)
{
    public DiceRoll(int... dice)
    {
        if (dice.length != 5) throw new IllegalArgumentException("Must roll 5 dice");
        this.dice = dice;
    }
}


