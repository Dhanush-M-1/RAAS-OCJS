import java.util.*;

public class Main {
	public static void main(String[] args) {
	
   Scanner sc = new Scanner(System.in);
   
    int N = sc.nextInt();
    Integer a[] = new Integer[N];
	for (int i=0; i<N; i++) {
		a[i] = sc.nextInt();
	}
	Integer b[] = new Integer[N];
	for (int j=0; j<N; j++) {
		b[j] = sc.nextInt();
	}
	Integer c[] = new Integer[N-1];
	for (int i=0; i<N-1; i++) {
		c[i] = sc.nextInt();
	}
	int m = 0;
	for(int i = 0; i<N; i++) {
		m += b[a[i] - 1];
	}
      for(int j = 0; j<N-1; j++){
        if(a[j] + 1  == a[j + 1]) {
			m += c[a[j] - 1];
		} 
      }
      System.out.println(m);
}
}


