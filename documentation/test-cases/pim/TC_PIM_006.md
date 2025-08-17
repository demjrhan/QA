**Module**: Leave > Apply Leave

**Objective**:  
Verify that the system prevents applying leave for past dates.

**Preconditions**:

- User is logged in as Admin
    
- User is on Leave > Apply Leave page
    

**Test Steps**:

1. Click “Apply Leave”
    
2. Select a leave type (e.g., “Annual Leave”)
    
3. Enter a **From Date** and **To Date** that are in the past
    
4. Click “Save”
    

**Expected Result**:  
System should display an error message: “Cannot apply leave for past dates” and prevent submission.

[Execution Result] – FAILED  
Tested on: Chrome  
Outcome: Leave was incorrectly submitted for past dates; no error message was displayed.