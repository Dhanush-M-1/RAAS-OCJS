import java.util.*;
public class Main{
public static void main(String[] args) {
  Scanner input=new Scanner(System.in);
  int n=input.nextInt();
  int x=input.nextInt();
  int y=input.nextInt();
  String s=input.next();
    int ans=0;
	for(int i=n-1;i>=n-x;--i){
		if(i==n-1-y){
			if(s.charAt(i)=='0') ans++;
		}
		else{
			if(s.charAt(i)=='1') ans++;
		}
	}
   System.out.println(ans);
   input.close();
}
}