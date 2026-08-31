//I AM THE CREED
/* //I AM THE CREED
/* package codechef; // don't place package name! */
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
import java.awt.Point;
public class Main{
    //#include <bits/stdc++. h> 
    public static void main(String[] args) throws IOException 
    { 
  
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int x=input.nextInt();
            int y=input.nextInt();
            String s=input.next();
            int op=0;
            for(int i=n-1;i>=0;i--){
                if(n-i==x+1){
                    break;
                }
                if(n-i==y+1){
                    op+=(s.charAt(i)=='1'?0:1);
                    continue;
                }
                op+=(s.charAt(i)=='1'?1:0);
            }
            System.out.println(op);
        }
    }

}