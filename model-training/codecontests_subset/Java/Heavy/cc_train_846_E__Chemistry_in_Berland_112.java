import java.util.*;

import java.math.BigInteger;



public class Main {



	public static void main(String[] args) {

		int NN=100100;

		BigInteger a[]=new BigInteger[NN];

		BigInteger b[]=new BigInteger[NN];

		BigInteger k[]=new BigInteger[NN];

		int fa[]=new int[NN];

		

		int n;

		Scanner in=new Scanner(System.in);

		n=in.nextInt();

		

		for(int i=1; i<=n; i++) b[i]=in.nextBigInteger();

		for(int i=1; i<=n; i++) a[i]=in.nextBigInteger();

		for(int i=2; i<=n; i++){

			fa[i]=in.nextInt();

			k[i]=in.nextBigInteger();

		}

		

		BigInteger _inf=BigInteger.TEN.pow(50);

		_inf=BigInteger.ZERO.subtract(_inf);

		

		boolean ok=true;

		for(int i=n; ok && i>=1; i--){

			b[i]=b[i].subtract(a[i]);

			if(i>1){

				if(b[i].compareTo(BigInteger.ZERO)>0) b[fa[i]]=b[fa[i]].add(b[i]);

				else b[fa[i]]=b[fa[i]].add(b[i].multiply(k[i]));

				if(b[fa[i]].compareTo(_inf)<0) ok=false;

			}

		}

		

		if(ok && b[1].compareTo(BigInteger.ZERO)>=0) System.out.println("YES");

		else System.out.println("NO");

	}

}


                 