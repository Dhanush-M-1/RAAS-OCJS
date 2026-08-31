import java.util.*;
import java.math.BigInteger;
public class codeforces{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int x=sc.nextInt();
int y=sc.nextInt();
String str=sc.next();
int change=0;
for(int i=n-x;i<n;i++){
    int p=Integer.parseInt(String.valueOf(str.charAt(i)));
    if(i==n-y-1){
        if(p==0){
        
change++;
        }
    }
    else if(p!=0){

        change++;
    }
}
System.out.println(change);
        
} 
}
    

