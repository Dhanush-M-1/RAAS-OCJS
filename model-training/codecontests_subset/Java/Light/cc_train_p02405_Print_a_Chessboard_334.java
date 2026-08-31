import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int H[]=new int[256];
		int W[]=new int[256];

		int i=0;
		while(true){
			H[i]=sc.nextInt();
			W[i]=sc.nextInt();

			if(H[i]==0&&W[i]==0)	break;
			i++;
		}

		for(int x=0;x<i;x++){
			for(int j=0;j<H[x];j++){
				for(int k=0;k<W[x];k++){
					if((j%2==0&&k%2==0)||(j%2==1&&k%2==1))	System.out.print("#");
					else	System.out.print(".");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}