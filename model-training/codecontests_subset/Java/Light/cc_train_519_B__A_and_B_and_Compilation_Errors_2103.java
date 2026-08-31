
import java.util.Scanner;

public class compilation
{

  public static void main( String[] args )
  {
    Scanner in = new Scanner( System.in );
    long noOfLines = in.nextLong();
    long firstSum = 0l;
    long secondSum = 0l;
    long thirdSum = 0l;

    for( int i = 0; i < noOfLines; i++ ) {
      firstSum += in.nextLong();
    }
    for( int i = 0; i < noOfLines - 1; i++ ) {
      secondSum += in.nextLong();
    }
    long firstDiff = firstSum - secondSum;
    System.out.println( firstDiff );
    for( int i = 0; i < noOfLines - 2; i++ ) {
      thirdSum += in.nextLong();
    }
    System.out.println( secondSum - thirdSum );
  }

}
