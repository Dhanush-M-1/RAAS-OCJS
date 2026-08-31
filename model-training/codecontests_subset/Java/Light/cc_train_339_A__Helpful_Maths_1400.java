import java.util.*;

import java.lang.*;
public class Main {

    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n,k,i,l=0,j;
        int a[]=new int[100];
        String s = scan.nextLine();
        for(i=0,j=0;i<s.length();i+=2){
            a[j++]=s.charAt(i)-'0';
            
        }
        //System.out.println(""+j);
        Arrays.sort(a, 0, j);
        for(i=0;i<j;i++){
            if(i<j-1)
                System.out.print(""+a[i]+'+');
            else
                System.out.println(""+a[i]);
        }    
    }   
}
