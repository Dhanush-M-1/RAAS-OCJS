/* 
* @Author: steve
* @Date:   2015-05-13 21:41:50
* @Last Modified by:   steve
* @Last Modified time: 2015-05-13 21:48:56
*/
import java.io.*;
import java.util.*;

public class ChatServerOutgoingTraffic {
    public static void main(String[] args) throws Exception{
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    	String str="";
    	int cont=0;
    	HashSet<String> mapa = new HashSet<String>();
    	while((str=entrada.readLine())!=null){
    		if(str.charAt(0)=='-'){
    			mapa.remove(str.substring(1));
    		}else if(str.charAt(0)=='+'){
    			mapa.add(str.substring(1));
    		}else{
    			String[] cads=str.split(":");
    			if(cads.length>1) cont+=cads[1].length()*mapa.size();
    		}
    	}
    	System.out.println(cont);
    }
}