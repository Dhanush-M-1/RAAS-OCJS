import java.util.Scanner;
public class Test {

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n,m,ai,min;
n=sc.nextInt();
m=sc.nextInt();
min=Integer.MAX_VALUE;
for(int i=0;i<n;i++){
ai=sc.nextInt();
if(m%ai==0 && (m/ai)<min)
min=(m/ai);
}
System.out.println(min);

}

}