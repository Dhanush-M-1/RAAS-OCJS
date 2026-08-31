import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        int vo=sc.nextInt();
        int v1=sc.nextInt();
        int a=sc.nextInt();
        int l=sc.nextInt();
        int read=0;
        int acc=a;
        for(int i=1;;i++){
        	if(vo>v1){
        		vo=v1;
        	}
        	read+=vo;
        		vo+=a;
        		
        if(read>=c){
        	System.out.println(i);
        	return;
        }
        read-=l;
        }
        	
        
    }
}