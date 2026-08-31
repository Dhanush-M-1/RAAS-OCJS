import java.io.*;
import java.util.*;
import java.lang.Math.*;
public class Main
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(l == r ? l : 2);
    }
}