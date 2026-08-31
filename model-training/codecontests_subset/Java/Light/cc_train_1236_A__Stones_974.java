import java.util.Scanner;

public class Stone {
public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0){
           int ans = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            while(b>0 && c>1){
               b-=1;
               c-=2;
               ans++;
               }
               while(a>0&&b>1){
               	a-=1;
               	b-=2;
               	ans++;
               }
               System.out.println(3*ans);
           }
           
		}
	}
