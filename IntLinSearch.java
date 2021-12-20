/**
   class IntLinSearch
**/

public class IntLinSearch
{

  /**
     int linSearch(int[],int) -- searches an array of 
     ints for target
     post: returns index of first occurrence of target, or
     returns -1 if target not found
  **/
  public static int linSearch ( int[] a, int target )
  {
    int tPos = -1;
    int i = 0;

    while ( i < a.length ) {
      if ( a[i] == target ) {
        tPos = i;
        break;
      }
      i++;
    }
    return tPos;
  }
  
}//end class LinSearch
