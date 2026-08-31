import java.util.Scanner;
	public class Main{
		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			int c1=0;
			int c2=0;
			while(sc.hasNext()){
				String str = sc.nextLine();
				String num[] = str.split(",",0);
				int a = Integer.parseInt(num[0]);
				int b = Integer.parseInt(num[1]);
				int c = Integer.parseInt(num[2]);
				if(c<b){
					if(c<a){
						continue;
					}
				}
				if(c * c == a * a + b * b){
					c1++;
				}else{
					c2++;
				}
			}
			System.out.println(c1);
			System.out.println(c2);
		}
	}