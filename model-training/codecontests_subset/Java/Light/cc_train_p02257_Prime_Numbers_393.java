import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count=0;
		int n = Integer.parseInt(sc.nextLine());

		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			int num=Integer.parseInt(s);
			double numDouble=Double.parseDouble(s);
			int divor=Math.round(Math.round(Math.sqrt(numDouble)))+1;
			boolean f=true;
			for(int j=2;j<divor;j++){
				if(num%j==0){
					f=false;
					break;
				}
			}
			if(f){
				count++;
			}
		}
		System.out.println(count);
	}
}

