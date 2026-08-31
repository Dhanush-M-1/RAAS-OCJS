import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main
 {
	public static void main (String[] args) throws Exception
	 {
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
     	int t = Integer.parseInt(br.readLine());
     	while(t-- > 0){
     	    int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][n];
            for(int i = 0; i<n; i++){
                String num[] = br.readLine().split("");
                for(int j = 0; j<n; j++){
                    if((i==0 && j==0) || (i==n-1 && j==n-1))
                        continue;
                    arr[i][j] = Integer.parseInt(num[j]);
                }
            }
            int startRight = arr[0][1];
            int startBottom = arr[1][0];
            int destLeft = arr[n-1][n-2];
            int destTop = arr[n-2][n-1];
            if(startBottom==startRight){
                if(startRight==destLeft && startRight==destTop){
                    pw.println(2);
                    pw.println(1+" "+2);
                    pw.println(2+" "+1);
                }
                else if(startRight==destLeft && startRight!=destTop){
                    pw.println(1);
                    pw.print(n+" ");
                    pw.println(n-1);
                }
                else if(startRight!=destLeft && startRight==destTop){
                    pw.println(1);
                    pw.println(n-1+" "+n);
                }
                else{
                    pw.println("0");
                }
            }
            else if(destLeft==destTop) {
                if(startRight==destLeft && startBottom!=destTop){
                    pw.println(1);
                    pw.println(1+" "+2);
                }
                else if(startRight!=destLeft && startBottom==destTop){
                    pw.println(1);
                    pw.println(2+" "+1);
                }
                else{
                    pw.println("0");
                }
            }
            else {
                if(startBottom==destLeft){
                    pw.println(2);
                    pw.println(2+" "+1);
                    pw.println(n-1+" "+n);
                }
                else if(startBottom==destTop){
                    pw.println(2);
                    pw.println(2+" "+1);
                    pw.print(n+" ");
                    pw.println(n-1);
                }
                else{
                    pw.println("0");
                }
            }
     	}
        pw.flush();	 
	 }
}