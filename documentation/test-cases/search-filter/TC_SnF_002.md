**Module**: Search and Filtering

**Objective**:  
Verify that invalid search input returns “No Records Found”.

**Preconditions**:

- User is logged in as Admin
    
- User is on the Employee List page
    

**Test Steps**:

1. In the search field, enter an invalid string (e.g., “XYZ1234”)
    
2. Click “Search”
    
3. Observe search results
    

**Expected Result**:  
System displays “No Records Found”.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: System correctly displayed “No Records Found” for invalid input.