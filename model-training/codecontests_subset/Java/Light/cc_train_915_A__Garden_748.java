import java.util.*;
import java.io.*;
import java.math.*;


public class scorify{
	public static void main(String[] args){
	Scanner in=new Scanner(System.in);
    int n = in.nextInt(),min,seconds;
    int len = in.nextInt();
    int[] arr = new int[n];
    TreeSet<Integer> set = new TreeSet<Integer>();
    
    for (int i =0; i<n ; i++){
        min = 0;
        seconds =0;
        arr[i]=in.nextInt();
        while(min != len){
            min += arr[i];
            seconds++;
            if(min>len){seconds+=1000;break;}
        }
        set.add(seconds);
    }
    System.out.println(set.first());
	
	
	}
}
