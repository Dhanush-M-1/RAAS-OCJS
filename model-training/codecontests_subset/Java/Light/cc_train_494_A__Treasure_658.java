import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class a {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1=s.next();
        int count1=0;
        int count2=0;
        int count3=0,flag=0,v=0;
        for(int i=0;i<s1.length();i++){
           if(s1.charAt(i)=='(')
             count1++;
            else{
              if(s1.charAt(i)=='#'){
                 count3++;
                 v=i;
              }
                count2++;
            }
           if(count2>count1){
              flag=1;
               break;
           } 
        }
        int count11=0;
        int count21=0;
        int j=v+1;
        while(j<s1.length()){
          if(s1.charAt(j)!=')')
              break;
            j++;
        }
        
        for(int i=j;i<s1.length();i++){
           if(s1.charAt(i)=='(')
             count11++;
            else{
              if(s1.charAt(i)=='#'){
                 count3++;
                 v=i;
              }
                count21++;
            }
           
        }
        if(count11>count21)
           flag=1; 
        if(flag==1)
           System.out.println("-1");
        else{
            for(int i=0;i<count3-1;i++)
              System.out.println("1");
            System.out.println((count1-count2+1));
        }
    }
}

