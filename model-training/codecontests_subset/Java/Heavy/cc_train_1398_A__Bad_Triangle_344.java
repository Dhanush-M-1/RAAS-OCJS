
import java.util.Scanner;

public class Div2EducationalRound93A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t--!=0){
			int n=s.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=s.nextInt();
			}
			boolean flag=false;
			for(int i=0;i<n-2;i++){
				int v1=arr[i];
				int j=i+1;
				//for(j=n-2;j>i;j--){
					int v2=arr[j];
					int r=v1+v2;
					if(r<=arr[n-1]){
						flag=true;
						int i1=i+1,i2=j+1,i3=n;
						System.out.println(i1+" "+i2+" "+i3);
						break;
				//	}
				}
				if(flag==true) break;
			}
			if(flag==false){
				System.out.println("-1");
			}
		}
	}

}
