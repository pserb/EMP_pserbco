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


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Object[] arr )
  {
    String output = "[ ";

    for( Object o : arr )
      output += o + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }


  //main method for testing
  public static void main ( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing linSearch on int array...");

    //Declare an array of Comparables and initialize it using ints
    //   Each int will be autoboxed to class Integer,
    //   which implements Comparable.
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );

    //search for 6 in array 
    System.out.println( linSearch(iArr,6) );

    //search for 43 in array 
    System.out.println( linSearch(iArr,43) );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    System.out.println("\nNow testing linSearch on Comparable arrays...");


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing linSearch on String array...");

    //declare and initialize an array of Strings
    String[] sArr = { "kiwi", "watermelon", "orange", "apple", 
                      "peach", "watermelon" };
    printArray( sArr );

    //search for "watermelon" in array
    System.out.println( linSearch(sArr,"watermelon") );

    //search for "lychee" in array
    System.out.println( linSearch(sArr,"lychee") );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*----------------------------------------------------
      ----------------------------------------------------*/

  }//end main()

}//end class LinSearch
