import java.util.Scanner;

public class pa81 {
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[] no=new int[n];
	String str=sc.next();
	for(int i=0;i<n;i++){
		if(str.charAt(i)=='.'){
			no[i]=0;
		}else{
			no[i]=1;
		}
	}
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n;j++){
			int diff=j-i;
			if(j+3*diff<n && no[i]==no[j]&&no[j]==no[j+diff] &&no[j]==no[j+2*diff] && no[j]==no[j+3*diff] && no[j]==1){
				System.out.println("yes");
				return;
			}
		}
	}
	System.out.println("no");
}
}
