import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] mar;
		int[] num;
		num = new int[54];
		int n = scan.nextInt();
		int i,q;
		for(i = 1; i <= n; ++i){
			String m = scan.next();
			int x = scan.nextInt();
			if(m.equals("S")){
				num[x] = x;				
			}
			else if(m.equals("H")){
				q = x + 13;
				num[q] = q;
			}
			else if(m.equals("C")){
				q = x + 26;
				num[q] = q;
			}
			else if(m.equals("D")){
				q = x + 39;
				num[q] = q;
			}	
		}
		int s;
		s = 0;
		for(i = 1; i <= 52; ++i){
			if(num[i] == 0){
				if(i <= 13){
					s = i;
					System.out.println("S "+s);
				}
				else if(i > 13 && i <= 26){
					s = i - 13;
					System.out.println("H "+s);
				}
				else if(i > 26 && i <= 39){
					s = i - 26;
					System.out.println("C "+s);
				}
				else if(i > 39){
					s = i - 39;
					System.out.println("D "+s);
				}
			}
		}
	}
}

		
				