import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	String parameters = input.nextLine();
	String[] paramArray = parameters.split(" ");
	double citizens = Double.parseDouble(paramArray[0]);
	int wizards = Integer.parseInt(paramArray[1]);
	int percentage = Integer.parseInt(paramArray[2]);

	double requirement = Math.ceil((citizens/100)*percentage);
	if(wizards >= requirement){
		System.out.println(0);
	}
	else{
		int clones = (int) requirement - wizards;
		System.out.println(clones);
	}
    }
}