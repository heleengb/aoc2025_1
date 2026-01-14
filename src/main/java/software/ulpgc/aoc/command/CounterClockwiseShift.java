package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.SecurityDial;

public record CounterClockwiseShift(int steps) implements DialOperation {
    @Override
    public int apply(SecurityDial dial) {
        return dial.turnCounterClockwise(steps);
    }
}