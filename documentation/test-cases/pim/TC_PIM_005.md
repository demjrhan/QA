**Module**: PIM > Add Employee

**Objective**:  
Check behavior of “Save” vs “Cancel” buttons.

**Preconditions**:

- User is logged in as Admin
    
- User is on PIM > Add Employee page
    

**Test Steps**:

1. Enter employee details
    
2. Click “Save” and observe if employee is added to the list
    
3. Repeat steps and click “Cancel” instead
    
4. Observe if data is discarded and user is returned to employee list
    

**Expected Result**:

- “Save” should add the employee and display a success message
    
- “Cancel” should discard data and return to employee list
  
[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: “Save” added employee successfully; “Cancel” discarded changes and returned to list.