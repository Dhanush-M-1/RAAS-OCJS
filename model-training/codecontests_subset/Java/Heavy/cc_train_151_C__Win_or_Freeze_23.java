import java.util.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class  test  {
	String name;
	int tax,piz,gir;
	
	//ArrayList<Integer> lis = new ArrayList<Integer>();
	//ArrayList<String> lis = new ArrayList<String>();
	//ArrayList<test> lis = new ArrayList<test>();
	static int sum=0;
	
public  static void main(String[] args) {
   Scanner sc =new Scanner(System.in);
   
   
   while(sc.hasNext()){
	   sum=0;
	 
	   
	 long n=sc.nextLong(),an=fun(n);

	 if( 0<=an ){
	  System.out.println(1);
	 System.out.println(an);
   }
	 
   else  System.out.println(2);


}
   }

  static long fun(long x){
	  int s=0;
	  long ss=1,c=x;
	  
	  for(long i=2; i*i<=x ;i++){
		 

			 while(x%i==0){
				 s++;
				 ss*=i;
				
				 if(s==2){
					 
				if(c/ss!=1)return ss;	
				else return -1;	 
				
				 }
				 x/=i;
			 }
			 
	  }
	if(s ==1){  
	  for(long i=2; i*i<=x ;i++){
	  
		  if(x%i==0){
			  return ss*i;
			  
		  }
		  
	  }
	  return -1;
	}
	  return 0;

	  
  }

    static int ni(Scanner in){
	return in.nextInt();  
 }


    static void db(Object... os){
	         System.err.println(Arrays.deepToString(os));
 
	}

}
