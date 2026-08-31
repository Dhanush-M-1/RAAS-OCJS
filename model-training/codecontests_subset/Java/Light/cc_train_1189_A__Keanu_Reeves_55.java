/*package whatever //do not write package name here */

import java.util.*;

public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		int i,pos=-1, one=0, ze=0;
		for(i=0;i<n;i++){
		    if(s.charAt(i)=='0'){
		        ze+=1;
		    }
		    else{
		        one+=1;
		    }
		    if(one!=ze){
		        pos=i;
		    }
		}
		if(s.length()==1){
		    System.out.println('1');
		    System.out.println(s);
		}
		else{
		    if(pos==s.length()-1){
		        System.out.println("1");
		        System.out.println(s);
		    }
		    else{
		    System.out.println("2");
		    System.out.println(s.substring(0,pos+1)+" "+s.substring(pos+1, s.length()));
		}
		}
	}
}