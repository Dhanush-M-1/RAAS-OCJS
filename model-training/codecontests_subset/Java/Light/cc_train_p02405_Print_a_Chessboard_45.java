import java.util.Scanner;
public class Main {
	void rect(){
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		int w = s.nextInt();
		while(h!=0||w!=0){
			for(int i = 0;i<h;i++){
				for(int j = 0;j<w;j++){
					if((j+i)%2==0){
						System.out.print("#");
					}else{
						System.out.print(".");
					}
				}
				System.out.println("");
			}
			System.out.println("");
			h = s.nextInt();
			w = s.nextInt();
		}
	}
	public static void main(String args[]){
		Main m = new Main();
		m.rect();
	}
}