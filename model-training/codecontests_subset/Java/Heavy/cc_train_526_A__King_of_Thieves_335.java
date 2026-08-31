/* 
* @Author: steve
* @Date:   2015-05-26 23:31:26
* @Last Modified by:   steve
* @Last Modified time: 2015-05-26 23:45:23
*/
import java.io.*;

public class KingofThieves {
    public static void main(String[] args) throws Exception{
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(entrada.readLine());
    	String cad = entrada.readLine();
    	boolean esta=false;
    	for(int i=1;i<=(n/4)+2;i++){
    		for(int k=0;k<=i;k++){
    			int cont=0;
    			for(int j=k;j<n;j+=i)
    				if(cad.charAt(j)=='*')
    					cont++;
    				else if(cont<5)
    					cont=0;
    			if(cont>=5) esta=true;
    		}
    	}
    	System.out.println((esta)?"YES":"NO");
    }
}