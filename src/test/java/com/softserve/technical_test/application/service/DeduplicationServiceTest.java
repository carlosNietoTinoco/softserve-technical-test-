package com.softserve.technical_test.application.service;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class DeduplicationServiceTest {

    private final DeduplicationService deduplicationService = new DeduplicationService();

    // 1. Basic Tests

    // Nominal case: removes duplicates leaving only the first occurrence.
    @Test
    public void testRemoveDuplicatesNominal() {
        String input = "AABBCCD112233";
        String expected = "ABCD123";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // String without duplicates: returns the same string.
    @Test
    public void testRemoveDuplicatesNoDuplicates() {
        String input = "ABC123";
        String expected = "ABC123";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // Single-character string.
    @Test
    public void testRemoveDuplicatesSingleCharacter() {
        String input = "A";
        String expected = "A";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // 2. Tests with All Duplicates

    // All characters repeated.
    @Test
    public void testRemoveDuplicatesAllDuplicates() {
        String input = "AAAA";
        String expected = "A";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // 3. Case Sensitivity Tests

    // Characters with different capitalization.
    @Test
    public void testRemoveDuplicatesCaseSensitive() {
        String input = "AaAa";
        String expected = "Aa";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // 4. Special and Non-Alphanumeric Characters Tests

    // Special symbols.
    @Test
    public void testRemoveDuplicatesSpecialCharacters() {
        String input = "!!@@##$$";
        String expected = "!@#$";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // Handling whitespace.
    @Test
    public void testRemoveDuplicatesSpaces() {
        String input = "A A A";
        String expected = "A ";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // 5. Unicode Characters Tests

    // Accented letters.
    @Test
    public void testRemoveDuplicatesUnicodeAccented() {
        String input = "ááééíí";
        String expected = "áéí";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // Non-Unicode characters (should throw an exception)
    @Test
    public void testRemoveDuplicatesNonUnicodeCharacters() {
        // Simulate an invalid Unicode string using an isolated high surrogate
        String input = "\uD800";
        assertThrows(IllegalArgumentException.class, () -> deduplicationService.removeDuplicates(input));
    }

    // 6. Edge Cases

    // Empty string.
    @Test
    public void testRemoveDuplicatesEmptyString() {
        String input = "";
        String expected = "";
        String actual = deduplicationService.removeDuplicates(input);
        assertEquals(expected, actual);
    }

    // Null input: expected to throw an exception.
    @Test
    public void testRemoveDuplicatesNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            deduplicationService.removeDuplicates(null);
        });
    }

    // Performance/Extreme Test: Very long string (e.g., 1 million characters with many duplicates).
    @Test
    public void testRemoveDuplicatesPerformance() {
        // Build a string by repeating "ab" 500,000 times.
        int repeat = 500000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append("ab");
        }
        String input = sb.toString();
        // Expected output is "ab" (the first occurrence of 'a' and 'b')
        String expected = "ab";

        // Verify that the execution completes in less than 1 second.
        String actual = assertTimeout(Duration.ofSeconds(1), () -> deduplicationService.removeDuplicates(input));
        assertEquals(expected, actual);
    }
}

