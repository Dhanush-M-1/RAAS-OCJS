import java.util.*;
public class Main{
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        String s=sc.next();
        int c=0;
        for(int i=1;i<=y;i++){
            if(s.charAt(n-i)=='1'){
                c++;
            }
        }
        //System.out.println(c);
        if(s.charAt(n-y-1)=='0'){
            c++;
        }
        //System.out.println(c);
        for(int i=n-y-2;i>n-x-1;i--){
            if(s.charAt(i)=='1'){
                c++;
            }
        }
        System.out.println(c);
        //System.out.println(s.charAt(n-1));
	}
}