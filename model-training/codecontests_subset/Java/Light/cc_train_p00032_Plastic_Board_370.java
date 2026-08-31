import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	void doIt() {
		int cho = 0;
		int hishi = 0;
		while(true){
			try{
				String str[] = sc.nextLine().split(",");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);
				if(a * a + b * b == c * c)cho++;
				if(a == b)hishi++;
			}catch(Exception g){
				System.out.println(cho);
				System.out.println(hishi);
				System.exit(0);
			}
		}
	}
    public static void main(String[] args) {
    	new Main().doIt();
    }
}