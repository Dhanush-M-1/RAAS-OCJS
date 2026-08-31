
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner hs = new Scanner(System.in);
		while (hs.hasNext()) {
			int a = hs.nextInt();
			int b = hs.nextInt();
			int k=0;
            int sum=0;
            while(a-->0) {
            	 sum++;
                 k++;
                 if(k%b==0){
                     k=0;
                     a++;
                 }

            }
            System.out.println(sum);
		}

	}

}