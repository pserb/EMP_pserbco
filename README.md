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

### Using array of Comparables (Comparables[]) repeating and timing each test 1,000 times
  #### Searching for random values existing in the array of Comparables
  | Array Length | Average Binary Search Time | Average Linear Search Time |
  |:------------:|:--------------------------:|:--------------------------:|
  | 1,000        | 0.004ms                    | 0.004ms                    |
  | 10,000       | 0.005ms                    | 0.015ms                    |
  | 100,000      | 0.003ms                    | 0.043ms                    |
  | 1,000,000    | 0.004ms                    | 0.31ms                     |
  | 10,000,000   | 0.008ms                    | 3.659ms                    |
  | 100,000,000  | 0.011ms                    | 31.212ms                   |
  | 200,000,000  | 0.008ms                    | 61.156ms                   |


  #### Worst case scenario (searching for last item in the array)
  | Array Length | Average Binary Search Time | Average Linear Search Time |
  |:------------:|:--------------------------:|:--------------------------:|
  | 1,000        | 0.003ms                    | 0.015ms                    |
  | 10,000       | 0.003ms                    | 0.022ms                    |
  | 100,000      | 0.003ms                    | 0.069ms                    |
  | 1,000,000    | 0.005ms                    | 0.606ms                    |
  | 10,000,000   | 0.005ms                    | 6.749ms                    |
  | 100,000,000  | 0.011ms                    | 62.326ms                   |
  | 200,000,000  | 0.005ms                    | 121.928ms                  |


---


### Using array of ints repeating and timing each test 1,000 times
  #### Although this was a secondary objective, we ran tests on int arrays to see if the pattern persisted (searching for random vals in array)
  | Array Length | Average Binary Search Time | Average Linear Search Time |
  |:------------:|:--------------------------:|:--------------------------:|
  | 1,000        | 0.002ms                    | 0.003ms                    |
  | 10,000       | 0.002ms                    | 0.008ms                    |
  | 100,000      | 0.0ms                      | 0.017ms                    |
  | 1,000,000    | 0.001ms                    | 0.135ms                    |
  | 10,000,000   | 0.003ms                    | 0.948ms                    |
  | 100,000,000  | 0.003ms                    | 9.423ms                    |
  | 1,000,000,000| 0.006ms                    | 90.418ms                   |


## Conclusions
  * With respect to the size of the search array, linear search and binary search initially took similar amounts of time, but as the array size increased, binary search ended     up becoming a much quicker searching algorithm than linear search.
    - The relationship between the time it took linear search to complete and the size of the data set was... well, linear. We saw that as the data set grew, the time for linear search did by the same factor. Ex: if the dataset was 10x larger, it took 10x as long, twice as large, twice as long.
  * The previous conclusion becomes clearer when thinking about the time it takes for each algorithm to run (under worst-case scenario). If we denote the length of the array     to be n, then the most amount of steps it takes for linear search to find an element is n steps. However, binary search can find an element under worst case scenario in       around log (base 2) of n steps. Since logarithmic functions increase much slower than linear functions, as n gets very large, we can see that binary search should             theoretically work much faster than linear search (which is supported by our empirical data).
  * Interestingly, the only real distinctions between these sorting methods (in terms of empirical time to finish) only becomes significant when n is very large, meaning that     the loops that are run for each search method are being performed incredibly fast; this is against the expectation when we think theoretically about the "number of           steps".
  * For instance, in the case of an array of length 1000, the binary search method should complete in 11 steps under worst case scenario, whereas the linear search method         completes in 1000 steps under its own worst case scenario. However, the average times for linear and binary search for an array of length 1000 are about equal, meaning       that the time it takes for each step to run in binary search is much larger than the time it takes for each step to run in linear search.
