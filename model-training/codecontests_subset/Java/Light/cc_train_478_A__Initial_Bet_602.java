import java.util.*;
public class _478A{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int suma = getSuma(sc);
		System.out.println(getApuesta(suma));
		sc.close();
	}
	static int getSuma(Scanner sc){
		int suma = 0;
		for(int i=0; i<5; i++)
			suma += sc.nextInt();
		return suma;
	}
	static int getApuesta(int suma){
		int res = -1;
		if(suma>0 && suma%5==0)
			res = suma/5;
		return res;
	}
}