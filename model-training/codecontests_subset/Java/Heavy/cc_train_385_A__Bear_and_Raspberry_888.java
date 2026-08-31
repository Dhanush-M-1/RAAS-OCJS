/**
 * @(#)bear.java
 *
 *
 * @author
 * @version 1.00 2015/11/28
 */

import java.io.*;
import java.util.*;

public class bear {

    public static void main(String[]args)throws java.lang.Exception{
     BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st= new StringTokenizer(bf.readLine());
     int n = Integer.parseInt(st.nextToken());
     int max = 0;
     int c = Integer.parseInt(st.nextToken());
     st= new StringTokenizer(bf.readLine());
     int x1= Integer.parseInt(st.nextToken());
     for(int i = 1; i<n;i++){
     	int x2=  Integer.parseInt(st.nextToken());
     	if(x2<= x1){
     		max = Math.max(max,x1-(c+x2));
     	}
     	x1 = x2;
     }
     System.out.println(max);
    }

}