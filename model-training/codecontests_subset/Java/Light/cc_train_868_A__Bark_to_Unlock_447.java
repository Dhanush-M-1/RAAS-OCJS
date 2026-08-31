import java.util.Scanner;		
public class BarkToUnlock {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String pw = in.nextLine();
		int n = in.nextInt(), fl=0, sl=0;
		String word[] = new String[n];
		
		for(int i=0;i<n;i++){
			word[i]=in.next();
		}
		
		for(int i=0;i<n;i++){
			if(word[i].substring(0,1).contains(pw.substring(1,2)))
				fl++;
			if(word[i].substring(1,2).contains(pw.substring(0,1)))
				sl++;
			if(word[i].contains(pw)){
				fl++;
				sl++;
			}
		}
		
		if((fl>0) && (sl>0))
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
}