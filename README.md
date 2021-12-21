# EMP_pserbco
APCS L03: Get Empirical
## pserbco
#### Paul Serbanescu, Joseph Othman, Andrew Piatetsky

## Tests Performed
  * Our final plan ended up being:
    - Create an array of length 1000, with each element being an integer with the value of its index in the array.
    - Search for a random element in this array using linear search, timing how long linear search takes by using currentTimeMillis().
    - Search for the same random element in the same array using binary search.
    - Perform each search 1000 times, each time with a randomly generated element (with possible overlap, albeit unlikely as the array size increases).
    - Take the average of all of the linear search test times, and take the average of all of the binary search test times.
    - Do the same test, except for an array of lengths: 
      - 10,000 
      - 100,000 
      - 1,000,000
      - 10,000,000
      - 100,000,000
      - 200,000,000

## Results

#### Using array of Comparables (Comparables[]) repeating and timing each test 1,000 times
  * Array length of 1,000:
    - Average Binary Search: 0.004ms
    - Average Linear Search: 0.004ms
    - Time to fill Array: 0ms
  * Array length of 10,000:
    - Average Binary Search: 0.005ms
    - Average Linear Search: 0.015ms
    - Time to fill Array: 1ms
  * Array length of 100,000:
    - Average Binary Search: 0.003ms
    - Average Linear Search: 0.043ms
    - Time to fill Array: 5ms
  * Array length of 1,000,000:
    - Average Binary Search: 0.004ms
    - Average Linear Search: 0.31ms
    - Time to fill Array: 19ms
  * Array length of 10,000,000:
    - Average Binary Search: 0.008ms
    - Average Linear Search: 3.659ms
    - Time to fill Array: 227ms
  * Array length of 100,000,000:
    - Average Binary Search: 0.011ms
    - Average Linear Search: 31.212ms
    - Time to fill Array: 2080ms
  * Array length of 200,000,000:
    - Average Binary Search: 0.008ms
    - Average Linear Search: 61.156ms
    - Time to fill Array: 3776ms

#### Using array of ints repeating and timing each test 1,000 times
  * Array Length of 1,000:
    - Binary: 0.002ms
    - Linear: 0.003ms
  * Array Length of 10,000:
    - Binary: 0.002ms
    - Linear: 0.008ms
  * Array Length of 100,000:
    - Binary: 0.0ms
    - Linear: 0.017ms
  * Array Length of 1,000,000:
    - Binary: 0.001ms
    - Linear: 0.135ms
  * Array Length of 10,000,000:
    - Binary: 0.003ms
    - Linear: 0.948ms
  * Array Length of 100,000,000:
    - Binary: 0.003ms
    - Linear: 9.423ms
  * Array Length of 1,000,000,000:
    - Binary: 0.006ms
    - Linear: 90.418ms

## Conclusions
  * With respect to the size of the search array, linear search and binary search initially took similar amounts of time, but as the array size increased, binary search ended     up becoming a much quicker searching algorithm than linear search.
  * The previous conclusion becomes clearer when thinking about the time it takes for each algorithm to run (under worst-case scenario). If we denote the length of the array     to be n, then the most amount of steps it takes for linear search to find an element is n steps. However, binary search can find an element under worst case scenario in       around log (base 2) of n steps. Since logarithmic functions increase much slower than linear functions, as n gets very large, we can see that binary search should             theoretically work much faster than linear search (which is supported by our empirical data).
  * Interestingly, the only real distinctions between these sorting methods (in terms of empirical time to finish) only becomes significant when n is very large, meaning that     the loops that are run for each search method are being performed incredibly fast; this is against the expectation when we think theoretically about the "number of           steps".
  * For instance, in the case of an array of length 1000, the binary search method should complete in 11 steps under worst case scenario, whereas the linear search method         completes in 1000 steps under its own worst case scenario. However, the average times for linear and binary search for an array of length 1000 are about equal, meaning       that the time it takes for each step to run in binary search is much larger than the time it takes for each step to run in linear search.
