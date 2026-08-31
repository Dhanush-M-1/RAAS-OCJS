import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int[] arr = new int[100];
        int max=0,index=1;
        
        for(int i=1 ;i<l ;i++){
            for(int j=i+1 ;j<l ;j++){
                if(s.charAt(i)==s.charAt(j) && s.charAt(i-1)==s.charAt(j-1)) arr[i]++;
            }
            if(max<arr[i]) {max=arr[i];index=i;}
        }

        System.out.println(s.charAt(index-1)+""+s.charAt(index));
    }
}