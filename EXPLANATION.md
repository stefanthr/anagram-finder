# Solution explanation

The project is built via Maven, so that all dependencies are managed and easily downloaded when the project is exported.

The implementation is split in three classes `WordReader`, `AnagramFinder`, `AnagramPrinter` which contain the logic for finding anagrams, an `Application` 
class, a main class where the anagram finder program is executed based on an input file `sample.txt` located in the `resources` folder.
The three classes are separated, to distinct the logic of each of them, so that each one has single responsibility. 

At program start the user is asked to enter the input file location in the console. I have used Scanner to parse the user input from the console.
A BufferedReader is faster and also possible here, but because the file path should not be that long, I decided to use a simpler approach and use BufferedReader
later when reading the file. I have stripped the user input from its leading and trailing whitespaces if the user includes by accident, but no whitespaces are 
permitted within the path, so an exception will be thrown because the file will not be found (later explained in
FileReader and BufferedReader). The file path is then passed to the getAnagramsForFile method where `WordReader`, `AnagramFinder`, `AnagramPrinter` objects
are created and used to perform operations in order to find anagrams. If the map of anagrams is not empty, the anagrams are printed using
the AnagramPrinter. If there are no anagrams, it is logged in the console with a corresponding info message. 

`WordReader` can read words from a file given the file path or from a list. I have decided to split the logic of readWords into these two methods, so that
it is easier to read, understand and maintain/test. An IOException is thrown and handled if the file is not found. I have used BufferedReader to read 
the file line by line since it is faster than Scanner which reads character by character. This is also crucial for further scaling of the application
if larger datasets are going to be used. I first filter the lines by removing all empty lines and trimming the leading and trailing whitespaces. I used stream 
for better performance. A parallel stream is also possible here if I want to use multiple threads. This would be a better alternative if I have a large dataset. If 
the filtered list of lines is not empty, each line is checked if it contains multiple words in it. If yes, a custom `InvalidInputException` is thrown and handled 
with corresponding message and the line. If the list is empty, an `InvalidInputException` is thrown and handled as well with the corresponding message. 
The list of filtered lines is returned, so that it can be searched for anagrams. 

`AnagramFinder` searches for anagrams using stream in the list of filtered lines which should contain one word in a line. The findAnagrams method expects a list of strings
(the filtered lines) and returns a map (no duplicate keys) - key, which contains the letters of the anagrams, value,  which is a list of the anagrams. The words (converted to 
lower case to support case insensitivity) are grouped by a key- a HashMultiSet from the guava library. MultiSet is a collection that supports order-independent equality with duplicate elements. 
For example, the multisets {a, a, b} and {a, b, a} are equal. This algorithm solves the problem in O(n) time without having to declare a big counting array. Rather than using a fixed-size table 
to count, the MutlitSet class simulates a variable-sized table, with a count for each character. This improves performance compared sorting the words using Arrays. After that all keys with no 
a list with no more than a single entry are filtered and the result is collected to a map with keys of type MultiSet and values of type List<String>, where the strings (anagrams) are sorted. 

`AnagramPrinter` prints all anagrams from different keys on separate line, each anagram separated by a whitespace. I have used a stream here as well for better
performance and readability. 

I have also written tests for `AnagramFinder` and `WordReader` using JUnit5. I have two tests to check findAnagrams `AnagramFinder` from a sample list where one test
contains a word in uppercase. I have used the Assertions class from JUnit for the tests. `WordReaderTest`tests reading words from a sample file which is located
in the `resources` folder in the `test` package. Reading words from a list is also tested, as well with leading and trailing whitespaces. 






