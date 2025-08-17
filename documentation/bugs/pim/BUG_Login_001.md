**Reported by**: Demirhan Yalcin  
**Date**: 2025-08-05  
**Related Test Case**: TC_PIM_006

**Environment**:

- Browser: Chrome
    
- OS: Windows 11
    

---

### Description

**Steps to Reproduce:**

1. Log in as Admin
    
2. Navigate to Leave > Apply Leave page
    
3. Click “Apply Leave”
    
4. Select a leave type (e.g., “Annual Leave”)
    
5. Enter a **From Date** and **To Date** that are in the past
    
6. Click “Save”
    

**Expected Result:**  
System should display an error message: “Cannot apply leave for past dates” and prevent submission.

**Actual Result:**  
Leave was submitted successfully for past dates; no error message was displayed.

**Impact:**  
Users can apply leave for past dates, potentially affecting attendance and payroll records. This is a functional defect that needs to be fixed.