import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int[][] card = new int[4][13];
		String mark = "";
		int num =0;
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.next());
		for(int i=0;i<n;i++){
			mark= scan.next();
			num = Integer.parseInt(scan.next());
			if(mark.equals("S")) 	 card[0][num-1]=1;
			else if(mark.equals("H"))card[1][num-1]=2;
			else if(mark.equals("C"))card[2][num-1]=3;
			else 					 card[3][num-1]=4;
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				if(card[i][j]==0){
					if(i==0) System.out.println("S "+(j+1));
					if(i==1) System.out.println("H "+(j+1));
					if(i==2) System.out.println("C "+(j+1));
					if(i==3) System.out.println("D "+(j+1));
				}
			}
		}
	}
}