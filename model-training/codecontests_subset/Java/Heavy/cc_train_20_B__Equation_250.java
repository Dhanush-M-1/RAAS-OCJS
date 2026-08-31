import java.util.*;
public class B20 {
	public static void main(String[] args){
		Scanner br = new Scanner(System.in);
		long a = br.nextInt();
		long b = br.nextInt();
		long c = br.nextInt();
		if(a == 0 && b  == 0){
			if(c == 0)
				System.out.println(-1);
			else
				System.out.println(0);
		}
		else if(a == 0){
			System.out.printf("%d\n%.8f\n", 1, -c*1.0/b);
		}
		else if(b == 0){
			if(c*-1.0/a < 0){
				System.out.println(0);
			}
			else{
				if(c == 0){
					System.out.println(1);
					System.out.printf("%.8f", 0.0);
				}
				else{
					double res = Math.sqrt(-c/a);
					System.out.println(2);
					System.out.printf("%.8f\n%.8f\n", -res, res);
				}
			}
		}
		else{
			if(b*b < 4*a*c){
				System.out.println(0);
			}
			else if(b*b == 4*a*c){
				double res = -b/(2.0*a);
				System.out.println(1);
				System.out.printf("%.8f\n", res);
			}
			else{
				double res1 = (-b + Math.sqrt(b*b-4*a*c))/(2.0*a);
				double res2 = (-b - Math.sqrt(b*b-4*a*c))/(2.0*a);
				if(res2 < res1){
					double temp = res1;
					res1 = res2;
					res2 = temp;
				}
				System.out.println(2);
				System.out.printf("%.8f\n%.8f\n", res1, res2);
			}
		}
	}
}
