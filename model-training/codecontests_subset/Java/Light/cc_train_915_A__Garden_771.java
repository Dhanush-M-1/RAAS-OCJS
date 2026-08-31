
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String args[])
    {
       int numBuckets, length;
       Scanner sc = new Scanner(System.in);
       numBuckets = sc.nextInt();
       length = sc.nextInt();
       int min = Integer.MAX_VALUE;
       int pani = 0;
       for(int i=0;i<numBuckets;i++)
       {
       pani = sc.nextInt();
       if(length%pani!=0)
           continue;
       else
       {
           if((length/pani)<min)
               min = length/pani;
       }
       }
        System.out.println(min);
        
    }
}
