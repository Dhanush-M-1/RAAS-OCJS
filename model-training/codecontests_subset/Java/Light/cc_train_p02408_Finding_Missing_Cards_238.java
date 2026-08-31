import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO ?????????????????????????????????????????????

		int cards[][] = new int[4][13];
		String m[] = {"S", "H", "C", "D"};
		
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();

		for(int z=1; true; z++){

			if (z > x) break;
			
			String i = scan.next();
			int j = scan.nextInt();
			int I = 0;
			int J = j-1;
			
			if(i.equals ("S")) I = 0;
			else if(i.equals ("H")) I = 1;
			else if(i.equals ("C")) I = 2;
			else if(i.equals ("D")) I = 3;
			cards[I][J] = j;
		}
		
		//?????????
		for (int I=0; true; I++){
			for(int J=0; true; J++){
				if((cards[I][J]) == 0){
					System.out.print(m[I] + " ");
					System.out.println(J+1);
				}
				if(J==12) break;
			}
			if (I==3) break;
		}
		
		
	}

}