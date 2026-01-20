package org.example.firstnotrepeating;

/*
  Given a string, write a method to find the first character that appears only once.
  Input: "swiss"  => Output: w
  Input: "hello"  => Output: h
  Input: "aabbcc" => Output: None

  We will assume there are only lowercase letters.
*/

import java.util.Objects;

public class FirstNotRepeating1 {

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

    for (char character : inputString.toCharArray()) {
      frequency[character - 'a']++;
    }

    for (char character : inputString.toCharArray()) {
      if (frequency[character - 'a'] == 1) {
        return character;
      }
    }

    return null;
  }
}
