import java.util.*;

public class VasyaAndSocks {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		Scanner scannedInput=new Scanner(input);
		int size=scannedInput.nextInt();
		int days=scannedInput.nextInt();
		int i=0;
		while(size>0){
			size-=1;
			i++;
			if(i%days==0){
				size+=1;
			}
		}
		System.out.println(i);
	}
}
