/* 
* @Author: steve
* @Date:   2015-03-30 22:14:09
* @Last Modified by:   steve
* @Last Modified time: 2015-03-30 22:40:31
*/
import java.io.*;
import java.util.*;

public class Cola {

	public static void main(String[] args) throws Exception{
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    	String[] cads=entrada.readLine().split(" ");
    	int[] abc=new int[3];
    	for(int i=0;i<3;i++)
    		abc[i]=Integer.parseInt(cads[i+1]);
    	int n=Integer.parseInt(cads[0]),cont=0;
    	for(int a=0;a<=abc[0];a+=2)
    		for(int b=0;b<=abc[1];b++){
    			int c=n-((a/2)+b);
    			if(c<0)
    				break;
    			if(c%2==0 && (c/2)<=abc[2]) cont++;
    		}
    	System.out.println(cont);
    }
}