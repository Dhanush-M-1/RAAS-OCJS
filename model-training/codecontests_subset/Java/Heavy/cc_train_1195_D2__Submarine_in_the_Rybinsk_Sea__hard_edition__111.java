import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		long n=scanner.nextLong();
		Map<Integer, Integer> maps=new HashMap<Integer, Integer>();
		List<String> arrays=new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			arrays.add(String.valueOf(scanner.nextLong()));
			int tmp=maps.get(arrays.get(i).length())==null?0:maps.get(arrays.get(i).length());
			maps.put(arrays.get(i).length(), tmp+1);
		}
		BigInteger sum=new BigInteger("0");
		StringBuffer buffer=new StringBuffer();
		BigInteger modBigInteger=new BigInteger("998244353");
		BigInteger bigInteger;
		for (String string: arrays) {
			int len=string.length();
			for (int v: maps.keySet()) {
				for (int i = 0; i < len; i++) {
					buffer.append(string.charAt(i));
					if (i>=len-v) {
						buffer.append('0');
					}
				}
				bigInteger=new BigInteger(buffer.toString());
				sum=sum.add(bigInteger.multiply(new BigInteger(String.valueOf(maps.get(v)))));
				buffer.deleteCharAt(buffer.length()-1);
				if (v<len) {
					buffer.insert(len-v, '0');
				}
				bigInteger=new BigInteger(buffer.toString());
				sum=sum.add(bigInteger.multiply(new BigInteger(String.valueOf(maps.get(v)))));
				buffer.delete(0, buffer.length());
			}
		}
		System.out.println(sum.remainder(modBigInteger).longValue());
		scanner.close();
		
	}
}