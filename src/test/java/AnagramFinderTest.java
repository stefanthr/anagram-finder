import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.example.anagram.AnagramFinder;
import org.example.anagram.WordReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnagramFinderTest {

  private AnagramFinder anagramFinder;

  @BeforeEach
  void init() {
    anagramFinder = new AnagramFinder();
  }

  @Test
  void testFindAnagrams() {
    List<String> words = Arrays.asList("act", "cat", "tac", "dog", "god", "car", "rac");
    Map<Multiset<Character>, List<String>> anagrams = anagramFinder.findAnagrams(words);

    Assertions.assertEquals(3, anagrams.size());
    Assertions.assertEquals(Arrays.asList("act", "cat", "tac"),
        anagrams.get(HashMultiset.create(Arrays.asList('a', 'c', 't'))));
    Assertions.assertEquals(Arrays.asList("dog", "god"),
        anagrams.get(HashMultiset.create(Arrays.asList('d', 'g', 'o'))));
    Assertions.assertEquals(Arrays.asList("car", "rac"),
        anagrams.get(HashMultiset.create(Arrays.asList('a', 'c', 'r'))));
  }

  @Test
  void testFindAnagrams_withUpperCase() {
    List<String> words = Arrays.asList("act", "CAT", "tac", "dog", "god", "car", "rac");
    Map<Multiset<Character>, List<String>> anagrams = anagramFinder.findAnagrams(words);

    Assertions.assertEquals(3, anagrams.size());
    Assertions.assertEquals(Arrays.asList("CAT", "act", "tac"),
        anagrams.get(HashMultiset.create(Arrays.asList('a', 'c', 't'))));
    Assertions.assertEquals(Arrays.asList("dog", "god"),
        anagrams.get(HashMultiset.create(Arrays.asList('d', 'g', 'o'))));
    Assertions.assertEquals(Arrays.asList("car", "rac"),
        anagrams.get(HashMultiset.create(Arrays.asList('a', 'c', 'r'))));
  }

}
