import java.util.Scanner;



class Main {
    public static void main (String args[]) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int A[] = new int[n];
	int cnt = 0;
	for(int i = 0;i < n;i++){
	    A[i] = sc.nextInt();		
	}
	for(int i = 0;i < n;i++){
	     cnt+=Prime(A[i]);	    
	}
	System.out.println(cnt);
    }
    public static int Prime(int A){
	if(A == 1) return 0;
	else if(A == 2) return 1;
	else if(A % 2 == 0) return 0;/*ifかも*/
	for(int j = 3;j <= A / j;j+=2){
	    if(A % j == 0) return 0;
	}
	return 1;	    
    }
}














