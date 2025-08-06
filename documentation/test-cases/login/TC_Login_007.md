**Module**: Login Page

**Objective**:  
Verify the system resists SQL injection in the password field.

**Preconditions**:

- User is on the OrangeHRM login page
    

**Test Steps**:

1. Enter username: Admin
    
2. Enter password: "' OR '1'='1"
    
3. Click the "Login" button
    

**Expected Result**:  
Login should fail and display “Invalid credentials” error message.

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: User successfully got “Invalid credentials” error message and stayed on the login page.