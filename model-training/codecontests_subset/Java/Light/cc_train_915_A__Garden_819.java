import java.util.Scanner;
public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in); 
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			int b=in.nextInt();
			if(k%b>0){continue;}
			a[i]=b;
		}
		int max=0;
		for(int i=0;i<n;i++){
			if(max<a[i]){
				max=a[i];
			}
		}
		System.out.println(k/max);
	}

}
