

import  java.util.*;
import java.io.*;

public class Life {
    public static void main(String[] args) throws java.lang.Exception{
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[] arr=new int[s.length()/2+1];int c=0;
        for(int i=0; i<s.length(); i+=2){
            arr[c++]=Character.getNumericValue(s.charAt(i));
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(i<arr.length-1) System.out.print(arr[i]+"+");
            else System.out.print(arr[i]);
        }
    }
}