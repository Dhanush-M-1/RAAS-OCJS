import java.util.*;

class Main{
    public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String sin = sc.nextLine();
		int iin = Integer.parseInt(sin);
		int[][] iif = new int[iin][10];
		int[][] iip = new int[iin][11];
		int[] iipidx = new int[iin];
		int iret = 0;
		
		for(int i=0;i<iin;i++) {
			String sif = sc.nextLine();
			String[] ksif = new String[10];
			ksif = sif.split(" ");
			for(int j=0;j<10;j++) {
				iif[i][j] = Integer.parseInt(ksif[j]);
			}
		}
		for(int i=0;i<iin;i++) {
			String sip = sc.nextLine();
			String[] ksip = new String[11];
			ksip = sip.split(" ");
			for(int j=0;j<11;j++) {
				iip[i][j] = Integer.parseInt(ksip[j]);
			}
		}
		
		for(int i=1;i<1024;i++){
			for(int j=0;j<iin;j++){
				iipidx[j] = 0;
			}
			int ik=i;
			for(int kisu=512,k=0;k<10;kisu/=2,k++){
				if(ik/kisu==1){
					for(int j=0;j<iin;j++){
						if(iif[j][k]==1)
						iipidx[j] += 1;
					}
					ik -= kisu;
				}
			}
			int ikari = 0;
			for(int j=0;j<iin;j++){
				ikari += iip[j][iipidx[j]];
			}
			if(i==1 || iret<ikari){
				iret = ikari;
			}
		}
		System.out.println(iret);
    }
}