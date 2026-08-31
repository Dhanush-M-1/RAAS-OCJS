import java.io.*;
import java.util.*;

public class CodeForcesChessTest {
    public static void main (String[] args) throws IOException {
 Scanner sc=new Scanner(System.in);
 int n=sc.nextInt();
 int temp=3;
 for(int i=0;i<n;i++){
 	int a=sc.nextInt();
 	if(a==temp){
 		System.out.println("NO");
 		System.exit(0);
 	}
 	if(a==1)
 		temp=temp==2?3:2;
 	else if(a==2)
 		temp=temp==1?3:1;
 	else if(a==3)
 		temp=temp==1?2:1;
 }
 System.out.println("YES");
}
   
}