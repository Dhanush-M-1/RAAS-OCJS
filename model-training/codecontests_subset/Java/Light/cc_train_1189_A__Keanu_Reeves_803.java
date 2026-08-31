import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class forces{
    public static void main(String args[])throws IOException{
        DataInputStream ins=new DataInputStream(System.in);
		int t=Integer.parseInt(ins.readLine());
		String x=ins.readLine();
		String s[]=x.split("");
		int o=0,z=0;
		for(int i=0;i<t;i++){
			if(s[i].equals("1")){
				o++;
			}
			else{
				z++;
			}
		}
		
		if(z==o){
			System.out.println("2");
			System.out.println(x.substring(0, t-1)+" "+x.substring(t-1, t));
		}
		else{
			System.out.println("1");
			System.out.println(x);
		}
	}
}
	
/*



*/

