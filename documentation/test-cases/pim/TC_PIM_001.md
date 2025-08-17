**Module**: PIM > Add Employee

**Objective**:  
Verify that all mandatory fields are validated when adding a new employee.

**Preconditions**:

- User is logged in as Admin
    
- User is on PIM > Add Employee page
    

**Test Steps**:

1. Click “Add Employee”
    
2. Leave all mandatory fields empty
    
3. Click “Save”
    

**Expected Result**:  
Error messages should appear for all mandatory fields (First Name, Last Name, Employee ID).

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: All mandatory field error messages appeared, preventing form submission.