import java.lang.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String[] args)throws IOException{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	String nst = br.readLine();
	int n = Integer.parseInt(nst);
	int x,cnt=0;
	for(int i=0;i<n;i++){
	    boolean flag = true;
	    nst = br.readLine();
	    x=Integer.parseInt(nst);
	    for(int j=2;j*j<=x;j++)
		if(x%j==0)
		    flag=false;
	    if(flag)
		cnt++;
	}
	System.out.println(cnt);
    }
}