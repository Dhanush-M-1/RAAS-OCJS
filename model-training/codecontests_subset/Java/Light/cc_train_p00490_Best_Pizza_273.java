import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int x,y,z,p,lu,min,minloc;
	x=sc.nextInt();
	y=sc.nextInt();
	z=sc.nextInt();
	p=sc.nextInt();
	int[] ini = new int[x];
	
	for(int i=0; i<x; i++)
	    ini[i]=sc.nextInt();
	
	for(int i=x-1; i>0; i--)
	    for(int j=0; j<i; j++)
		if(ini[j]<ini[j+1]){
		    lu=ini[j];
		    ini[j]=ini[j+1];
		    ini[j+1]=lu;
		}
	lu=p;
	min=lu/y;
	minloc=min;
	for(int i=0; i<x; i++){
	    lu+=ini[i];
	    minloc=lu/(y+(i+1)*z);
	    if(minloc>min)
		min = minloc;
	}
	System.out.println(min);
    }
}