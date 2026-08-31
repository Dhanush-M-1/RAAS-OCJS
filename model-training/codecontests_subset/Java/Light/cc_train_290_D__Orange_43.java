import java.util.Scanner;


public class MagicMonkey {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toLowerCase().toCharArray();
		int N = sc.nextInt();
		for(int a=0;a<in.length;a++){
			if(in[a]<N+97){
				in[a]=upper(in[a]);
			}
	//		else in[a]=lower(in[a]);
		}
		System.out.println(String.valueOf(in));
	}

	private static char upper(char c) {
		if(Character.isLowerCase(c))return (char)(c-'a'+'A');
		return c;
	}
	private static char lower(char c) {
		if(Character.isUpperCase(c))return (char)(c-'A'+'a');
		return c;
	}

}
