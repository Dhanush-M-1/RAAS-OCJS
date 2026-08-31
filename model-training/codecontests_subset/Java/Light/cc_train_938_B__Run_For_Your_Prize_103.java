import java.util.*;
import java.lang.*;
import java.math.*;
public class runforprize{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
       int i,j, n=sc.nextInt();
	   int a,sec=0;
	   int x=1,y=1000000;
	 //  int a[]=new int[n];
	  for(i=0;i<n;i++){
		  a=sc.nextInt();
		  if(a<=(1000000/2)){
			  sec=Math.max(sec,a-1);
		  }
		  if(a>(1000000/2)){
			  sec=Math.max(sec,1000000-a);
		  }
	  }
System.out.println(sec);
}
}
