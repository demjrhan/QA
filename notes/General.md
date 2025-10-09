#### What is the difference between verification and validation in software testing?

> **Verification** can be imagined like a checklist: “Is this requirement implemented?”, “Is this module present?”, “Does the UI contain the required elements?” All based on documentation and specifications, without running the software.

> **Validation** involves actually using the product and checking if it behaves correctly. For example, entering a duplicate ID in a form and seeing if it’s correctly rejected as non-unique.


#### What are the different types of software testing? Give at least four types and a short explanation for each.

> As different types of software testing, the first four examples that come to my mind are white, black, gray box testing, and smoke testing.


> In white box testing the tester has knowledge of the internal structure, such as the architecture and code of the app being tested. This allows the tester to create detailed and focused tests, such as unit tests.


> In gray box testing the tester is a hybrid of black and white box testers. In this test type, it’s expected that the tester knows some parts of the structure, design, or code of the current app, and also performs input-output-based testing. This approach is commonly used in website testing.


> In black box testing, unlike white box testing, the tester does not interact with or know about the internal structure, design, or code of the product. The tester only works with inputs and expected outputs. This method simulates how an actual user interacts with the product.


> Smoke testing is a simple and fast way to check the general functionality of the app without going into deep detail, like checking the surface only. This is usually done after a new push to the repository to quickly verify overall system health. Based on the results, more detailed tests like integration testing can be done.

#### What is a test case? What are the key elements that should be included in a good test case?

> Test case is generally a structured set of actions to check whether a specific part or the overall behavior of a program meets expectations. Testing smaller parts can provide more focused feedback, but in highly cohesive programs, it may be necessary to test flows rather than single unit.

> Key elements like Example Data and Validators play an important role. Example data helps simulate user input or system conditions, while validators confirm whether the observed outcome matches the expected result based on predefined rules.

#### Explain the difference between regression testing and retesting.

> Regression testing is the process of testing the **whole system (or selected parts)** after recent changes — like bug fixes, new features, or code updates — to make sure that **nothing else broke** in the existing functionality. It’s about **preventing side effects**.

> Retesting is focused testing of the **same test case** that previously **failed**, but this time on a **new build** where the developer says the bug is fixed. It’s done to confirm that the **specific issue is resolved**.

> Example: You found a login bug and the developer fixed it.
- You **retest** the login feature to see if it now works.
- Then, you run **regression testing** to make sure that this fix didn’t break registration, session handling, or profile updates.
#### What is bottleneck?

>Bottleneck is a part of a system that slows down the overall performance because its too slow or too limited.

#### Test Case vs Test Scenario

> A **test case** is a detailed, individual test.  
    It includes inputs, steps, and expected results for verifying one specific behavior.  
    Example: “Clicking the login button with an empty email should show an error.”

 > A **test scenario** is a high-level user flow or goal.  
    It represents what to test, not the step-by-step details.  
    Example: “User logs in with valid credentials and updates profile.”


>**Test Scenario** = What to test  
  **Test Case** = How to test it


#### Test Plan

>A **test plan** is a formal document that outlines the **strategy, scope, resources, and schedule** for testing an application. It defines **what to test**, **how to test it**, **who will do the testing**, and **when**. The plan helps ensure testing is organized, comprehensive, and aligned with project goals.

It typically includes:  
- Test objectives and scope  
- Features to be tested and not tested  
- Testing types and methods (manual, automation)  
- Resource assignments and responsibilities  
- Test schedule and milestones  
- Criteria for pass/fail and entry/exit  
