import java.io.*;
import java.util.*;

// ??????????????????f??¨????????¨f(N)<N ????????§?????????????????????????????¨????????????

public class Main{
    public static void main(String args[]) throws Exception{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	int Q= Integer.parseInt( br.readLine() );
    	for(int i=0;i<Q;i++){
    		String strN= br.readLine();
    		int cnt=0;
    		while( strN.length() > 1 ){
    			int max= 0;
        		for(int j=1; j<strN.length(); j++){
        			int n1= Integer.parseInt(strN.substring(0,j));
        			int n2= Integer.parseInt(strN.substring(j));
        			if( max< n1*n2 ){ max= n1*n2; }
        		}
        		strN= String.valueOf(max);
        		cnt++;
    		}
    		System.out.println(cnt);
    	}
    }
}