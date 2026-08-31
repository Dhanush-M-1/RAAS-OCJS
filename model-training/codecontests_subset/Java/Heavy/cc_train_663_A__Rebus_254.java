
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split(" ");
		int pos = 1;
		int neg = 0;
		for(int i=1;i<arr.length-2;i+=2){
			if(arr[i].equals("+")){
				pos++;
			}
			else{
				neg++;
			}
		}
		long n = Integer.valueOf(arr[arr.length-1]);
		if(((n*pos) - neg < n) || (pos - (n*neg) > n)){
			System.out.println("Impossible");
		}
		else{
			System.out.println("Possible");
			long divPos = 0;
			long divNeg = 0;
			long modPos = 0;
			long modNeg = 0;
			if(pos<neg){
				for(long i=pos;i<=n*pos;i++){
					long x = i - n;
					if(x >= neg && x <= n*neg){
						divPos = i/pos;
						modPos = i%pos;
						divNeg = x/neg;
						modNeg = x%neg;
						break;
					}
				}
			}
			else{
				for(int i=neg;i<=n*neg;i++){
					long x = i + n;
					if(x >= pos && x <= n*pos){
						divPos = x/pos;
						modPos = x%pos;
						if(neg!=0){
							divNeg = i/neg;
							modNeg = i%neg;
							
						}
						break;
					}
				}
			}
			if(modPos > 0){
				modPos--;
				System.out.print((divPos + 1) + " ");
			}
			else{
				System.out.print(divPos + " ");
			}
			for(int i=1;i<arr.length-2;i+=2){
				if(arr[i].equals("+")){
					if(modPos > 0){
						modPos--;
						System.out.print("+ " + (divPos + 1) + " ");
					}
					else{
						System.out.print("+ " + (divPos) + " ");
					}
				}
				else{
					if(modNeg > 0){
						modNeg--;
						System.out.print("- " + (divNeg + 1) + " ");
					}
					else{
						System.out.print("- " + (divNeg) + " ");
					}
				}
			}
			System.out.print("= " + n);
		}
	}
}
