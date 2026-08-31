import java.util.Scanner;

class Main
{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[][] a = new int[4][14];
		
		for(int i=0; i<4; i++){
			for(int j=0; j<=13; j++){
				a[i][j] = 0;}}
		
		for(int i=0; i<n; i++){
			String str = scan.next();
			int b = scan.nextInt();
			if(str.equals("S")){
				a[0][b] = 1;}
			else if(str.equals("H")){
				a[1][b] = 1;}
			else if(str.equals("C")){
				a[2][b] = 1;}
			else if(str.equals("D")){
				a[3][b] = 1;}}
			
		for(int i=0; i<4; i++){
			for(int j=1; j<=13; j++){
				if(a[i][j]==0){
					if(i==0){
						System.out.println("S "+j);}
					else if(i==1){
						System.out.println("H "+j);}
					else if(i==2){
						System.out.println("C "+j);}
					else if(i==3){
						System.out.println("D "+j);}}}}
	}
}
