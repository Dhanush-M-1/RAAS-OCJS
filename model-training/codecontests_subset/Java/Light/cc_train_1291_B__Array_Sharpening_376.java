
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		int z=in.nextInt();
		for(int m=0;m<z;m++) {
			int a=in.nextInt();int []arr=new int[a];
			for(int i=0;i<a;i++) {
				arr[i]=in.nextInt();
			}int zhuan =-1;int co=-1;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]<i) {
					zhuan =i;co=arr[i];
					break;
				}
			}
			if(zhuan==-1) {
				System.out.println("yes");
			}else {
			for(int i=zhuan;i<arr.length;i++) {
				if(arr[i]>=arr[i-1]) {
					arr[i]=arr[i-1]-1;
				}
			}System.out.println(arr[arr.length-1]>=0?"YES":"NO");
			}
		}
	}

}
