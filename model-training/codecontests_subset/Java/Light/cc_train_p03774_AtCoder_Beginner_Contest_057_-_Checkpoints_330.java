

import java.util.Scanner;

class Main{
	public static void main(String[] ag) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		long[][] chkp=new long[M][2];
		long[][] hito=new long[N][2];

		for(int i=0; i<N; i++) {
			hito[i][0]=sc.nextLong();
			hito[i][1]=sc.nextLong();
		}

		for(int i=0; i<M; i++) {
			chkp[i][0]=sc.nextLong();
			chkp[i][1]=sc.nextLong();
		}

		long dist_min=114514810114514810L;
		long tmp=0;
		int kekka=0;
		for(int i=0; i<N; i++) {
			dist_min=114514810114514810L;
			for(int j=0; j<M; j++) {
				tmp=Math.abs(chkp[j][0]-hito[i][0])+Math.abs(chkp[j][1]-hito[i][1]);
				if(tmp<dist_min) {
					dist_min=tmp;
					kekka=j+1;
				}
			}
			System.out.println(kekka);
		}
	}
}