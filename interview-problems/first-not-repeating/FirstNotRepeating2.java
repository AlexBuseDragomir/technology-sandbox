package org.example.firstnotrepeating;

/*
  Given a string, write a method to find the first character that appears only once.
  Input: "swiss"  => Output: w
  Input: "hello"  => Output: h
  Input: "aabbcc" => Output: None

  We will assume there can be both lowercase and uppercase letters.
*/

import java.util.Objects;

public class FirstNotRepeating2 {

  public static Character findFirstNotRepeating(String inputString) {
    // Nothing to do if the input string is null or blank
    if (Objects.isNull(inputString) || inputString.isBlank()) {
      return null;
    }

    // If the string has only one character, return it
    if (inputString.length() == 1) {
      return inputString.charAt(0);
    }

    final int[] frequency = new int[26];

    // If strings are large, we can use chatAt() to be more efficient
    for (char character : inputString.toCharArray()) {
      frequency[getIndex(character)]++;
    }

    for (char character : inputString.toCharArray()) {
      if (frequency[getIndex(character)] == 1) {
        return character;
      }
    }

    return null;
  }

  private static int getIndex(char character) {
    return character < 'a' ? character - 'A' : character - 'a';
  }
}
