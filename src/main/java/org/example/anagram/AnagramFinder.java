package org.example.anagram;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramFinder {

  public Map<Multiset<Character>, List<String>> findAnagrams(List<String> words) {
    return words.stream()
        .collect(Collectors.groupingBy(word ->
                HashMultiset.create(
                    word.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList())),
            Collectors.toList()))
        .entrySet().stream()
        .filter(entry -> entry.getValue().size() > 1)
        .collect(Collectors.toMap(Map.Entry::getKey,
            entry -> entry.getValue().stream().sorted().collect(Collectors.toList())));
  }

}
