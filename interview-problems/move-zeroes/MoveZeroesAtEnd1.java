package org.example.movezeroes;

import java.util.List;
import java.util.Objects;

/*
  Write a function that moves all zeroes in a given array to the end while maintaining the order of the non-zero elements.

  moveZeroes([0, 1, 0, 3, 12])
  Output: [1, 3, 12, 0, 0]

  moveZeroes([0, 0, 0, 1, 2, 0])
  Output: [1, 2, 0, 0, 0, 0]

  moveZeroes([1, 2, 3])
  Output: [1, 2, 3]
*/

// This does not preserve the relative order
public class MoveZeroesAtEnd1 {

  public static void moveZeroes(List<Integer> numbers) {
    // No need to perform any action if the list is null, empty, or it contains only one element
    if (Objects.isNull(numbers) || numbers.size() < 2) {
      return;
    }

    int startIndex = 0;
    int endIndex = numbers.size() - 1;

    while (startIndex < endIndex) {
      if (numbers.get(startIndex) == 0) {
        if (numbers.get(endIndex) != 0) {
          swapNumbers(numbers, startIndex, endIndex);
        } else {
          endIndex --;
        }
      } else {
        startIndex++;
      }
    }
  }

  private static void swapNumbers(List<Integer> numbers, int firstIndex, int secondIndex) {
    final int temp = numbers.get(secondIndex);
    numbers.set(secondIndex, numbers.get(firstIndex));
    numbers.set(firstIndex, temp);
  }
}
