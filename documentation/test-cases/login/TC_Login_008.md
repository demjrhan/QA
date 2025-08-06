**Module**: Login Page / Session

**Objective**:  
Verify that after successful login, clicking browser "Back" does not return to the login page without logout.

**Preconditions**:

- User is logged in and on Dashboard
    

**Test Steps**:

1. Click browser “Back” button
    
2. Observe the page
    

**Expected Result**:  
User remains on Dashboard or is prompted to log in again; login session remains active.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: Website still remembered the active logged-in user credentials after back button.