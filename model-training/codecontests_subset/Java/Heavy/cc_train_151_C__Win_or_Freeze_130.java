import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.io.*; 
public class Main { 
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    { 
       	long n=sc.nextLong(),m,ff=1,nf=0;
	outer: for(int i=2;i<=(long)Math.sqrt(n);i++){
		if(n%i==0){
			m=n;
			while(m%i==0){
				if(nf==2)	break outer;
				nf+=1;
				ff*=i;
				m=m/i;
			}
		}
		
		
	}
	if((nf==1 || ff==n) && n!=1)	System.out.println("2");
	else if(n==1 || nf==0)	System.out.println("1\n0");
	else{
		System.out.println("1\n"+ff);
	}
    } 
} 