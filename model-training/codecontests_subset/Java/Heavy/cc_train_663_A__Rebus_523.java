//package GeneralProblems;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class rebus {
	static String cur[];
	static int [] ans;
	static int n;

public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	cur=sc.nextLine().split(" ");
	 n = Integer.parseInt(cur[cur.length-1]);
	int sub = 0;
	int add = 0;
	
	for (int i = 0; i < cur.length-2; i++) {
		if(cur[i].equals("+"))
			add++;
		else if(cur[i].equals("-"))
			sub++;
	}
	if((add+1)*n<(sub+n)||((add+1)>n&&sub==0)||(add+1)>(sub+1)*n) {
		out.println("Impossible");
	}else {
		int [] pos =new int[add+1];
		int [] neg = new int[sub];
		Arrays.fill(neg, 1);
		if(add+1>=sub+n) {
			Arrays.fill(pos,1);
			int leftOver = add+1-(sub+n);
//			System.out.println(add+1+" "+(sub+n) );
			for (int i = 0; i < neg.length; i++) {
//				System.out.println(leftOver+" "+i);
				if(leftOver+1>=n) {
					neg[i]=n;
					leftOver-=(n-1);
				}else {
					neg[i]=leftOver+1;
					leftOver=0;
				}
				if(leftOver<=0)
					break;
			}
		}
		else {
	
		add = sub+n;
//		System.out.println(add);
//		pos[0]=n;
		for (int i = 0; i < pos.length; i++) {
			pos[i]=1;
			add--;
		}
//		System.out.println(Arrays.toString(pos));
		for (int i = 0; i < pos.length; i++) {
			if(add+1>=n) {
				pos[i]=n;
				add-=(n-1);
			}else {
				pos[i]=add+1;
				add=0;
			}
//			pos[i]=Math.min(add+1,n);
//			add-=n;
			if(add<=0)
				break;
		}
		}
		int oper= 0;
		int idx1 = 0,idx2 = 0;
		for (int i = 0; i < cur.length-2; i++) {
			if(cur[i].equals("?")) {
				if(oper==1||oper==0) {
					cur[i]=pos[idx1++]+"";
				}else
					cur[i]=neg[idx2++]+"";
			}else if(cur[i].equals("+")) {
				oper =1;
			}else oper = 2;
		}
		out.println("Possible");
		for (int i = 0; i < cur.length; i++) {
			out.print(cur[i]+" ");
		}
	}
	out.flush();
	out.close();
	}
	

}
