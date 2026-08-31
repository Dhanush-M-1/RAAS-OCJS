import java.util.*;
import java.math.*;
import java.awt.geom.*;
import java.io.*;
      
      
public class Main {
	static HashMap<String,Boolean> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		for(int i = 0; i < Q; i++) {
			String in = sc.next();
			map = new HashMap<String,Boolean>();
			int count = 0;
			while(in.length() != 1) {
				if(map.containsKey(in)) {
					count = -1;
					break;
				}
				map.put(in, true);
				
				count++;
				BigInteger Max = new BigInteger("0");
				for(int j = 1; j < in.length(); j++) {
					BigInteger A = new BigInteger(in.substring(0,j));
					BigInteger B = new BigInteger(in.substring(j));
					BigInteger C = A.multiply(B);
					if(Max.compareTo(C) == -1) Max = C;
				}
				in = Max.toString(10);
			}
			System.out.println(count);
			
		}
		
	}
 }