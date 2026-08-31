import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		//File fi=new File("file.txt");

		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		 String type;
		 int x;
		 int[][] tp=new int[4][14];
		for(int i=0;i<t;i++){
			type=sc.next();
			x=sc.nextInt();
			if(type.equals("S")){tp[0][x]=1;}
			else if(type.equals("H")){tp[1][x]=1;}
			else if(type.equals("C")){tp[2][x]=1;}
			else if(type.equals("D")){tp[3][x]=1;}
			
		}sc.close();
		for(int i=0;i<4;i++){
			for(int l = 1;l<14;l++){
				if(tp[i][l]==0){
					if(i==0)System.out.print("S ");
					else if(i==1)System.out.print("H ");
					else if(i==2)System.out.print("C ");
					else System.out.print("D ");
					System.out.println(l);
				}
			}
		}
		
		
		// TODO 自動生成されたメソッド・スタブ

	}

}