import java.util.Scanner;

public class juego{
	public static void main(String[] args){

		Scanner lector = new Scanner(System.in);

		String optionx = lector.nextLine();
		int option = Integer.parseInt(optionx);

		for(int i = 0; i < option; i++){
			String optiony = lector.nextLine();
			String[] div = optiony.split(" ");
			int li = Integer.parseInt(div[0]);
			int ri = Integer.parseInt(div[1]);
			int di = Integer.parseInt(div[2]);

			if(di < li || ri < di){
				System.out.println(di);
			}
			else{
				System.out.println(((ri/di) + 1) * di);
			}
		}
	}
}