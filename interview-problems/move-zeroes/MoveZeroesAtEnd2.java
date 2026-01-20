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

// This preserves the relative order
public class MoveZeroesAtEnd2 {

  public static void moveZeroes(List<Integer> numbers) {
    // No need to perform any action if the list is null, empty, or it contains only one element
    if (Objects.isNull(numbers) || numbers.size() < 2) {
      return;
    }

    int indexOfZero = -1;

    for (int i = 0; i < numbers.size(); i++) {
      // 0 case
      if (numbers.get(i) == 0) {
        if (indexOfZero == -1) {
          indexOfZero = i;
        }
        continue;
      }

      // Not 0 case (works for positive and negative as well)
      if (indexOfZero != -1) {
        numbers.set(indexOfZero, numbers.get(i));
        numbers.set(i, 0);

        if (indexOfZero < i) {
          indexOfZero++;
        }
      }
    }
  }
}
