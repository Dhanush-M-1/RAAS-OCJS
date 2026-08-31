import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner std = new Scanner(System.in);
		while(true){
			int h = Integer.parseInt(std.next());
			int w = Integer.parseInt(std.next());
			if(h!=0 && w!=0){
				String line = "";
				for(int m=1; m<=w/2+1; m++){
					line += "#.";
				}
				for(int n=1; n<=h; n++){
					if(n%2==1){
						System.out.println(line.substring(0, w));
					}else{
						System.out.println(line.substring(1, w+1));
					}
				}
				System.out.println();
			}else break;
		}
	}
}