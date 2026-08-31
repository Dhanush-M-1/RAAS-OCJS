import java.io.*;
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
     Scanner sc=new Scanner(System.in);
     int t=sc.nextInt();
     while(t-->0){
          int n=sc.nextInt();
          int c=0;
        //   Set<Integer> set=new HashSet<>();
          boolean isfound=true;
          while(n!=1){
          if(n%6==0){
              n=n/6;
              c+=1;
          }
          else if(2*n%6==0 && n%3==0){
              n=n*2;
              c+=1;
          }
         else{
             isfound=false;
             break;
         }
          }
          if(isfound){
              System.out.println(c);
          }
          else{
               System.out.println(-1);
          }
          
          
           
     }
     
    }
}