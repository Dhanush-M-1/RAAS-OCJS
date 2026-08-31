import java.io.*;
import java.util.*;
import java.math.*;

public class codeForceTwoSevenThree {
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		A();
		//B();
		//C();
	}

	public static int fac(int n) {
		if(n==0)
			return 1;
		else 
			return n*fac(n-1);
	}

	public static int comb(int a, int b) {
		return fac(a)/fac(b)/fac(a-b);
	}
	public static void B() {
		String s1=input.nextLine();
		String s2=input.nextLine();
		int a=0;
		int b=0;
		int numOfQ=0;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i)=='+')
				a++;
			else
				a--;
		}
		for(int i=0; i<s2.length(); i++) {
			if(s2.charAt(i)=='+')
				b++;
			else if(s2.charAt(i)=='-')
				b--;
			else //?
				numOfQ++;
		}
		if(numOfQ==0) {
			if(a==b)
				System.out.printf("%.11f\n",1.0);
			else
				System.out.printf("%.11f\n",0.0);
		} else {
			int step=a-b;
			int []value=new int[numOfQ+1];
			int []comb=new int[numOfQ+1];
			value[0]=-1*numOfQ;
			for(int i=1; i<numOfQ+1; i++) {
				value[i]=value[i-1]+2;
			}
			//System.out.printf("%s",Arrays.toString(value));
			for(int i=0; i<numOfQ+1; i++) {
				comb[i]=comb(numOfQ,i);
			}

			//System.out.printf("%s",Arrays.toString(comb));
			int i;
			for(i=0; i<numOfQ+1; i++) {
				if(step==value[i]) {
					System.out.printf("%.11f\n",comb[i]/Math.pow(2,numOfQ));
					break;
				}
			}
			if(i==numOfQ+1)
				System.out.printf("%.11f\n",0.0);
		}

	}
	public static void C(){
		BigDecimal a=input.nextBigDecimal();
		BigDecimal b=input.nextBigDecimal();
		BigDecimal total=BigDecimal.ZERO;
		for(BigDecimal i=b; i.compareTo(a)<=0; i=i.add(BigDecimal.ONE)) {
			System.out.printf("%d div %d mod %d\n",i.intValue(),i.divide(b).intValue(),i.remainder(b).intValue());	
			if(i.remainder(b).compareTo(BigDecimal.ZERO)!=0 &&  i.divide(b).divide(i.remainder(b)).stripTrailingZeros().scale()<=0) {
				total=total.add(i);	
				System.out.printf("%d",total.intValue());	
			}
		}
		System.out.printf("%d\n",total.remainder(new BigDecimal(1000000007)).intValue());
	}
	public static void A(){
		int sum=0;
		for(int i=0; i<5; i++) {
			sum+=input.nextInt();
		}
		if(sum%5==0 && sum!=0) {
			System.out.printf("%d\n",sum/5);
		} else {
			System.out.printf("%d\n",-1);
		}
	}

}

