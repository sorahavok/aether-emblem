package emblem.aether.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface FileParser<T> {
    default T readFile(File file) throws FileNotFoundException, IOException {
        try(final Scanner scanner = new Scanner(file, "UTF-8")) {
            scanner.useDelimiter(getDelimiter());
            return parseFile(scanner);
        }
    }

    T parseFile(Scanner scanner);
    String getDelimiter();
}
