import java.util.Scanner;

public class VaquitasLocas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String vaquitas = sc.next();
		int sumaA = 0;
		int sumaI = 0;
		int sumaF = 0;
		for(int i = 0; i < n; i++){
			if (vaquitas.substring(i,i+1).equals("A")){
				sumaA = sumaA + 1;
			}
			if (vaquitas.substring(i,i+1).equals("I")){
				sumaI = sumaI + 1;
			}
			if (vaquitas.substring(i,i+1).equals("F")){
				sumaF = sumaF + 1;
			}
		}
		if (sumaI == 1){
			System.out.println(sumaI);
		}
		if (sumaI == 0){
			System.out.println(sumaA);
		}
		else if (sumaI > 1){
			System.out.println("0");
		}
	}
}
