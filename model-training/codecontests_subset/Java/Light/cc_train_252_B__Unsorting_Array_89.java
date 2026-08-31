import	java.util.*;
public	class	Main{
	static	int	fdEP(int[]Q,int	n){
		if(3>n||3==n&&Q[0]==Q[2])	return	0;
		int	m=n;
		while(0<--m&&Q[m-1]==Q[m]);
		if(n-1>m)	return m;
		if(Q[m]>Q[m-1]){
			if(Q[m]==Q[m-2])	return Q[m-2]>Q[m-3]?m:m-1;
			return Q[m]>Q[m-2]?m:m-1;
		}
		if(Q[m]==Q[m-2])	return Q[m-2]<Q[m-3]?m:m-1;
		return Q[m]<Q[m-2]?m:m-1;
	}
	public	static	void	main(String[]args){
		Scanner	cin=new	Scanner(System.in);
		for(int	n,m,Q[]=new	int[100000];cin.hasNextInt();){
			for(n=cin.nextInt(),m=0;n>m;Q[m++]=cin.nextInt());
			if(0<(m=fdEP(Q,n)))	System.out.println(m+" "+(1+m));
			else	System.out.println(-1);
		}
	}
}
