import java.util.Scanner;
class Main{
    public static void main(String[] args){
		int n;
		String c;
		int a;
		int[][] card=new int[4][14];
		String[] egara={"S","H","C","D"};
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<4;i++){
			for(int j=0;j<14;j++){
				card[i][j]=0;
			}
		}
		n=sc.nextInt();
		for(int i=0;i<n;i++){
			c=sc.next();
			a=sc.nextInt();
			switch(c){
				case "S":
					card[0][a]=a;
					break;
				case "H":
					card[1][a]=a;
					break;
				case "C":
					card[2][a]=a;
					break;
				case "D":
					card[3][a]=a;
					break;
				default:
					break;
			}
		}
		for(int i=0;i<4;i++){
			for(int j=1;j<14;j++){
				if(card[i][j]==0){
					System.out.println(egara[i]+" "+j);
				}
			}
		}
    }
}

