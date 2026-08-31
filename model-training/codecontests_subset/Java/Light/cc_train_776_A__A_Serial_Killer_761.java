
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
       Scanner scn = new Scanner(System.in);
       String a = scn.next();
       String b = scn.next();
       int n = scn.nextInt();
       System.out.println(a+ " "+b);
       for(int i=0;i<n;i++){
           String c = scn.next();
           String d = scn.next();
           if(a.equals(c))
               a = d;
           else
              b = d;    
           
           System.out.println(a +" "+b);
       }
    }
}