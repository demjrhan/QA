**Module**: Login Page

**Objective**:  
Verify that the system prevents access when incorrect login credentials are used.

**Preconditions**:

- User is on the OrangeHRM login page
    

**Test Steps**:

1. Enter username: Admin
    
2. Enter password: wrongpass
    
3. Click the "Login" button
    

**Expected Result**:  
User should remain on the login page with an error message: “Invalid credentials” even though one of the credentials is correct.