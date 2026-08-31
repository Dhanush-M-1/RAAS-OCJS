import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
	BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	try{
	    String st; int rec = 0, loz = 0;
	    while((st=sc.readLine())!=null){
		String[] ab = st.split(",");
		int[] a = {Integer.valueOf(ab[0]),Integer.valueOf(ab[1]),Integer.valueOf(ab[2])};
		if((a[0]*a[0]+a[1]*a[1]) == a[2]*a[2])
		    rec++;
		else if(a[0]==a[1])
		    loz++;

	    }
	    System.out.println(rec);
	    System.out.println(loz);
	}catch (Exception e){
	    System.out.println("Error");
	}
    }
}