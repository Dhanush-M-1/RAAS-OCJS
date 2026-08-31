import java.util.Scanner;
 
public class main {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int l = sc.nextInt();
	sc.nextLine();
	String s = sc.nextLine();
	int si = (int)l/2;
	int n=1;
	int nu[] = new int[]{0,0};
	int num[] = new int[]{0,0};
	int num1[] = new int[]{0,0};
	for(int j = 0; j < s.length(); j++){
	    nu[s.charAt(j)-'0']++;
	}
	if(l==1){
		System.out.println(n);
		System.out.println(s);
	}
	else if(nu[0]!=nu[1]) {
		System.out.println(n);
		System.out.println(s);
	}
	else {
		for(int i=0;i<l/2;i++) {
			n=2;
			String sub1 = s.substring(0,si);
			String sub2 = s.substring(si,l);
			for(int j = 0; j < sub1.length(); j++){
			    num[s.charAt(j)-'0']++;
			}
			for(int j = 0; j < sub2.length(); j++){
			    num1[s.charAt(j)-'0']++;
			}
			if((num[0]!=num[1])&&(num1[0]!=num1[1])) {
				System.out.println(n);
				System.out.println(sub1+" "+sub2);
				break;
			}
			si--;
		}
	}
  }
}