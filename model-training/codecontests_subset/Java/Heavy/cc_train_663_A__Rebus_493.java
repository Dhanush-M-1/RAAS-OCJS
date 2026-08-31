import java.util.*;
public class rebus {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean num=false;
		String op="";
		int plus=1;
		int minus=0;
		while (!num) {
			String str=sc.next();
			if (str.equals("=")) num=true;
			else if (!str.equals("?")) {
				op=op+str;
				if (str.equals("+")) plus++;
				if (str.equals("-")) minus++;
			}
		}
		int n=sc.nextInt();
		boolean poss=true;
		if (n*plus-minus<n) poss=false;
		if (plus-n*minus>n) poss=false;
		if (!poss) {
			System.out.println("Impossible");
		} else {
			System.out.println("Possible");
			int M=minus;
			int P;
			if (M+n>=plus) P=M+n; 
			else {
				M=n*minus;
				P=M+n;
			}
			int[] pp=dis(P,n,plus);
			int[] mm=dis(M,n,minus);
			int pind=1;
			int qind=0;
			System.out.print(pp[0]+" ");
			while (pind+qind<(plus+minus)) {
				char c=op.charAt(pind+qind-1);
				System.out.print(c+" ");
				if (c=='+') {
					System.out.print(pp[pind]+" ");
					pind++;
				} else {
					System.out.print(mm[qind]+" ");
					qind++;
				}
			}
			System.out.print("= "+n);
		}
		

	}
	
	public static int[] dis(int sum, int n, int num) {
		int[] ret=new int[num];
		for (int i=0; i<num; i++) {
			ret[i]=1;
			sum--;
		}
		int index=0;
		while (sum>0) {
			if (sum>=n-1) {
				ret[index]=n;
				sum-=(n-1);
			} else {
				ret[index]=sum+1;
				sum=0;
			}
			index++;
		}
		return ret;
	}

}
