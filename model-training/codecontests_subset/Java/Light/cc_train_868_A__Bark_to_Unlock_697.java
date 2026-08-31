import java.util.Scanner;

public class ned{
	public static void main(String[] args){
		Scanner jon = new Scanner(System.in);
		String s = jon.nextLine();
		int n = jon.nextInt();
		jon.nextLine();
		
		String stark[] = new String[n];
		
		for(int i=0;i<n;i++){
			stark[i]=jon.nextLine();
			if(stark[i].equals(s)){
				System.out.println("YES");
				return;
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				String k = "";
				k +=stark[i].charAt(1);
				k+=stark[j].charAt(0); 
				if(k.equals(s)){
					System.out.println("YES");
					return;
				}
			}
		}
		
		System.out.println("NO");
	}
}