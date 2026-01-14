package software.ulpgc.aoc.model;

public class SecurityDial {
    private int currentPosition;
    private static final int MAX_RANGE = 100;

    public SecurityDial(int startPosition) {
        this.currentPosition = startPosition;
    }

    /*
     * Mueve el dial hacia la derecha
     */
    public int turnClockwise(int steps) {
        int zeroCrossings = 0;
        for (int i = 0; i < steps; i++) {
            currentPosition = (currentPosition + 1) % MAX_RANGE;
            // Verificamos si en este paso pasamos por 0
            if (isReset()) zeroCrossings++;
        }
        return zeroCrossings;
    }

    /*
     * Mueve el dial hacia la izq
     */
    public int turnCounterClockwise(int steps) {
        int zeroCrossings = 0;
        for (int i = 0; i < steps; i++) {
            // Fórmula para módulo negativo seguro
            currentPosition = (currentPosition - 1 + MAX_RANGE) % MAX_RANGE;
            if (isReset()) zeroCrossings++;
        }
        return zeroCrossings;
    }

    // ¿Esta en 0?
    public boolean isReset() {
        return this.currentPosition == 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}