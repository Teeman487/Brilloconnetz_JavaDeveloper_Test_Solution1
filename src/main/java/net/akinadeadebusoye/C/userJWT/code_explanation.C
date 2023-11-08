                                         Question C
C. Building on your solution on B, instead of returning true when all validations pass, write a method
   to generate a signed JWT and return it.

                                  Code Explanation and Observation
i. To generate a signed JWT (JSON Web Token) upon successful validation instead of returning true, I included
   'jjwt-jackson' and 'jjwt-impl', jjwt-impl  JAR contains the implementation classes for the jjwt library,
    and it needs to be included in the project's classpath for the jjwt library to work correctly.

ii. In this code, if all validations pass, it generates a JWT using the generateJWT method and prints the JWT.
    I made use of a secure secret key for signing the JWT.