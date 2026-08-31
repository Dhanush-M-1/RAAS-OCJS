import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] input = new int[5];
        input[0] = scan.nextInt();
        input[1] = scan.nextInt();
        input[2] = scan.nextInt();
        input[3] = scan.nextInt();
        input[4] = scan.nextInt();
        
        int sum = 0;
        for( int coin: input ){
            sum += coin;
        }

        if( sum % 5 != 0 || sum == 0 ){
            System.out.println( -1 );
        }
        else{
            System.out.println( sum / 5 );
        }
	} 
}