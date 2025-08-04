**Module**: Login Page

**Objective**:  
Verify that the system prevents access when incorrect login credentials are used.

**Preconditions**:

- User is on the OrangeHRM login page
    

**Test Steps**:

1. Enter username: `WrongUser`
    
2. Enter password: `wrongpass`
    
3. Click the "Login" button
    

**Expected Result**:  
User should remain on the login page with an error message: “Invalid credentials”

[Execution Result] – PASSED  
Tested on: Chrome  
Outcome: User successfully got “Invalid credentials” error message and stayed on the login page.