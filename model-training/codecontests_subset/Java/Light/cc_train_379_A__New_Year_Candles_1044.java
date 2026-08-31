import java.io.*;
import java.util.*;
public class A{
    public static void main(String[] args)
    {
    Scanner infile = new Scanner(System.in);
    int a = infile.nextInt();
    int b = infile.nextInt();
    int c = 0;
    int count = 0;
    while(a>0)
    {
    count+=a;
    c+=a;
    a = 0;
    a += c/b;
    c%=b;
    }
    System.out.println(count);
    }
}