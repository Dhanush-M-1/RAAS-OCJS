import java.util.Scanner;

public class Main{

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[105];
        int n = in.nextInt();
	int x = 1, y = 2, z = 3;
	for(int i = 1; i <= n; i++){
	    int val = in.nextInt();
	    if(val == x){
	      int tmp = y;
	      y = z;
	      z = tmp; 
	    }
	    else if(val == y){
		int tmp = x;
		x = z;
		z = tmp;
	    }
	    else{
	        System.out.println("NO");
		System.exit(0);
	    }
	}
	System.out.println("YES");
        
    }
    
}
