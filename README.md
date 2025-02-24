<h1 align="center">SoftServe Technical Test - Remove Duplicates</h1>

## Problem Statement

Given a simple string: `AABBCCD112233`.  
All you need is to return a new string that does not contain any duplicates.  
The code should be clean, readable, and optimized.  
Additionally, we expect to see test coverage with different test cases.

## Overview

This project is a Java application that implements a REST API to remove duplicate characters from a given input string while preserving the order of their first occurrence.

## Features

- Validates the input string.
- Removes duplicate characters while preserving their original order.
- Handles Unicode characters correctly.
- Provides clear error handling for invalid inputs.
- Fully tested with unit and end-to-end tests.

## Technologies

- **Java 17**
- **Spring Boot**
- **Maven**

## Running the Application
## Installation

1. You must have Java 17 installed on the computer where this application is run.

2. Clone the repository into a folder:
   ```bash
   git clone https://github.com/carlosNietoTinoco/softserve-technical-test-.git

3. Go into the softserve-technical-test folder and run the following command.
   ```bash
   java -jar ./target/technical-test-0.0.1-SNAPSHOT.jar 

## Running with Maven

Alternatively, you can run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

## API Usage

The application exposes a REST endpoint to remove duplicate characters from an input string.

### Endpoint:
```bash
POST /api/v1/string/unique-strings
```

### Request Body Example:
```json
{
  "input": "AABBCCD112233"
}
```

### Response:
```arduino
"ABCD123"
```

## Development Process

This development was carried out following the TDD methodology:

### Initial Setup:
A base project was obtained from [https://start.spring.io/](https://start.spring.io/) with the configurations shown in the image below.

![Captura desde 2025-02-24 08-13-43](https://github.com/user-attachments/assets/1ce457e4-6bc7-4025-b859-c539e2fbe642)

### RED Phase:
A basic structure for a REST API service was created, and all unit tests, as well as an end-to-end test, were designed to cover the entire workflow. Initially, these tests were expected to fail.

### GREEN and REFACTOR Phases:
The function responsible for removing duplicates was developed and refined until all tests designed during the RED phase passed successfully, ensuring a clean, readable, and optimized solution.