**Reported by**: Demirhan Yalcin  
**Date**: 2025-08-04  
**Related Test Case**: TC_Login_004

**Environment**:

- Browser: Chrome
    
- OS: Windows 11
    

---

### Description

**Steps to Reproduce:**

1. Open the login page
    
2. Enter username: ADMIN
    
3. Enter password: admin123
    
4. Click the "Login" button
    

**Expected Result:**  
System should display an error message: “Invalid credentials”

**Actual Result:**  
User is redirected to the Dashboard page and login was successful.

**Impact:**  
Even though nickname was not correct, it accepted it as correct.