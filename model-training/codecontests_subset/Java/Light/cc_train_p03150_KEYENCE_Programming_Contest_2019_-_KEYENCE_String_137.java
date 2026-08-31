import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String e ="keyence";
		if((a.substring(a.length()-7,a.length())).equals(e)){
			System.out.println("YES");
			return;
		}else if((a.substring(0,7)).equals(e)){
			System.out.println("YES");
			return;
		}
		for(int i = 1; i <= 7; i++){
				if((a.substring(0,i)).equals(e.substring(0,i))){
						if((a.substring(a.length()-7+i,a.length())).equals(e.substring(i,e.length()))){
							System.out.println("YES");
							return;
						}
				}
		}
		System.out.println("NO");
	}
}