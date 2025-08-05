**Module**: Dashboard & Navigation

**Objective**:  
Verify that the breadcrumb trail reflects the user’s navigation path.

**Preconditions**:

- User is logged in as Admin
    
- User has navigated to any child page (e.g., Admin → User Management → Users)
    

**Test Steps**:

1. Note the breadcrumb at top (“Admin / User Management / Users”)
    
2. Navigate deeper (if available) and observe breadcrumb update
    

**Expected Result**:  
Breadcrumb shows each level in the path, matching page hierarchy.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: Breadcrumbs showed the correct paths.