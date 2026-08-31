import java.util.*;
import java.lang.Math;
public class test
{
public static void main(String[] args)
{
 Scanner sc=new Scanner(System.in);

String one=sc.next();
String two=sc.next();
int n=sc.nextInt();
for(int z=1;z<=n;z++)
{
    System.out.print(one+" "+two);
    System.out.println();
String yy=sc.next();
    String mm=sc.next();
    if(yy.equals(one))
    {
        one=mm;
    }
    else{
        two=mm;
    }}System.out.print(one+" "+two);
    
}}
