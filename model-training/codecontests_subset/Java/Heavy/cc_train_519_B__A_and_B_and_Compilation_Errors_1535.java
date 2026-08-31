import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AAndBCompilationErrors {
	
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int N=Integer.parseInt(br.readLine());
	int A[]=new int[N];
	int B[]=new int[N-1];
	int C[]=new int[N-2];
	StringTokenizer t=new StringTokenizer(br.readLine());
	for(int i=0;i<N;i++){
		A[i]=Integer.parseInt(t.nextToken());
	}
	Arrays.sort(A);
	StringTokenizer t1=new StringTokenizer(br.readLine());
	for(int i=0;i<N-1;i++){
		B[i]=Integer.parseInt(t1.nextToken());
	}
	Arrays.sort(B);
	StringTokenizer t2=new StringTokenizer(br.readLine());
	for(int i=0;i<(N-2);i++){
		C[i]=Integer.parseInt(t2.nextToken());
	}
	Arrays.sort(C);
	int cnt=0;
	
	for(int i=0;i<(N-1);i++){
		if(A[i]!=B[i]){
			System.out.println(A[i]);
			cnt=1;
			break;
		}
	}
	
	if(cnt==0){
		System.out.println(A[N-1]);
	}
	
	cnt=0;
	for(int i=0;i<(N-2);i++){
		if(C[i]!=B[i]){
			System.out.println(B[i]);
			cnt=1;
			break;
		}
	}
	
	if(cnt==0){
		System.out.println(B[N-2]);
	}
	
}
}
