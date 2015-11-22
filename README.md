
# Polynomial-multiplication-algorithm
Polynomial multiplication algorithm with timing analysis

Written in Java.
Uncomment the code between the horizontal dotted lines for corresponding solutions in Java file.

Change the length variable to change the number of input objects 
All three solutions are written in seperate functions. To execute each uncomment the correponding section.

                 ------------------------------------------------------------------------

Folders -

  Raw Data - Inputs used for testing all the algorithms
  
  Java Code - Code used for the algos
  
  Graphs - Graphs with different parameters to measure the efficiency of the algorithm
  
  Report - Detailed information about graphs and observations.

                 ------------------------------------------------------------------------

1)      Implemented three algorithms for solving the polynomial multiplication algorithm:

Given two polynomials P and Q each represented as an array of doubles where P[i] is the coefficient of x to the power i in polynomial P.
Return the polynomial that is the product of P and Q called PQ.
Note that if P and Q are of order n-1 (the highest power of x is n-1) they will have n coefficients and PQ will have 2n-1 coefficients.

2)      Here are the three algorithms you are to implemented:

    Simple school-book algorithm using two nested for loops.
  
    Simple divide and conquer recursive algorithm that generates four subproblems
  
    More complex divide and conquer algorithm that generates three subproblems
  
  Empirical study for a large set of random problems.
  For each problem, a polynomial will be a one dimensional array of n random doubles within the range of -1.0 to +1.0. 
  In this will loop from n = 32 to as large as possible, doubling the problem size each time (so n is always a power of 2). 
  For each problem size generate a set of random problems of size n, and measure the time each algorithm takes to solve the same set of problems. 
  Generate enough random problems so that the lines on the graph connecting the times is linear (on the log/log plot). 
  Note that the lower efficiency algorithms may not be able to solve the largest of problem sizes.

3)      A single log/log graph where x is the problem size and y is the time to solve the problem set.

 


