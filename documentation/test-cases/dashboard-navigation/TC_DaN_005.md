**Module**: Dashboard & Navigation

**Objective**:  
Verify that a non-Admin user does not see Admin-only menu items.

**Preconditions**:

- User is logged in as Employee, non admin.
    
- User is on the Dashboard page
    

**Test Steps**:

1. List all visible main menu items
    
2. Confirm absence of “Admin” and its submenus
    

**Expected Result**:  
Non admin user sees only “PIM”, “Leave”, “Time”, “Dashboard”, “Directory”, “Buzz”.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: After logged in as User, Admin dashboard link in navigation menu was absent.