import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main{ 
    
    public static void main(String[] args)throws IOException{
	try{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String line;
	 int tyo=0;int hisi=0;

	while((line=br.readLine())!=null){
	    StringTokenizer st =new StringTokenizer(line,",");
	    int a=Integer.parseInt(st.nextToken());
	    int b=Integer.parseInt(st.nextToken());
	    int x=Integer.parseInt(st.nextToken());
	   	    if((a*a+b*b)==x*x&&a!=b)
		tyo++;
	    else
	    if(a==b&&(a+b)>x)
		hisi++;
	}
	System.out.println(tyo);
	System.out.println(hisi);
	}catch(java.lang.NumberFormatException e){
	    System.out.println(e);
	}
    }
}