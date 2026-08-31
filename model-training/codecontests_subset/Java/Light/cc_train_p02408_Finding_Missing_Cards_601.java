import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0;i<=n;i++){
			list.add(sc.nextLine());
		}
		for(int i=1;i<14;i++){
			if(list.contains("S "+i)==false)
				System.out.println("S "+i);
		}
		for(int i=1;i<14;i++){
			if(list.contains("H "+i)==false)
				System.out.println("H "+i);
		}
		for(int i=1;i<14;i++){
			if(list.contains("C "+i)==false)
				System.out.println("C "+i);
		}
		for(int i=1;i<14;i++){
			if(list.contains("D "+i)==false)
				System.out.println("D "+i);
		}
	}
}