
import java.util.*;
import java.io.*;

public class CF3 {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[] = in.readLine().split(" ");
		Integer n = Integer.parseInt(s[0]);
		Integer k = Integer.parseInt(s[1]);
		s = in.readLine().split(" ");
		if (k==1) {System.out.println(s[0]);return;}
		Integer count=0,last=0,start=0;
		for(Integer i =1 ; i<=n; i++){
			start=last+1;
			last+=i;
			if (last>=k){
				
					System.out.println(s[k-start]);
					break;

			}
		}
	}
}