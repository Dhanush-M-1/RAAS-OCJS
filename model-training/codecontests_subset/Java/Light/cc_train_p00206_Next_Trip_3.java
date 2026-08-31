import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int l = scan.nextInt();
			if(l == 0){
				break;
			}
			int cost = 0;
			boolean sw = true;
			for(int i = 0;i < 12;i++){
				cost += scan.nextInt() - scan.nextInt();
				if(l <= cost && sw){
					System.out.println(i+1);
					sw = false;
				}else if(i == 11 && sw){
					System.out.println("NA");
				}
			}
		}
	}
}