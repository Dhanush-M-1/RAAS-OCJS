import java.util.*;
public class JavaApplicationM{


public static void main(String[] args) {

Scanner in=new Scanner(System.in);

long a=in.nextInt(),b=in.nextInt(),c=a,r=0;

while(a>=b)
{
c=c+a/b;

a=a/b+a%b;

}


System.out.println(c);

}}
