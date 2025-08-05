**Module**: Login Page / Session Management

**Objective**:  
Verify session invalidation after logout and prevent access via back-button.

**Preconditions**:  
- User is logged in

**Test Steps**:  
1. Click “Logout”  
2. Click browser “Back” button

**Expected Result**:  
User is redirected to the login page and cannot view protected pages.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: User is logged-out and back button did not bring the page as logged in.