                                         Question B
B: Perform the validation checks in A for the 4 fields (username, email, password and date of birth) concurrently
(Note, do not use Threads, or ExecutorServices).

                                   Code Explanation and Observation
i. CompletableFuture tasks were used to concurrently perform the four validation checks without using Threads
   or ExecutorServices. The 'allOf task' waits for all validation tasks to complete, and then the results are checked to
   determine if any of the validations failed.This allows the validations to be performed concurrently without using
   threads or ExecutorServices.

