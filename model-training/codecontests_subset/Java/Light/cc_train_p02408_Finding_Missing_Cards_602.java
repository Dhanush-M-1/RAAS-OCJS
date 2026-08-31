import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<String> list = new ArrayList<String>();
		String[] mark ={"S","H","C","D"};

		for(int i=0;i<=3;i++){
			for(int j=0;j<=12;j++){
				list.add(mark[i]+" "+(j+1));
			}
		}
		for(int i=0;i<=n-1;i++){
			list.remove(sc.nextLine());
		}
		for(String ans:list){
			System.out.println(ans);
		}
	}
}