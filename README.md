# Anagram Generator

## Overview
Anagram Generator is a Java-based application that generate all possible anagrams of a given input string. The project is structured with three primary classes:
- **App**: The main class to start the application and interact with the user.
- **AnagramGenerator**: Implements [Heap's Algorithm](https://en.wikipedia.org/wiki/Heap%27s_algorithm), a script consolidated in the literature, to generate all permutations (anagrams) of the given string.
- **StringUtils**: A utility class containing helper methods to handle strings.

The project includes unit tests to ensure the correctness of the implemented algorithms.

## Prerequisites
- **Java 17**: The project is built using Java 17.
- **Maven**: The project uses Maven as a build tool.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/mathunes/anagram-generator.git
    ```

2. Navigate to the project directory:
    ```bash
    cd anagram-generator
    ```

3. Install Maven dependencies:
    ```bash
    mvn install
    ```

## Building the Project

To compile and package the project into a JAR file, run the following Maven command:

```bash
mvn package
```

This will generate a `.jar` file in the `target/` directory.

## Running the Application

After compiling, you can run the application by providing an input string as a command-line argument. Use the following command:

```bash
java -jar target/java-mid-level-1.0-SNAPSHOT.jar <input>
```

Replace `<input>` with the string you want to generate anagrams for. For example:

```bash
java -jar target/java-mid-level-1.0-SNAPSHOT.jar ABC
```

This will generate all anagrams for the string "ABC".

## Unit Tests

The project includes unit tests to ensure the correctness of the anagram generation and string manipulation. To run the tests, use Maven's test goal:

```bash
mvn test
```

## Example

For the input string `ABC`, the application will generate and print all possible anagrams:

```
ABC, BAC, CAB, ACB, BCA, CBA
```