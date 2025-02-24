package com.softserve.technical_test.application.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class DeduplicationService {

    public String removeDuplicates(String input) {

        isValidString(input);
        return removeDuplicatesPreservingOrder(input);
    }

    private String removeDuplicatesPreservingOrder(String input) {

        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Integer> seen = new LinkedHashSet<>();

        for (int i = 0; i < input.length(); ) {
            int cp = input.codePointAt(i);
            if (!seen.contains(cp)) {
                seen.add(cp);
                sb.appendCodePoint(cp);
            }
            i += Character.charCount(cp);
        }

        return sb.toString();
    }

    private void isValidString(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        for (int i = 0; i < input.length(); ) {
            char c = input.charAt(i);
            if (Character.isHighSurrogate(c)) {
                if (i + 1 >= input.length() || !Character.isLowSurrogate(input.charAt(i + 1))) {
                    throw new IllegalArgumentException("Unpaired high surrogate at index " + i);
                }
                i += 2;
            } else if (Character.isLowSurrogate(c)) {
                throw new IllegalArgumentException("Unpaired low surrogate at index " + i);
            } else {
                i++;
            }
        }
    }
}
