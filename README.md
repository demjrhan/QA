# QA Learning Journey

This repository tracks my learning path in Quality Assurance (QA), starting with manual testing and progressing into automation with Selenium and Java. Each phase is organized, documented, and versioned for clarity and growth.

---

## Learning Plan

### 1. Manual Testing

#### Test Coverage Scope

The following functionality will be manually tested using Jira-managed test cases:

1. **Login Page**
   - Valid/Invalid credentials
   - Empty input fields
   - Case sensitivity
   - SQL injection attempts
   - Session management

2. **Dashboard and Navigation**
   - Menu links and routing
   - Breadcrumbs
   - Role-based access (if any)

3. **PIM > Add Employee**
   - Field validations
   - Format boundaries (email, phone)
   - File upload functionality
   - Save vs Cancel behavior

4. **Search and Filtering**
   - Valid/Invalid input handling
   - Search reset
   - Edge cases

5. **Error Handling and UX**
   - Message clarity
   - Behavior under invalid input
   - Dropdowns, popups, alerts

---

### 2. API Testing

- Use **Postman** to test:
  - Public APIs (e.g., JSONPlaceholder)
  - Backend services (e.g., PetClinic)
- Focus on:
  - Request/response validation
  - Status codes and error handling
  - Auth flow (if applicable)

---

### 3. Selenium + Java

- Create a **Maven** project
- Automate test flows like:
  - Login
  - Form submissions
- Gradually implement:
  - Page Object Model (POM)
  - Modular structure and reusable components

---

## Version Control

All documentation, test scripts, and notes are organized and versioned in this repository using:

- Branches for different phases
- Markdown files for test documentation
- Source folders for automation scripts

---

## Goal

To build hands-on QA experience from foundational test design to automation, simulating real-world workflows and tools.
