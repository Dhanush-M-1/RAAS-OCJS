import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner cin = null;
		cin = new Scanner(System.in);
		int n= Integer.parseInt(cin.nextLine());//Leemos n
		
		String []cadena = cin.nextLine().split(" ");
		int [] pesos= new int [2];
		pesos[0]=pesos[1]=0;
		
		for (int i=0; i<n; i++){
			if (Integer.parseInt(cadena[i])== 100)
				pesos[0]+=1;
			else
				pesos[1]+=1;
		}
		int aux;
		aux= (pesos[0]*100)+(pesos[1]*200);
		
		if ((pesos[0]%2==0) && (pesos[1]%2==0)){
			System.out.println ("YES");
		}
		else if ((pesos[0]%2!=0) && (pesos[1]!=0))
			System.out.println("NO");
	
		else if ((pesos[0]%2!=0) && (pesos[1]==0))
			System.out.println("NO");
		
		else if ((pesos[0]==0) && (pesos[1]!=0))
			System.out.println("NO");
		
		else if ((pesos[0]!=0&&pesos[0]%2==0) && (pesos[1]!=0))
			System.out.println("YES");
	
	
		
	}

}
