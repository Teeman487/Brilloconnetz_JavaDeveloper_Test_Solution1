                                          Question E

E: Write a JUnit Test case for D to check to test a valid and invalid token.

                                   Code Explanation and Observation
i. To create JUnit test cases for verifying valid and invalid tokens, JUnit library was added to the project
   dependencies for running the test.

ii. In the Java program, we have created two test methods: testValidJWT and testInvalidJWT. The first test generates a
    valid JWT token, verifies it, and asserts that the verification result should be "verification pass." The second
    test uses an intentionally invalid token and asserts that the verification result should be "verification fails."

