**Reported by**: Demirhan Yalcin  
**Date**: 2025-08-18  
**Related Test Case**: TC_Search_004

**Environment**:

- Browser: Chrome
    
- OS: Windows 11
    

---

### **Description**

**Steps to Reproduce:**

1. Log in as Admin
    
2. Navigate to `PIM > Employee List`
    
3. Enter a valid employee name with leading and trailing spaces (e.g., “ Linda Anderson ”)
    
4. Click “Search”
    

**Expected Result:**  
System should trim extra spaces and return the correct matching employee record(s).

**Actual Result:**  
System returned “No Records Found” when leading/trailing spaces were present in the input.

**Impact:**  
Users may fail to locate employees if they accidentally add spaces in the search field. This reduces usability and causes incorrect assumptions about missing data.

**Bug Reference:** **BUG_SnF_001**