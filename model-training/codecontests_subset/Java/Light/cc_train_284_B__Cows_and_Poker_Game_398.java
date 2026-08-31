import java.util.Scanner;

public class probb {
	public static int i(String s){return Integer.parseInt(s);}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = i(scan.nextLine());
		String s = scan.nextLine();
		int[] total = new int[3]; //A, I, F
		for(char c : s.toCharArray()){
			switch(c){
			case 'A':
				total[0]++;
				break;
			case 'I':
				total[1]++;
				break;
			case 'F':
				total[2]++;
				break;
				
			}
		}
		if(total[1] == 0){
			System.out.println(total[0]);
		}
		else if(total[1] == 1){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
	}
}