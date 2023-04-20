# Anagram finder application

Two words are defined as an anagram if they do share the same letters, but are in a different 
order (e.g. the English words race and care are an anagram).

This is an application which finds all anagrams given an input file which contains one word 
per line. The output is printed in the console and consists of lists of all anagrams from the
input file, each on a separate line.

## Requirements

To run this application, you need to have the following installed on your machine:

- Java 17
- Maven
- IDE of your choice

## Build project and run the application

To build and  the application, follow these steps:

1. Unzip the project and open it in your IDE of choice as Maven project.
2. Run `mvn clean install` to build the project.
3. Run the application from the AnagramFinder class.
4. You will be asked to enter the input file location in the console. Enter either relative or absolute path. 
   - There is a `sample.txt` file in the `resources` folder in the `main` package with sample input. 
5. The result is printed in the console.
6. Tests are available in the test package. 
