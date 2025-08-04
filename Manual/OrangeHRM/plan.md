
To simulate a real-world manual QA process by testing the publicly available OrangeHRM demo application. The official QA execution, documentation, and defect tracking will be managed in Jira. This Obsidian vault serves as a personal knowledge base for test planning, test case documentation, and end-of-cycle retrospectives.

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
  - Using labels (`executed_passed`, `executed_failed`, etc.)
- **Issue Types**:
  - Test Case
  - Bug
  - Task

### Supporting Tool: Obsidian

- **Used for**:
  - Test case documentation (copied from Jira descriptions)
  - Notes and observations during testing
  - Writing retrospectives and what was learned

---

## Test Coverage Scope

The following functionality will be tested manually using Jira-managed test cases:

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

## Bug Reporting Standard

All bugs are reported in Jira with the following structure:

- **Summary**: Clear and specific
- **Description**:
  - Steps to Reproduce
  - Expected Result
  - Actual Result
  - Severity & Priority
- **Labels**: Example: `orangehrm`, `login`, `manual`, `ux`
- **Attachments**: Screenshots when applicable
- **Linked Test Case**: If caused by a failed test case (e.g., TC_Login_002)

---

## Execution Plan

1. Create detailed test cases in Jira, starting with the Login module.
2. Document the same test case content in Obsidian under `/test-cases/`.
3. Begin test execution in Jira and comment outcomes.
4. Create bug issues for any failed test cases.
5. Write one `.md` file per test case in Obsidian for backup/reference.
6. Push documentation to GitHub after each module.
7. Write an end-of-cycle summary in Obsidian.

---

## Final Deliverables

| Deliverable       | Location                                                         |
| ----------------- | ---------------------------------------------------------------- |
| Test Cases        | Jira Board: OrangeHRM QA                                         |
| Bug Reports       | Jira Board: OrangeHRM QA                                         |
| Test Case Docs    | `OrangeHRM/test-cases/TC_<ID>.md` (Obsidian + GitHub)            |
| Summary Report    | `OrangeHRM/test-cycle-summary.md` (Obsidian + GitHub)            |
| GitHub Repository | [https://github.com/demjrhan/QA](https://github.com/demjrhan/QA) |

---

## Personal Notes & Observations

This vault does not duplicate test execution, but supports:
- Documenting test case structure and logic
- Recording small notes and observations
- Writing summaries of what was tested and learned

---

## Execution Result Format 

#### `executed_passed
`
```
[Execution Result] – PASSED  
Tested on: Chrome 
Outcome: User successfully redirected to Dashboard upon valid login.
```

#### `executed_failed`

```
[Execution Result] – FAILED  
Issue: Error message not shown for invalid input.  
Bug Reference: QA-ID
```

#### `test case entry example`

```
**Test Case ID**: TC_Login_001  
**Title**: Valid login with correct credentials

**Module**: Login Page

**Objective**:  
Verify that users can successfully log in using valid credentials.

**Preconditions**:  
- User is on the OrangeHRM login page
- Demo credentials are available

**Test Steps**:
1. Enter username: `Admin`
2. Enter password: `admin123`
3. Click the "Login" button

**Expected Result**:  
User is redirected to the Dashboard page and login is successful.

**Labels**: `testcase`, `manual`, `login`

```
#### `bug report example`

```
**Bug ID**: QA-Login-001  
**Title**: [BUG] No error message when logging in with invalid username

**Reported by**: Demirhan Yalcin  
**Date**: 2025-08-04  
**Related Test Case**: TC_Login_001

**Environment**:
- Browser: Chrome
- OS: Windows 11

---

### Description

**Steps to Reproduce:**
1. Open the login page
2. Enter username: `WrongUser`
3. Enter password: `admin123`
4. Click the "Login" button

**Expected Result:**  
System should display an error message: “Invalid credentials”

**Actual Result:**  
No message appears; page reloads silently

**Impact:**  
The user is not informed why login failed, affecting usability and error handling.

**Attachments**:  
- Screenshot: `invalid-login-no-error.png`

```

---

## Test Case Example Folder Structure

```
/test-cases/  
├── login/  
│ ├── TC_Login_001.md  
│ ├── TC_Login_002.md  
│ └── ...
```