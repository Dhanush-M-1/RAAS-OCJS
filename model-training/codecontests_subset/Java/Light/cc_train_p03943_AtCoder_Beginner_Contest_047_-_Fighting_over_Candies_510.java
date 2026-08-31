import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner stdIn=new Scanner(System.in);
		int n[]=new int[3],i,j,t;
		for(i=0;i<3;i++) n[i]=stdIn.nextInt();
		for(i=0;i<2;i++) {
			for(j=2;j>i;j--) {
				if(n[j-1]>n[j]) {
					t=n[j-1];
					n[j-1]=n[j];
					n[j]=t;
				}
			}
		}
		System.out.print(n[0]+n[1]==n[2]?"Yes":"No");
	}
}