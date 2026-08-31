import java.util.*; 

public class B {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int tt = 0;tt<t;tt++) {
			int n = scan.nextInt();
			scan.nextLine();
			int s1,s2,f1,f2;
			String s = scan.nextLine();
			s1 = Integer.parseInt(Character.toString(s.charAt(1)));
			s = scan.nextLine();
			s2 = Integer.parseInt(Character.toString(s.charAt(0)));
			for(int i = 2;i<n-1;i++) {
				s = scan.nextLine();
			}
			f1 = Integer.parseInt(Character.toString(s.charAt(n-1)));
			s = scan.nextLine();
			f2 = Integer.parseInt(Character.toString(s.charAt(n-2)));
			
			if(s1==s2 && f1==f2 && s1!=f1 && s1!=f2) {
				System.out.println(0);
			}
			else if((s1==s2 && f1==f2)||(s1!=s2)&&(f1!=f2)){
				System.out.println(2);
				if(s1==s1 && f1==f2) {
					System.out.println(n+" "+(n-1));
					System.out.println((n-1)+" "+n);
				}
				else {
					if(s1==f1) {
						System.out.println("1 2");
						System.out.println(n+" "+(n-1));
					}
					else {
						System.out.println("1 2");
						System.out.println((n-1)+" "+n);
					}
				}
			}
			else {
				System.out.println(1);
				if(s1==s2) {
					if(f1==s1)
						System.out.println((n-1)+" "+n);
					else
						System.out.println(n+" "+(n-1));
				}
				else {
					if(s1==f1)
						System.out.println("1 2");
					else
						System.out.println("2 1");
				}
			}
			
			
		}
		
		scan.close();
		
	}
}

