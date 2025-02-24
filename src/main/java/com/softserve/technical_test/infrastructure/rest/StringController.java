package com.softserve.technical_test.infrastructure.rest;

import com.softserve.technical_test.application.service.DeduplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/string")
public class StringController {

    private final DeduplicationService deduplicationService;

    public StringController(DeduplicationService deduplicationService) {
        this.deduplicationService = deduplicationService;
    }

    @PostMapping("/unique-strings")
    public ResponseEntity<String> createUniqueString(@RequestBody String input) {
        String output = deduplicationService.deduplicate(input);
        return ResponseEntity.ok(output);
    }
}

