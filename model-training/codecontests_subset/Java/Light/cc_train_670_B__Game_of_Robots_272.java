import java.util.*;
import java.io.*;
 import javafx.util.Pair; 
 
 public class Param
{
          
      public static  void main( String[]args) 
    {
       
      Scanner param=new Scanner(System.in);
    int s=param.nextInt();
    int m=param.nextInt();
   
    int arr[]=new int[s];
    for(int i=0;i<s;i++){
    arr[i]=param.nextInt();
    }
    for(int i=0;i<s;i++){
       if(m-(i+1)>0){
          m=m-(i+1);
          continue;
       }
       else{
          System.out.println(arr[m-1]);
          return ;
       }
    }
     
}
}