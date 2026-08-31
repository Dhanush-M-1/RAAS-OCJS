import java.util.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = 0;
        String a;
        int[][] card = new int[4][13];
        String[] mark = {"S","H","C","D"};
        for(int i = 0; i < n; i++){ 
        a = sc.next();
        b = sc.nextInt();
       for(int c=0; c<4; c++){
          if(mark[c].equals(a)){
              card[c][b-1]++;
            }
          }
        }
        for(int d = 0; d < 4; d++){
        	for(int c = 0; c < 13; c++){
	        	if( card[d][c] == 0){
	        	    System.out.println(mark[d] +" "+ (c+1)); 
	        	} 
          	}
        }
   }
}

