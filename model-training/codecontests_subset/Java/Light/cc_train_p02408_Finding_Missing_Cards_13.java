import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int a[][]=new int[4][13];
		
		int n=scan.nextInt();
		int i,j;
		for(i=0;i<n;i++){
			String mark=scan.next();
			int num=scan.nextInt();
			
			if(mark.equals("S")){
				a[0][num-1]=1;
			}
		    if(mark.equals("H")){
				a[1][num-1]=1;
			}
			if(mark.equals("C")){
				a[2][num-1]=1;
			}
			if(mark.equals("D")){
				a[3][num-1]=1;
			}
		}
		
		for(i=0;i<4;i++){
			for(j=0;j<13;j++){
				if(a[i][j]!=1){
					switch(i){
						case 0:System.out.printf("S %d\n",j+1);break;
						case 1:System.out.printf("H %d\n",j+1);break;
						case 2:System.out.printf("C %d\n",j+1);break;
						case 3:System.out.printf("D %d\n",j+1);break;
					}
				}
			}
		}
	}
}
