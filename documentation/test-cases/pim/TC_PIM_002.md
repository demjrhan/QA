**Module**: PIM > Add Employee

**Objective**:  
Check that email field accepts only valid email formats.

**Preconditions**:

- User is logged in as Admin
    
- User is on PIM > Add Employee page
    

**Test Steps**:

1. Enter employee details
    
2. Enter invalid email formats (e.g., `abc`, `abc@`, `abc@domain`)
    
3. Click “Save”
    

**Expected Result**:  
System should display “Invalid email format” error and prevent saving.


[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: Invalid email inputs were rejected with an error message.