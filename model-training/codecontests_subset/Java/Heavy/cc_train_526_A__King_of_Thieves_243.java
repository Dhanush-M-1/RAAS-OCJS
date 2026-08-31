import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class a {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.nextInt();
        String s1=s.next();
        int n=0;
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)=='*')
                n++;
       if(n==0)
          System.out.println("no");
       else{ 
        int a[]=new int[n];
        int j=0;
        for(int i=0;i<s1.length();i++)
           if(s1.charAt(i)=='*')
              a[j++]=i+1; 
        int count1=1;
        int count2=a[n-1]-a[0];
        int flag=0;
        while(count1<=count2){
           for(int i=0;i<n;i++)
              if(f(0,n-1,a,a[i]+1*count1)&&f(0,n-1,a,a[i]+2*count1)&&f(0,n-1,a,a[i]+3*count1)&&f(0,n-1,a,a[i]+4*count1)){
                  flag=1;
                  break;
              } 
            count1++;
        }
        if(flag==0)
           System.out.println("no");
        else
           System.out.println("yes"); 
        
    }
    }
    public static boolean f(int first, int last, int array[], int search){
    int middle = (first + last)/2;
 
    while( first <= last )
    {
      if ( array[middle] < search )
        first = middle + 1;    
      else if ( array[middle] == search ) 
      {
          return true;
      }
      else
         last = middle - 1;
 
      middle = (first + last)/2;
   }
   return false;
    }
}

