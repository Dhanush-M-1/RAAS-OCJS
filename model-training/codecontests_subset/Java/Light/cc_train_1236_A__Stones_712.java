import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class forces{
    public static void main(String args[])throws IOException{
        DataInputStream ins=new DataInputStream(System.in);
		int t=Integer.parseInt(ins.readLine());
		for(int k=0;k<t;k++){
			String s[]=ins.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			int show=0;
			while(b>0 && c>1){
				show+=3;
				b--;
				c--;
				c--;
			}
			while(a>0 && b>1){
				show+=3;
				a--;
				b--;
				b--;
			}
			System.out.println(show);
		}
	}		
}
	

