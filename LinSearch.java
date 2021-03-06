// PSerb & Co. Paul Serbanescu, Andrew Piatetsky, Joseph Othman
// APCS pd7
// L03 - Get Empirical
// 2021-12-21
// time spent: 0.1 hrs

/**
   class LinSearch
**/

public class LinSearch
{

  /**
     int linSearch(Comparable[],Comparable) -- searches an array of 
     Comparables for target
     post: returns index of first occurrence of target, or
     returns -1 if target not found
  **/
  public static int linSearch ( Comparable[] a, Comparable target )
  {
    int tPos = -1;
    int i = 0;

    while ( i < a.length ) {
      if ( a[i].equals(target) ) {
        tPos = i;
        break;
      }
      i++;
    }
    return tPos;
  }
}//end class LinSearch
