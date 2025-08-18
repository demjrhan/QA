**Module**: Search and Filtering

**Objective**:  
Verify that search is case-insensitive.

**Preconditions**:

- User is logged in as Admin
    
- User is on the Employee List page
    

**Test Steps**:

1. Enter a valid employee name in lowercase (e.g., “linda anderson”)
    
2. Click “Search”
    
3. Observe results
    

**Expected Result**:  
System ignores case and displays matching employee record(s).

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: Search successfully returned records regardless of text case.