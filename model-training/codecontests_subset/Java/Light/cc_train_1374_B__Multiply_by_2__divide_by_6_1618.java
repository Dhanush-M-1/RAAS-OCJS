import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- != 0){
		    int count = 0;
		    int n = sc.nextInt();
		    if(n == 1){
		        count = 0;
		    }else{
                while(n != 0 && n != 1){
		         if(n % 3 == 0 & n % 2 != 0){
		            n = n*2;
		            n = n/6;
		            count = count + 2;
		         }else if(n % 3 == 0 && n % 2 == 0){
		            n = n/6;
		            count++;
                 }else{
                    count = -1;
                    break;
                 }
		        }
		    }
		    System.out.println(count);
		}
	}
}
