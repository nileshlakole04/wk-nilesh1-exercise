package exercise;

import java.util.Arrays;
import java.util.function.Function;

// Enum for categories with scoring logic
public enum Category
{
    CHANCE(dice -> Arrays.stream(dice).sum()),
    YATZY(dice -> Arrays.stream(dice).distinct().count() == 1 ? 50 : 0),
    ONES(dice -> sumOfNumber(1, dice)),
    TWOS(dice -> sumOfNumber(2, dice)),
    THREES(dice -> sumOfNumber(3, dice)),
    FOURS(dice -> sumOfNumber(4, dice)),
    FIVES(dice -> sumOfNumber(5, dice)),
    SIXES(dice -> sumOfNumber(6, dice)),
    PAIR(Category::scorePair),
    TWO_PAIRS(Category::scoreTwoPairs),
    THREE_OF_A_KIND(dice -> scoreOfAKind(dice, 3)),
    FOUR_OF_A_KIND(dice -> scoreOfAKind(dice, 4)),
    SMALL_STRAIGHT(dice -> isStraight(dice, new int[]{1,2,3,4,5}) ? 15 : 0),
    LARGE_STRAIGHT(dice -> isStraight(dice, new int[]{2,3,4,5,6}) ? 20 : 0),
    FULL_HOUSE(Category::scoreFullHouse);

    private final Function<int[], Integer> scorer;

    Category(Function<int[], Integer> scorer)
    {
        this.scorer = scorer;
    }

    public int score(int[] dice)
    {
        return scorer.apply(dice);
    }

    // Helpers
    private static int sumOfNumber(int number, int[] dice)
    {
        return Arrays.stream(dice).filter(d -> d == number).sum();
    }

    private static int scorePair(int[] dice)
    {
        int[] counts = countDice(dice);
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) return (i + 1) * 2;
        }
        return 0;
    }

    private static int scoreTwoPairs(int[] dice)
    {
        int[] counts = countDice(dice);
        int pairs = 0, score = 0;
        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairs++;
                score += (i + 1) * 2;
            }
        }
        return pairs == 2 ? score : 0;
    }

    private static int scoreOfAKind(int[] dice, int n)
    {
        int[] counts = countDice(dice);
        for (int i = 0; i < 6; i++) {
            if (counts[i] >= n) return (i + 1) * n;
        }
        return 0;
    }

    private static boolean isStraight(int[] dice, int[] target)
    {
        return Arrays.equals(Arrays.stream(dice).sorted().toArray(), target);
    }

    private static int scoreFullHouse(int[] dice)
    {
        int[] counts = countDice(dice);
        int two = 0, three = 0;
        for (int i = 0; i < 6; i++)
        {
            if (counts[i] == 2) two = (i + 1) * 2;
            if (counts[i] == 3) three = (i + 1) * 3;
        }
        return (two > 0 && three > 0) ? two + three : 0;
    }

    private static int[] countDice(int[] dice)
    {
        int[] counts = new int[6];
        for (int d : dice) counts[d - 1]++;
        return counts;
    }
}
