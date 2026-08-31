import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
	int i=0;
	int j=0;
	int tmp;
	int Count_Sort = 0;
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String N_str = br.readLine();
	int N = Integer.parseInt(N_str);
	
	int[] A;
	A = new int[N];
	
	String A_str = br.readLine();
	Scanner sc = new Scanner(A_str).useDelimiter("\\s* \\s*");
	
	while(sc.hasNext()){
	    A[i] = sc.nextInt();
	    i++;
	}

	for(i=0;i<N;i++){
	    int minj = i;
	    for(j=i;j<N;j++){
		if(A[j]<A[minj]){
		    minj = j;
		}
	    }
	    tmp = A[i];
	    A[i] = A[minj];
	    A[minj] = tmp;
	    if(i!=minj) Count_Sort++;
	}
	    

	for(i=0;i<N;i++){
	    System.out.print(A[i]);
	    if(i!=N-1) System.out.print(" ");
	}
	System.out.println("");
	System.out.println(Count_Sort);
	sc.close();
    }
}

