package org.example;

import com.google.common.collect.Multiset;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.anagram.AnagramFinder;
import org.example.anagram.AnagramPrinter;
import org.example.anagram.WordReader;

public class Application {

  private static final Logger logger = Logger.getLogger(Application.class.getName());

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter file location:");
    String filepath = scanner.nextLine().strip();
    findAnagramsFromFile(filepath);
  }

  private static void findAnagramsFromFile(String filePath) {
    WordReader wordReader = new WordReader();
    List<String> words = wordReader.readWordsFromFile(filePath);

    AnagramFinder anagramFinder = new AnagramFinder();
    Map<Multiset<Character>, List<String>> anagrams = anagramFinder.findAnagrams(words);

    if (!anagrams.isEmpty()) {
      AnagramPrinter anagramPrinter = new AnagramPrinter();
      anagramPrinter.printAnagrams(anagrams);
    } else {
      logger.log(Level.INFO, "No anagrams found");
    }
  }

}