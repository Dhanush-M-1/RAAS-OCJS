import java.util.Arrays;
import java.util.Scanner;
public class codeforces{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
            
        for(int tt = 0; tt<t; tt++){
        	int n = sc.nextInt();
            int m = sc.nextInt();
        	
        	int[] A = new int[n];
            int[] B = new int[m];
            
            boolean b = false;
         
           for(int i =0; i<n; i++){
               A[i] = sc.nextInt();
           }
           for(int i =0; i<m; i++){
               B[i] = sc.nextInt();        
           }
           
           for(int i = 0; i< A.length; i++) {
        	   for(int j = 0; j< B.length; j++) {
        		   if(A[i] == B[j]) {
        			   b = true;
        			   System.out.println("YES");
        			   System.out.println("1 " + A[i]);
        			   break;
        		   }
        	   }
        	   if(b)break;
           }
           
           if(!b) {
        	   System.out.println("NO");
           }
        }
    }
}

   