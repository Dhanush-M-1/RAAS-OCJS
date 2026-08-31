import java.util.Scanner;
public class Joker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vacas = sc.nextInt();
		String estado = sc.next();
		int x = -1;
		int y = 0;
		int Folded = 0;
		int Allin = 0;
		int In = 0;
		for(int n=vacas; n>0; n--){
			x = x + 1;
			y = y + 1;
			String estado1 = estado.substring(x, y);
			if(estado1.equals("F")){
				Folded = Folded + 1;
			}
			else if(estado1.equals("A")){
				Allin = Allin + 1;
			}
			else if(estado1.equals("I")){
				In = In + 1;
			}
			
		}
		int mano = 0;
		if(Allin > 0){
			for(int j=Allin; j>0; j--){
				if(In==0 && Folded >= 0){
					mano = mano + 1;
				}
			}
		}if(In>0 && In<2){
			mano = mano + 1;
		}
		System.out.print(mano);
		
		
	}

}
