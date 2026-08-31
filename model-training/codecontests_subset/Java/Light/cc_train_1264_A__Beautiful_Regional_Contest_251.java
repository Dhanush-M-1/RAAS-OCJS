import java.util.*;
import java.io.*;
public class cf604_2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=sc.nextInt();
			}

			if(n<=3){
				sb.append("0 0 0\n");
				continue;
			}
			
			int mid=0;
			for(int j=n/2-1;j>=0;j--){
				if(arr[j]!=arr[j+1]){
					mid=j;
					break;
				}
			}
			
			int g=1;
			int si=1;
			int b=1;
			
			int index1=n;
			int index2=n;
			
			for(int j=1;j<=mid;j++){
				if(arr[j]==arr[j-1]){
					g++;
				}else{
					index1=j;
					break;
				}
			}
			
			for(int j=index1+1;j<=mid;j++){
				if(arr[j]==arr[j-1]){
					si++;
				}else if(si>g){
					index2=j;
					break;
				}else{
					si++;
				}
			}
			
			for(int j=index2+1;j<=mid;j++){
				b++;
			}
			
			if(g<si && g<b){
				sb.append(g+" "+si+" "+b+"\n");
			}else{
				sb.append("0 0 0\n");
			}
		}
		
		out.println(sb);
		sc.close(); 
		out.close();
	}

}
