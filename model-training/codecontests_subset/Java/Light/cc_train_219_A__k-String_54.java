import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		scan.nextLine();
		String s = scan.nextLine();
		long a[] = new long[26];
		for(int i=0;i<26;i++){
			a[i]=0;
		}
		for(long i=0;i<s.length();i++){
			for(int j=0;j<26;j++){
				if(s.charAt((int) i)-'a'==j)
					a[j]++;
			}
		}
		int flag = 0;
		for(int i=0;i<26;i++){
			if(a[i]%k==0)
				continue;
			else{
				flag = 1;
				break;
			}
		}
		if(flag == 1)
			System.out.println("-1");
		else{
			String ans = new String();
			for(int j=0;j<k;j++){
				for(int i=0;i<26;i++){
					if(a[i]!=0){
						for(int x=0;x<a[i]/k;x++)
							ans = ans + Character.toString((char)(i+'a'));
					}
				}
			}
			
			System.out.println(ans);
		}
	}

}
