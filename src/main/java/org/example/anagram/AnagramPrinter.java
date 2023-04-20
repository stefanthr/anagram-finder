package org.example.anagram;

import com.google.common.collect.Multiset;
import java.util.List;
import java.util.Map;

public class AnagramPrinter {

  public void printAnagrams(Map<Multiset<Character>, List<String>> anagrams) {
    anagrams.values().stream()
        .map(word -> String.join(" ", word))
        .forEach(System.out::println);
  }

}
