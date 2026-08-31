import java.util.*;
public class Main{
public static void main(String [] args){  
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int x = sc.nextInt();
int y = sc.nextInt();
int z=0;
if((n*y)%100!=0)z=1;

int need = (n*y)/100+z;
if(need>x)
System.out.print(need-x);
else
System.out.print(0);
}
}