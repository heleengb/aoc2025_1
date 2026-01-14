package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.*;
import software.ulpgc.aoc.model.SecurityDial;

import java.util.List;

public class DialManager {

    // Factory method pra convertir texto en comandos
    private DialOperation parseCommand(String instruction) {
        char type = instruction.charAt(0);
        int value = Integer.parseInt(instruction.substring(1));

        return (type == 'R')
                ? new ClockwiseShift(value)
                : new CounterClockwiseShift(value);
    }

    /*
     * Parte 1: cuántas veces termina el dial en 0.
     */
    public long countFinalRestingZeros(List<String> instructions) {
        SecurityDial dial = new SecurityDial(50); // Comienza en 50

        return instructions.stream()
                .map(this::parseCommand)
                .filter(op -> {
                    op.apply(dial);       // Ejecutamos el movimiento
                    return dial.isReset(); // Comprobamos si al final quedo en 0
                })
                .count();
    }

    /*
     * Parte 2: cuántas veces pasa el dial por 0.
     */
    public long calculateTotalZeroPasses(List<String> instructions) {
        SecurityDial dial = new SecurityDial(50);

        return instructions.stream()
                .map(this::parseCommand)
                .mapToInt(op -> op.apply(dial)) // apply devuelve cuantas veces paso por 0 en ese movimiento
                .sum();
    }
}