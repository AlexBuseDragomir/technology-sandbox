package org.example.sortstrings;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/*
  Write a program to sort the list of strings: "Z1, Z5, A1, A2, A3, B1, B2, B3, C3, C1, C2".
  As "A1, B1, C1, Z1, A2, B2, C2, A3, B3, C3, Z5".
*/
public class SortStrings1 {

  public static void sortStrings(List<String> strings) {
    // Nothing to be done if the list of strings is null, empty, or it has only one element
    if (Objects.isNull(strings) || strings.size() < 2) {
      return;
    }

    final Comparator<String> comparator = (String first, String second) -> {
      if (first.charAt(1) != second.charAt(1)) {
        return Comparator.<Character>naturalOrder().compare(first.charAt(1), second.charAt(1));
      }
      return Comparator.<Character>naturalOrder().compare(first.charAt(0), second.charAt(0));
    };

    strings.sort(comparator);
  }
}
