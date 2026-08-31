import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		boolean[][] cards=new boolean[4][13];
		int n=scan.nextInt();
		int number;
		String mark;
		for(int i=0;i<n;i++){
			mark=scan.next();
			number=scan.nextInt();
			if(mark.equals("S")){
				cards[0][number-1]=true;
			}else if(mark.equals("H")){
				cards[1][number-1]=true;
			}else if(mark.equals("C")){
				cards[2][number-1]=true;
			}else{
				cards[3][number-1]=true;
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				if(!cards[i][j]){
					if(i==0){
						System.out.println("S "+(j+1));
					}else if(i==1){
						System.out.println("H "+(j+1));
					}else if(i==2){
						System.out.println("C "+(j+1));
					}else{
						System.out.println("D "+(j+1));
					}
				}
			}
		}
		scan.close();
	}
}