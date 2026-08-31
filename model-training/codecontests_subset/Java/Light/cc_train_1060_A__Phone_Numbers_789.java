import java.util.*;
public class ph{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		char a[]=sc.next().toCharArray();
		int b[]=new int[10];
		int i;
		for(i=0;i<n;i++){
			b[(int)(a[i]-'0')]++;
		}
		if(n<11){
			System.out.println("0");
		}
		else if(b[8]==0){
			System.out.println("0");
		}
		else{
			if(n/11>b[8]){
				System.out.println(b[8]);
			}
			else
				System.out.println(n/11);
		}
	}
}