//package div2_652;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d {

	public static void main(String[] args) {
		int maxN=(int) 2e+06;
		int modNum=(int) 1e9+7;
		List<Long> arr=new ArrayList<Long>();
		arr.add((long) 0);
		arr.add((long) 0);
		arr.add((long) 0);
		for(int i=3;i<=maxN;i++) {
			long temp=arr.get(i-1)+2*arr.get(i-2)+4*(i%3==0?1:0);
			temp%=modNum;
			arr.add(temp);
		}
		
		int t, n;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		for (int i = 0; i < t; i++) {
			n = in.nextInt();
			System.out.println(arr.get(n));
		}
		in.close();
	}
	

}
