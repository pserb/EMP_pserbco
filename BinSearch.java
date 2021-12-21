/**
   class BinSearch
   Binary search on array of Comparables
**/

public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of 
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch( Comparable[] a, Comparable target)
  { 
    int lo = 0;
    int hi = a.length;
    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while( lo <= hi ) { // run until lo & hi cross

      m = (lo + hi) / 2; //update mid pos var

      // target found
      if ( a[m].compareTo(target) == 0 ) 
        return m;

      // value at mid index higher than target
      else if ( a[m].compareTo(target) > 0 ) 
        hi = m - 1; //move hi to index to left of mid

      // value at mid index lower than target
      else if ( a[m].compareTo(target) < 0 ) 
        lo = m + 1; //move lo to index to right of mid
    }
    return tPos;
  }//end binSearchIter
}//end class BinSearch2
