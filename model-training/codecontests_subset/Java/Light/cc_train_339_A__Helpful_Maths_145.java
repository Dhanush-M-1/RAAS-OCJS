import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String a[]=new String[100];
        a=s.split("\\+");
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            if(i==(a.length-1))
                System.out.print(a[i]);
            else
                System.out.print(a[i]+"+");
        }
    }
}