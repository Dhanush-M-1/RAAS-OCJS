import java.util.Scanner;

public class test {

	public static Scanner cin=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(cin.hasNext()){
			int n = cin.nextInt();
			long k=cin.nextLong();
			int arr[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i]=cin.nextInt();
			}
			long disc=0;
			int ptn=0;
			for(long i=1;i<=n;i++){
				long tmp=i-1;
				if(i*(i+1)/2>k){
					disc=tmp*i/2;
					ptn=(int)(k-disc-1);
					break;
				}else if(i*(i+1)/2==k){
					ptn=(int)tmp;
					break;
				}
			}
			
			System.out.println(arr[ptn]);
		}
	}

}
