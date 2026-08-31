
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[][] array=new int[4][13];
		for(int i=1; i<=n; i++){
			String s=sc.next();
			int a=sc.nextInt();
			if(s.equals("S")){
				array[0][a-1]=1;
			}else if(s.equals("H")){
				array[1][a-1]=1;
			}else if(s.equals("C")){
				array[2][a-1]=1;
			}else if(s.equals("D")){
				array[3][a-1]=1;
			}
		}
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[0].length; j++){
				if(array[i][j]==0 && i==0){
					System.out.println("S "+(j+1));
				}else if(array[i][j]==0 && i==1){
					System.out.println("H "+(j+1));
				}else if(array[i][j]==0 && i==2){
					System.out.println("C "+(j+1));
				}else if(array[i][j]==0 && i==3){
					System.out.println("D "+(j+1));
				}
			}
		}

	}




}
