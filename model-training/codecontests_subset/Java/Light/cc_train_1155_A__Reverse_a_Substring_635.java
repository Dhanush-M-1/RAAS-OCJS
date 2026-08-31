import java.util.*;
import java.io.*;


 public class Param
{
          
      public static  void main( String[]args) 
    {
    Scanner param = new Scanner(System.in);
   int n=param.nextInt();
   param.nextLine();
   String s=param.next();
   boolean flag=true;
   int b=0;
   int k=0;
  for(int i=0;i<n-1;i++){
     if((int)s.charAt(i)>(int)s.charAt(i+1)){
        b=i+1;
        k=i+2;
        flag=false;
        break;
     }
  }
      if(flag==false){
         System.out.println("YES");
          System.out.print(b+" ");
           System.out.print(k+" ");
         
      }
      else{
          System.out.print("NO");
      }
   
}
}   


