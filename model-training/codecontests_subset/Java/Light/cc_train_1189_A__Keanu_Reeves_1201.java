import java.util.*;
import java.io.*;


 public class Param
{
          
      public static  void main( String[]args) 
    {
  	Scanner param=new Scanner (System.in); 
  	int end=param.nextInt();
  	String a=param.next();
  	
  	char arr[]=new char[end];
  	for(int i=0;i<end;i++){
  	   arr[i]=a.charAt(i);
  	}
  	int count=0;
  	int check=0;
  	ArrayList<Character>l1=new ArrayList<Character>();
  for(int i=0;i<arr.length;i++){
     if(arr[i]=='1'){
        count++;
     }
     else{
        check++;
     }
  }
  String r="";
  if(count!=check){
     System.out.println(1);
     System.out.println(a);
  }
  else{
     for(int i=0;i<arr.length-1;i++){
        r+=arr[i];
     }
    if(a.length()==1){
  	   System.out.println(1);
  	}
  	else{
  	   System.out.println(2);
  	}
     System.out.print(r+" ");
     System.out.println(arr[end-1]);
  }
  	
}
}