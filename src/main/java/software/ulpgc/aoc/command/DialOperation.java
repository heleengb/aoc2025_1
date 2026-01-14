package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.SecurityDial;

public interface DialOperation {
    // Manda a aplicar una transformacion al dial, este caso serán cruces por cero)
    int apply(SecurityDial dial);
}