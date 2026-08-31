
		import java.io.*;
		import java.util.*;
		public class Sample {
		    static int MAX = (int)1e6+1;
		    static int MOD=(int)1e9+7; 
		    static int countt = 0;
			public static void main(String[] args) throws Exception{
				// TODO Auto-generated method stub
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Scanner input  = new Scanner(System.in);
				int a = input.nextInt();
				int b = input.nextInt();
				int count1[] = new int[3];
				int count2[] = new int[3];
				while(a%2 == 0) {a/=2;count1[0]++;}
				while(a%3 == 0) {a/=3;count1[1]++;}
				while(a%5 == 0) {a/=5;count1[2]++;}
				while(b%2 == 0) {b/=2;count2[0]++;}
				while(b%3 == 0) {b/=3;count2[1]++;}
				while(b%5 == 0) {b/=5;count2[2]++;}
				if(a == b) {
					int count =0;
					for(int i =0;i<3;i++) {count+=Math.abs(count1[i]-count2[i]);}
					System.out.println(count);
				}else System.out.println(-1);
			}
		}

