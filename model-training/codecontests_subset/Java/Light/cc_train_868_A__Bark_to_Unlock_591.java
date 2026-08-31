import java.util.Scanner;

public class BarkToUnlock {
	public static void main(String args[]){
		Scanner kbd = new Scanner(System.in);
                
		String pwd = kbd.next();
		int n = kbd.nextInt();
		String[] words = new String[n];
		
		for (int w = 0 ; w < n ; w++){
			words[w] = kbd.next();
		}
		for(int o = 0 ; o < n ; o++){
                    for(int r = 0 ; r < n ; r++){
                        String conct = words[o] + words[r];
			if(conct.contains(pwd)){
                            System.out.println("YES");
                            return;
			}
                    }
		}
		System.out.println("NO");
	}
}