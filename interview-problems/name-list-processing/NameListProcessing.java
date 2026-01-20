package org.example.namelistprocessing;

import java.text.Collator;
import java.text.Normalizer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/*
  PROBLEM: Name List Processing
  Given the list: ["John", "Alice", "Bob", "Alice", "John", "David"]

  Tasks:
  1) Remove all duplicate names from the list.
  2) Sort the resulting list in alphabetical order.
  3) Calculate and print the frequency of each name from the original list.
*/
public class NameListProcessing {

  private static final Collator COLLATOR_US = Collator.getInstance(Locale.US);

  // Sorted by name
  public static Map<String, Long> computeNameFrequency1(List<String> names) {
    if (isNull(names)) {
      return Map.of();
    }

    return names.stream()
        .filter(NameListProcessing::isNotBlank)
        .map(NameListProcessing::normalizeString)
        // Using a TreeMap to keep the results sorted by the name
        .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
  }

  // Sorted by frequency
  public static Map<String, Long> computeNameFrequency2(List<String> names) {
    if (isNull(names)) {
      return Map.of();
    }

    return names.stream()
        .filter(NameListProcessing::isNotBlank)
        .map(NameListProcessing::normalizeString)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (oldValue, newValue) -> oldValue,
            LinkedHashMap::new
        ));
  }

  // Using streams, more efficient
  public static List<String> removeDuplicatesAndSort1(List<String> names) {
    if (isNull(names)) {
      return List.of();
    }

    return names.stream()
        .filter(NameListProcessing::isNotBlank)
        .map(NameListProcessing::normalizeString)
        .distinct()
        .sorted(COLLATOR_US)
        .toList();
  }

  // Using a tree set
  public static List<String> removeDuplicatesAndSort2(List<String> names) {
    if (isNull(names)) {
      return List.of();
    }

    final List<String> normalizedNames = names.stream()
        .filter(NameListProcessing::isNotBlank)
        .map(NameListProcessing::normalizeString)
        .toList();

    final Set<String> treeSet = new TreeSet<>(COLLATOR_US);
    treeSet.addAll(normalizedNames);

    return List.copyOf(treeSet);
  }

  private static boolean isNotBlank(String string) {
    return !isNullOrBlank(string);
  }

  private static boolean isNullOrBlank(String string) {
    return isNull(string) || string.isBlank();
  }

  private static String normalizeString(String string) {
    if (isNullOrBlank(string)) {
      return string;
    }

    final String normalizedString = Normalizer.normalize(string.strip(), Normalizer.Form.NFC);

    if (normalizedString.isEmpty()) {
      return string;
    }

    return normalizedString.substring(0, 1).toUpperCase(Locale.ROOT)
        + normalizedString.substring(1).toLowerCase(Locale.ROOT);
  }
}
