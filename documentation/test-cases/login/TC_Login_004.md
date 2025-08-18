**Module**: Login Page

**Objective**:  
Check if username input is case-sensitive.

**Preconditions**:

- User is on the OrangeHRM login page
    

**Test Steps**:

1. Enter username: ADMIN
    
2. Enter password: admin123
    
3. Click the "Login" button
    

**Expected Result**:  
Login should fail and display “Invalid credentials” error message.

[Execution Result] – FAILED  
Issue: Username input field is not case sensitive.  
Bug Reference: BUG_Login_004
