import java.util.*;
import java.io.*;


 public class Param
{
                
      public static  void main( String[]args) 
    {
     Scanner param=new Scanner(System.in);
     int size=param.nextInt();
     param.nextLine();
     String a =param.next();
     char []arr=new char [size];
     for(int i=0;i<size;i++){
        arr[i]=a.charAt(i);
     }
     int count=0;
      for(int i=0;i<arr.length;i++){
         if(arr[i]=='8'){
            count++;
         }
      }
      if(size/11<=count){
      System.out.println((size/11));
    }
    else if(count<=size/11){
        System.out.println(count);
    }
    else {
       System.out.println(0);
    }
}
}   
       
     
     