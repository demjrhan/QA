
**Module**: Search and Filtering

**Objective**:  
Verify that leading and trailing spaces in search input are ignored.

**Preconditions**:

- User is logged in as Admin
    
- User is on the Employee List page
    

**Test Steps**:

1. Enter an employee name with extra spaces (e.g., “ Linda Anderson ”)
    
2. Click “Search”
    
3. Observe results
    

**Expected Result**:  
System trims spaces and displays matching employee record(s).

[Execution Result] – FAILED  
Tested on: Chrome  
Outcome: System returned “No Records Found” when spaces were included.  
Bug Reference: **BUG_SnF_001**