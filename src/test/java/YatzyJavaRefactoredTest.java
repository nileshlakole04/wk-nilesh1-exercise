import exercise.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YatzyJavaRefactoredTest
{
    @Test
    void testChance() {
        int[] dice = {2, 3, 4, 5, 1};
        assertEquals(15, Category.CHANCE.score(dice));
        assertEquals(16, Category.CHANCE.score(new int[]{3, 3, 4, 5, 1}));
    }

    @Test
    void testYatzy() {
        int[] dice = {2, 2, 2, 2, 2};
        assertEquals(50, Category.YATZY.score(dice));
        assertEquals(50, Category.YATZY.score(new int[]{6, 6, 6, 6, 6}));
        int[] notYatzy = {2, 2, 2, 2, 3};
        assertEquals(0, Category.YATZY.score(notYatzy));
    }

    @Test
    void testOnes() {
        int[] dice = {1, 1, 2, 4, 4};
        assertEquals(2, Category.ONES.score(dice));
        assertEquals(0, Category.ONES.score(new int[]{6, 2, 2, 4, 5}));
        assertEquals(4, Category.ONES.score(new int[]{1, 2, 1, 1, 1}));
    }

    @Test
    void test2s() {
        assertEquals(10, Category.TWOS.score(new int[]{2, 2, 2, 2, 2}));
        assertEquals(4, Category.TWOS.score(new int[]{1, 2, 3, 2, 6}));
    }
    @Test
    public void test_threes() {
        assertEquals(6, Category.THREES.score(new int[]{1, 2, 3, 2, 3}));
        assertEquals(12, Category.THREES.score(new int[]{2, 3, 3, 3, 3}));
    }

    @Test
    public void fours_test() {
        assertEquals(12, Category.FOURS.score(new int[]{4, 4, 4, 5, 5}));
        assertEquals(8, Category.FOURS.score(new int[]{4, 4, 5, 5, 5}));
        assertEquals(4, Category.FOURS.score(new int[]{4, 5, 5, 5, 5}));
    }

    @Test
    public void fives() {
        assertEquals(10, Category.FIVES.score(new int[]{4, 4, 4, 5, 5}));
        assertEquals(15, Category.FIVES.score(new int[]{4, 4, 5, 5, 5}));
        assertEquals(20, Category.FIVES.score(new int[]{4, 5, 5, 5, 5}));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, Category.SIXES.score(new int[]{4, 4, 4, 5, 5}));
        assertEquals(6, Category.SIXES.score(new int[]{4, 4, 6, 5, 5}));
        assertEquals(18, Category.SIXES.score(new int[]{6, 5, 6, 6, 5}));
    }

    @Test
    void testOnePair() {
        int[] dice = {1, 1, 6, 2, 6};
        assertEquals(12, Category.PAIR.score(dice));
    }

    @Test
    void testTwoPairs() {
        int[] dice = {1, 1, 2, 3, 3};
        assertEquals(8, Category.TWO_PAIRS.score(dice));
    }

    @Test
    void testThreeOfAKind() {
        int[] dice = {3, 3, 3, 4, 5};
        assertEquals(9, Category.THREE_OF_A_KIND.score(dice));
    }

    @Test
    void testFourOfAKind() {
        int[] dice = {2, 2, 2, 2, 5};
        assertEquals(8, Category.FOUR_OF_A_KIND.score(dice));
    }

    @Test
    void testSmallStraight() {
        int[] dice = {1, 2, 3, 4, 5};
        assertEquals(15, Category.SMALL_STRAIGHT.score(dice));
    }

    @Test
    void testLargeStraight() {
        int[] dice = {2, 3, 4, 5, 6};
        assertEquals(20, Category.LARGE_STRAIGHT.score(dice));
    }

    @Test
    void testFullHouse() {
        int[] dice = {6, 2, 2, 2, 6};
        assertEquals(18, Category.FULL_HOUSE.score(dice));
        assertEquals(0, Category.FULL_HOUSE.score(new int[]{2, 3, 4, 5, 6}));
    }

}
