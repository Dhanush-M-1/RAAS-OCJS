import java.io.*;
import java.util.*;

public class cf268A{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] aa = new int[n][2];

		for(int i=0;i<n;i++){
           int num1 = sc.nextInt();
           int num2 = sc.nextInt();

           aa[i][0] = num1;
           aa[i][1] = num2;
		}
        int c=0;
		for(int i=0;i<n-1;i++){
           for(int j=i+1;j<n;j++){
               if(aa[i][0]==aa[j][1]){
                  c++;
               }

               if(aa[i][1] == aa[j][0]){
                  c++;
               }
           }
		}

		System.out.println(c);
	}
}