package org.example.namebasedemails;

import java.text.Normalizer;
import java.util.Objects;

/*
  Design an algorithm to generate unique, consistent, and professional emails or IDs based
  on "First Name" and "Last Name" inputs. The system must handle edge cases where the input
  data is incomplete. Specifically, define the logic for constructing a valid identifier when
  either the first name or the last name is missing.
*/
public class NameBasedEmailGenerator1 {

  private static final String MAIL_DELIMITER = ".";
  private static final String MAIL_DOMAIN = "@gmail.com";
  private static final String NON_ALPHA_REGEX = "[^a-z]";

  public static String generateEmailBasedOnName(String firstName, String lastName) {
    if (isNullOrBlank(firstName) && isNullOrBlank(lastName)) {
      throw new IllegalArgumentException("Please provide at least a first or last name");
    }

    final String normalizedFirstName = normalizeName(firstName);
    final String normalizedLastName = normalizeName(lastName);

    if (normalizedFirstName.isBlank()) {
      return normalizedLastName + MAIL_DOMAIN;
    }

    if (normalizedLastName.isBlank()) {
      return normalizedFirstName + MAIL_DOMAIN;
    }

    return normalizedFirstName + MAIL_DELIMITER + normalizedLastName + MAIL_DOMAIN;
  }

  private static String normalizeName(String name) {
    if (isNullOrBlank(name)) {
      return "";
    }

    String normalizedString = name
        .strip()
        .toLowerCase();

    return Normalizer.normalize(normalizedString, Normalizer.Form.NFD)
        .replaceAll(NON_ALPHA_REGEX, "");
  }

  private static boolean isNullOrBlank(String string) {
    return Objects.isNull(string) || string.isBlank();
  }
}
