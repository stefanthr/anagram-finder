import java.util.Arrays;
import java.util.List;
import org.example.anagram.WordReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordReaderTest {

  private WordReader wordReader;

  @BeforeEach
  void init() {
    wordReader = new WordReader();
  }
  @Test
  void testReadWordsFromFile() {
    List<String> expected = Arrays.asList("hello", "olleh", "world", "hi", "there");
    List<String> actual = wordReader.readWordsFromFile("src/test/resources/test_sample.txt");
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void testReadWordsFromList() {
    List<String> words = Arrays.asList("hello", "olleh", "world", "hi", "there");
    List<String> expected = Arrays.asList("hello", "olleh", "world", "hi", "there");
    List<String> actual = wordReader.readWordsFromList(words);
    Assertions.assertEquals(expected, actual);
  }
  @Test
  void testReadWordsFromList_withLeadingWhitespaces() {
    List<String> words = Arrays.asList("hello", "  olleh", "world", "hi", "there");
    List<String> expected = Arrays.asList("hello", "olleh", "world", "hi", "there");
    List<String> actual = wordReader.readWordsFromList(words);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void testReadWordsFromList_withTrailingWhitespaces() {
    List<String> words = Arrays.asList("hello", "olleh   ", "world", "hi", "there");
    List<String> expected = Arrays.asList("hello", "olleh", "world", "hi", "there");
    List<String> actual = wordReader.readWordsFromList(words);
    Assertions.assertEquals(expected, actual);
  }

}
