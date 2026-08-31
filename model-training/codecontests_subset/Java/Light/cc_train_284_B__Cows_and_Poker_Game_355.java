import java.util.Scanner;
public class Main {
 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t,Asayisi =0,Isayisi=0,Fsayisi=0;
		String kelime;
		t = scanner.nextInt();
		kelime = scanner.next();
		
		for (int i = 0; i < t; i++) {
			if(kelime.charAt(i) == 'A')
				Asayisi++;
			else if(kelime.charAt(i) == 'F')
				Fsayisi++;
			else if(kelime.charAt(i) == 'I')
				Isayisi++;
		}
		
		if(Isayisi == 0){
			System.out.println(Asayisi);
		}else if(Isayisi == 1){
			System.out.println("1");
		}else if(Isayisi > 1)
			System.out.println("0");
	}

}
