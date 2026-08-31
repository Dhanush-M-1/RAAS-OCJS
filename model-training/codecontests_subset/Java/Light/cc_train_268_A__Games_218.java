import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner leer=new Scanner(System.in);
		int n=leer.nextInt();
		int v=0;
		int C[][]=new int[3][n+1];//f1 local f2 visitante
		for(int i=1;i<=n;i++){
			C[1][i]=leer.nextInt();
			C[2][i]=leer.nextInt();
		}
		//for(int i=1;i<=n;i++){
		//	System.out.println(C[1][i]+" "+C[2][i]);
		//}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){		
				if(C[1][i]==C[2][j]){
					v++;
				}
			}
		}
		System.out.println(v);
	}
}
