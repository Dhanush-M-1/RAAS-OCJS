import java.util.*;
public class SinIsh1 {
public static void main(String [] args){
Scanner in = new Scanner(System.in);
int n=in.nextInt();
int a=0;
int b=0;
for(int i=0;i<n;i++){
int c=in.nextInt();
if(c==200)
a++;
if(c==100)
b++;
}
if(n==1)
System.out.print("NO");
else if(a%2!=0&& b<2)
System.out.print("NO");
else if(a%2!=0&&b%2!=0||a%2==0&&b%2!=0)
System.out.println("NO");
else
System.out.println("YES");
}
}