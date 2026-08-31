import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Z519B {
	
	public static void main(String[] args) throws NumberFormatException, IOException { 
		Z519B z = new Z519B();
		int[] niz = z.glavnaMetoda();
		ispis(niz);
	}
	
	public int[] glavnaMetoda() throws NumberFormatException, IOException { 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nizIspis = new int[2];
		
		String[] linija = br.readLine().split(" ");
		String[] linija2 = br.readLine().split(" ");
		String[] linija3 = br.readLine().split(" ");
		
		int sumaA=0;
		for(int i=0; i<linija.length; i++)  {
			sumaA += Integer.parseInt(linija[i]);
		}
		int sumaB=0;
		for(int i=0; i<linija2.length; i++)  {
			sumaB += Integer.parseInt(linija2[i]);
		}
		int sumaC=0;
		for(int i=0; i<linija3.length; i++)  {
			sumaC += Integer.parseInt(linija3[i]);
		}
		nizIspis[0] =  sumaA-sumaB;
		nizIspis[1] = sumaB-sumaC;
		return nizIspis;
	}
	public static void ispis(int[] nizIspis) { 
		for(int i=0; i<nizIspis.length; i++) { 
			System.out.println(nizIspis[i]);
		}
	}
}





