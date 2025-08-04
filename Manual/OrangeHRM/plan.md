
To simulate a real-world manual QA process by testing the publicly available OrangeHRM demo application. The official QA execution, documentation, and defect tracking will be managed in Jira. This Obsidian vault will serve as a personal knowledge base and reflection journal throughout the project.

---

## Project Information

- **Application Under Test**: OrangeHRM (Demo)
- **Test Environment**: https://opensource-demo.orangehrmlive.com/
- **Test Account**:
  - Username: Admin
  - Password: admin123

---

## QA Management Approach

### Primary Tool: Jira

- **Project Name**: OrangeHRM QA
- **Used for**:
  - Writing and executing test cases
  - Logging and tracking bugs
  - Organizing tasks by test cycles or modules
  - Using labels and priorities for categorization
- **Issue Types**:
  - Test Case
  - Bug
  - Task

### Supporting Tool: Obsidian

- **Used for**:
  - Personal notes and test strategy drafts
  - Logging learning progress and discoveries
  - End-of-cycle summaries and reflections
  - Observations not directly tied to execution (e.g., UI/UX thoughts, tooling feedback)

---

## Test Coverage Scope

The following functionality will be tested manually through Jira-based test cases:

### 1. Login Page
- Valid/Invalid credentials
- Empty input fields
- Case sensitivity
- SQL injection attempts
- Session management

### 2. Dashboard and Navigation
- Menu links and routing
- Breadcrumbs
- Role-based access (if any)

### 3. PIM > Add Employee
- Field validations
- Format boundaries (email, phone)
- File upload functionality
- Save vs Cancel behavior

### 4. Search and Filtering
- Valid/Invalid input handling
- Search reset
- Edge cases

### 5. Error Handling and UX
- Message clarity
- Behavior under invalid input
- Dropdowns, popups, alerts

---

## Bug Reporting

All bugs will be logged and maintained in **Jira**, following this structure:

- **Summary**: Brief and descriptive
- **Description**:
  - Steps to Reproduce
  - Expected Result
  - Actual Result
  - Severity and Priority
- **Attachments**: Screenshots where applicable
- **Labels**: E.g., `orangehrm`, `login`, `manual`, `ux`, etc.

---

## Execution Plan

1. Create a **test plan and test cases** for Login functionality in Jira.
2. Begin test execution in Jira. Track pass/fail and link bugs if found.
3. For each bug encountered, create a bug report in Jira using the standard template.
4. Continue to the next modules (Navigation, PIM, etc.) in the same structured approach.
5. After each module, optionally add a brief reflection in Obsidian.
6. After full coverage, summarize the QA cycle in this vault.

---

## Final Deliverables

| Deliverable       | Location                                                         |
| ----------------- | ---------------------------------------------------------------- |
| Test Cases        | Jira Board: OrangeHRM QA                                         |
| Bug Reports       | Jira Board: OrangeHRM QA                                         |
| Summary Report    | `OrangeHRM/test-cycle-summary.md` (Obsidian)                     |
| GitHub Repository | [https://github.com/demjrhan/QA](https://github.com/demjrhan/QA) |

---

## Personal Notes (in this vault)

This vault is not used to duplicate Jira. It will serve as:
- A **journal of test strategy decisions**
- A place to track **lessons learned**
- A place to write end-of-phase **retrospectives**
- A reference for future projects or job interviews

---

## Notes

- All test executions and defects are tracked in Jira.
- No duplicate test case details will be maintained in this vault.
- This vault is an internal companion to the structured Jira workflow and the public GitHub repository.

