package org.example.anagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.example.exception.InvalidInputException;

public class WordReader {

  private static final Logger logger = Logger.getLogger(WordReader.class.getName());

  public List<String> readWordsFromFile(String filePath) {
    List<String> words = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      words = readWordsFromList(reader.lines().toList());
    } catch (IOException exception) {
      logger.log(Level.WARNING, "Error reading file", exception);
    }
    return words;
  }

  public List<String> readWordsFromList(List<String> lines) {
    List<String> filteredLines = lines.stream().filter(line -> !line.trim().isEmpty())
        .map(String::trim)
        .collect(Collectors.toList());

    try {
      if (!filteredLines.isEmpty()) {
        checkForMultipleWordsOnOneLine(filteredLines);
      } else {
        throw new InvalidInputException("The input file is empty");
      }
    } catch (InvalidInputException exception) {
      logger.log(Level.WARNING, exception.getMessage(), exception);
    }

    return filteredLines;
  }

  private void checkForMultipleWordsOnOneLine(List<String> lines)
      throws InvalidInputException {
    for (String line : lines) {
      if (line.split("\\s+").length > 1) {
        throw new InvalidInputException("Each word should be written on a separate line: " + line);
      }
    }
  }

}
