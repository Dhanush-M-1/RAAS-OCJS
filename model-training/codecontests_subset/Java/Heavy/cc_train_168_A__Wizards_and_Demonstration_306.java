import java.util.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class  test  {
	
	//ArrayList<Integer> lis = new ArrayList<Integer>();
	//ArrayList<String> lis = new ArrayList<String>();
	//ArrayList<test> lis = new ArrayList<test>();
//	static long sum=0;
	
public  static void main(String[] args) {
   Scanner sc =new Scanner(System.in);
   
   
   while(sc.hasNext()){
	 // double sum=0;
		 // =ni(sc)
		int n=ni(sc),x=ni(sc),y=ni(sc);
	  double p= (double)n*(double)y/100; 
		int d=(int)p;
		//db(p,d);
		if( 0<p-d )d++;

		if( d<x )System.out.println(0);
		else System.out.println((int)(d-x));
	
}

}



    static int ni(Scanner in){
	return in.nextInt();  
 }


    static void db(Object... os){
	         System.err.println(Arrays.deepToString(os));
 
	}

}

class pr implements Comparable<pr>{
    int v,vv;
	pr(int v,int vv){
		this.v=v; 
	    this.vv=vv;
	} 
  
public int compareTo(pr x){
	
	if( v==x.v )return vv-x.vv;
	return -v+x.v;
}

}

