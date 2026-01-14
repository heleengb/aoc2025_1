package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.DialManager;
import software.ulpgc.aoc.io.TextFileReader;
import software.ulpgc.aoc.view.ConsoleResultPrinter;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("src", "main", "resources", "direcciones.txt");

        try {
            var rawData = new TextFileReader(path).readContent();

            long result = new DialManager().countFinalRestingZeros(rawData);

            new ConsoleResultPrinter().display("Parte 1: ", result);

        } catch (Exception e) {
            System.err.println("Fallo crítico: " + e.getMessage());
        }
    }
}