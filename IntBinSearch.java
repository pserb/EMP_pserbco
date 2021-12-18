/**
   class IntBinSearch
   Binary search on array of ints
**/

public class IntBinSearch
{

  /**
     int binSearch(int[],int) -- searches an array of 
     ints for target int
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( int[] a, int target ) {
    //uncomment exactly 1 of the 2 stmts below:

    return binSearchIter( a, target, 0, a.length-1 );
    //return binSearchRec( a, target, 0, a.length-1 );
  }


  public static int binSearchRec( int[] a, int target, 
                                  int lo, int hi )
  {
    int tPos = -1; //init return var to flag value -1

    int m = (lo + hi) / 2; //init mid pos var

    //exit case. If lo & hi have crossed, target not present
    if (lo > hi)
      return tPos; //-1

    // target found
    if ( a[m] == target ) 
      tPos = m;
    // value at mid index higher than target
    else if ( a[m] > target ) 
      tPos = binSearchRec( a, target, 0, m-1 );
    // value at mid index lower than target
    else if ( a[m] < target ) 
      tPos = binSearchRec( a, target, m+1, hi );

    return tPos;
  }//end binSearchRec


  public static int binSearchIter( int[] a, int target, 
                                   int lo, int hi )
  {
    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while( lo <= hi ) { // run until lo & hi cross

      m = (lo + hi) / 2; //update mid pos var

      // target found
      if ( a[m] == target ) 
        return m;

      // value at mid index higher than target
      else if ( a[m] > target ) 
        hi = m - 1; //move hi to index to left of mid

      // value at mid index lower than target
      else if ( a[m] < target ) 
        lo = m + 1; //move lo to index to right of mid
    }
    return tPos;
  }//end binSearchIter

}//end class IntBinSearch
