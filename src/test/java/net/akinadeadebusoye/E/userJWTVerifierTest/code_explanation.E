                                     Question
E: Write a JUnit Test case for D to check to test a valid and invalid token.

                                   Code Explanation
i. The verifyJWT method uses the Jwts.parserBuilder() to create a JWT parser with the secret key used for signing the JWT.
It then attempts to parse and verify the token. If the verification is successful, it returns "verification pass.
" If the verification fails due to an exception (e.g., token expired or signature mismatch), it returns "verification fails.
