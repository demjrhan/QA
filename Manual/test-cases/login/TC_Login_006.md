**Module**: Login Page

**Objective**:  
Verify the system resists SQL injection in the username field.

**Preconditions**:

- User is on the OrangeHRM login page
    

**Test Steps**:

1. Enter username: `"' OR '1' ='1"`
    
2. Enter password: random
    
3. Click the "Login" button
    

**Expected Result**:  
Login should fail and display “Invalid credentials” error message.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: User successfully got “Invalid credentials” error message and stayed on the login page.