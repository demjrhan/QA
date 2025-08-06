**Module**: Dashboard & Navigation

**Objective**:  
Verify that each main menu link on the Dashboard routes to the correct page.

**Preconditions**:

- User is logged in as Admin
    
- User is on the Dashboard page
    

**Test Steps**:

1. Click on “Admin” in the main menu
    
2. Observe the URL and page header
    
3. Repeat for “PIM”, “Leave”, “Time”, “Recruitment”, “Dashboard”, “Directory”, “Maintenance”, “Buzz”
    

**Expected Result**:  
Each click navigates to its respective module’s landing page (URL and header match link text).

[Execution Result] – FAILED  
Issue: Page header for my info recorded as PIM  
Bug Reference: BUG_DaN_001