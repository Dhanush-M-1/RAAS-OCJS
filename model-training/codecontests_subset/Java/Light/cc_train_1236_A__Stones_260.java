import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0){
		    int a=scan.nextInt();
		    int b=scan.nextInt();
		    int c=scan.nextInt();
		    int count=0;
		    
		    while(c>=2 && b>=1){
		            count+=3;
		            b--;
		            c-=2;
		    }
		    while(a>=1 && b>=2){
		            a--;
		            b-=2;
		            count+=3;
		    }
		    System.out.println(count);
		}
	}
}