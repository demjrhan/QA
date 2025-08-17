**Module**: PIM > Add Employee

**Objective**:  
Verify phone number field accepts only valid numeric input.

**Preconditions**:

- User is logged in as Admin
    
- User is on PIM > Add Employee page
    

**Test Steps**:

1. Enter employee details
    
2. Enter letters or special characters in phone number field (e.g., `abc123`, `123-@!`)
    
3. Click “Save”
    

**Expected Result**:  
System should display “Invalid phone number” error and prevent saving.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: Phone field rejected non-numeric input and displayed appropriate error.