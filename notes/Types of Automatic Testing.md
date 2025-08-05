### Smoke testing

Smoke tests are basic tests that check the basic functionality of an application. They are meant to be quick to execute, and their goal is to give you the assurance that the major features of your system are working as expected.

Smoke tests can be useful right after a new build is made to decide whether or not you can run more expensive tests, or right after a deployment to make sure that they application is running properly in the newly deployed environment.

### Regression testing

Regression tests are repeatable tests that check whether existing functionality still works after changes in the codebase, such as bug fixes, feature updates, or refactors. Their purpose is to catch unexpected side effects introduced by recent changes.

Regression testing is typically run after any change to ensure the overall system behavior remains consistent. It helps confirm that new work hasn't broken previously working features.


### Unit Tests

They consist in testing individual methods and functions of the classes, components, or modules used by your software. Unit tests are generally quite cheap to automate and can run very quickly by a continuous integration server.

### Integration Tests

Integration tests verify that different modules or services used by your application work well together. For example, it can be testing the interaction with the database as expected. This test can be expensive to run as they require multiple parts of the application to be up and running.

### End-to-End Tests
End-to-end testing replicates a user behavior with the software in a complete application environment. It verifies that various user flows work as expected and can be as simple as loading a web page or logging in or much more complex scenarios verifying email notifications, online payments, etc...

End-to-end tests are very useful, but they're expensive to perform and can be hard to maintain when they're automated. It is recommended to have a few key end-to-end tests and rely more on lower level types of testing (unit and integration tests) to be able to quickly identify breaking changes.

### Acceptance Testing

Is the final level of testing done **before the software is released** to ensure it meets **business requirements** and is acceptable to the end user or client.
### Performance testing

Performance tests evaluate how a system performs under a particular workload. These tests help to measure the reliability, stability, and availability of an application.  It can determine if an application meets performance requirements, locate bottlenecks, measure stability during peak traffic, and more.

### Load Testing

Tests how to system performs under expected user load. In this type of test we are trying to understand some aspects like response times, stability and resource usage. By checking these aspects we can also determine if system has and bottlenecks while under regular load.


### Stress Test

Tests how the system performs beyond its limits. Extreme amount of visitors can be one example. In this test we are trying to find where is the first link breaks the chain. What is the reason of breakpoint. And when system fails we also need to make sure system fails as expected, not something we can not handle.

### Retesting

Retesting is the process of testing a **specific failed test case again** after a bug fix or code correction to confirm that the issue has been resolved.
