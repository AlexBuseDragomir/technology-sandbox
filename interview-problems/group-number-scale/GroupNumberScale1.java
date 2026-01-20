package org.example.groupnumberscale;

import java.util.Objects;

/*
  You are given an integer array that contains both negative, zero and positive numbers.
  Group these in 3 groups, as they would appear on a number scale, so that negative ones
  are to the left, 0 in the center and positive ones to the right.
*/
public class GroupNumberScale1 {

  public static int[] groupNumbersOnScale(int[] numbers) {
    // If the array is null or empty return
    if (Objects.isNull(numbers)) {
      return new int[0];
    }

    int[] updatedNumbers = new int[numbers.length];

    // Return the new array, to be consistent
    if (numbers.length == 1) {
      updatedNumbers[0] = numbers[0];
      return updatedNumbers;
    }

    int startIndex = 0;
    int endIndex = numbers.length - 1;

    for (int number : numbers) {
      if (number < 0) {
        updatedNumbers[startIndex] = number;
        startIndex++;
      } else if (number > 0) {
        updatedNumbers[endIndex] = number;
        endIndex--;
      }
    }

    return updatedNumbers;
  }
}
