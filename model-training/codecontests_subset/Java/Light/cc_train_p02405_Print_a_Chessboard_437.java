import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int h =sc.nextInt(),w=sc.nextInt();
			if(h==0 && w==0) {
				break;
			}
			String s1="";
			String s2="";
			for(int i=0; i<w;i++) {
				if(i%2==0) {
					s1 +="#";
					s2 +=".";
				}else {
					s1 +=".";
					s2 +="#";
				}
			}

			for(int i=0; i<h; i++) {
				if(i%2==0) {
					System.out.println(s1);
				}else {
					System.out.println(s2);
				}
			}
			System.out.println();
		}
	}
}
