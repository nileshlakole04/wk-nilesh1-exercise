package exercise;

public class YatzyRefactored
{
    public static void main(String[] args)
    {
        GameSimulator simulator = new GameSimulator(new ConsoleOutput());
        simulator.simulateGame();
    }
}
