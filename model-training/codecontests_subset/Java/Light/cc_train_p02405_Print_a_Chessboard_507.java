import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
		int h = sc.nextInt();
		int w = sc.nextInt();             
		if (h == 0 && w == 0) return;            
		for (int i = 0; i < h; i++) {                 
		for (int j = 0; j < w; j++) {                     
		System.out.print(((i + j) % 2 == 0)? '#' : '.'); 
		}                 
		System.out.println();             
		}             
		System.out.println(); 
		}
        }
}