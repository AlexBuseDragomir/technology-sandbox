package org.example.groupnumberscale;

import java.util.Objects;

/*
  You are given an integer array that contains both negative, zero and positive numbers.
  Group these in 3 groups, as they would appear on a number scale, so that negative ones
  are to the left, 0 in the center and positive ones to the right.
*/
public class GroupNumberScale2 {

  public static int[] groupNumbersOnScale(int[] numbers) {
    // If the array is null, empty, or it contains only one number, return
    if (Objects.isNull(numbers)) {
      return new int[0];
    }

    int startIndex = 0;
    int currentIndex = 0;
    int endIndex = numbers.length - 1;

    while (currentIndex <= endIndex) {
      final int currentNumber = numbers[currentIndex];

      if (currentNumber < 0) {
        swapNumbers(numbers, currentIndex, startIndex);
        startIndex++;
        currentIndex++;
        continue;
      }

      if (currentNumber == 0) {
        currentIndex++;
        continue;
      }

      swapNumbers(numbers, currentIndex, endIndex);
      endIndex--;
    }

    return numbers;
  }

  private static void swapNumbers(int[] numbers, int firstIndex, int secondIndex) {
    final int temp = numbers[secondIndex];
    numbers[secondIndex] = numbers[firstIndex];
    numbers[firstIndex] = temp;
  }
}
