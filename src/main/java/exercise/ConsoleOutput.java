package exercise;

import exercise.in.OutputStrategy;

public class ConsoleOutput implements OutputStrategy
{
    public void print(String message) {
        System.out.println(message);
    }
}
