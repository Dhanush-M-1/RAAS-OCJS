import java.io.*;
import java.util.*;

public class Main {
	
	static char[] alpha = "abcdefghij".toCharArray();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int k = scan.nextInt();
		
		Set<StringValue> pre = new LinkedHashSet<>();
		Set<StringValue> now;
		pre.add(new StringValue("a", 1));
		
		for(int i = 2;i <= k;i ++) {
			now = new LinkedHashSet<>();
			for(StringValue s : pre) {
				for(int n = 0;n < s.num;n ++) {
					now.add(new StringValue(s.str + alpha[n], s.num));
				}
				now.add(new StringValue(s.str + alpha[s.num], s.num + 1));
			}
			pre = now;
		}
		for(StringValue value : pre) {
			System.out.println(value.str);
		}
	}
}

class StringValue{
	
	 String str;
	 int num;
	 
	 public StringValue(String text, int num) {
		 this.str = text;
		 this.num = num;
	 }
}