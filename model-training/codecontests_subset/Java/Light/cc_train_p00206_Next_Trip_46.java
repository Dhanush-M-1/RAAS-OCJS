import java.util.Scanner;
class Main{
	static Scanner sc;
	static int i,L,M,N,T,mth;
	
	public static void main(String[]args){
		sc=new Scanner(System.in);
		L=sc.nextInt();
		while(L>0){
			mth=0;
			T=0;M=0;N=0;
			i=1;
			while(i<13){
				M=sc.nextInt();
				N=sc.nextInt();
				T=T+M-N;
				if(T>=L && mth==0){
					mth=i;
				}
				i++;
			}
			if(mth==0){System.out.println("NA");}
			else{System.out.println(mth);}
			L=sc.nextInt();
		}
	}
}