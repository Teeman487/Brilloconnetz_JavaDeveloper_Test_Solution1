                                     Question D
D: Using the token generated in C, write a method to verify the signed token, return the string
   “verification pass” if it passes and “verification fails” if it does not.


                                   Code Explanation and Observation
i. In order to verify a signed JWT token and return "verification pass" if it passes or "verification fails" if it does
   I created a verifying signing JWT method in JWTVerifier class.

ii.  VerifyJWT method  was used to check the validity of a given JWT token(taken from packageC.userJWT class and return
      "verification pass" if the token is valid and "verification fails" if it's not.

