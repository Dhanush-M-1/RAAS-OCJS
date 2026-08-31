import java.io.*;
import java.util.*;
public class Ishu
{
    static Scanner scan = new Scanner(System.in);
    static int block = 0;
    static int[] meme = new int[1];
    static void alloc()
    {
    int m = meme.length;
    int n = scan.nextInt();
    int i;
    int ctr = 0;
    boolean exist = false;
    for(i=0;i<m;++i)
        {
        if(meme[i] == 0)
            ++ctr;
        else
            ctr = 0;
        if(ctr == n)
            {
            exist = true;
            break;
            }
        }
    if(!exist)
        System.out.println("NULL");
    else
        {
        ++block;
        ctr = i - n + 1;
        for(i=0;i<n;++i)
            meme[ctr+i] = block;
        System.out.println(block);
        }
    }
    static void erase()
    {
    int m = meme.length;
    int x = scan.nextInt();
    boolean exist = false;
    int i;
    for(i=0;i<m;++i)
        if(meme[i] == x && meme[i] > 0)
            {
            exist = true;
            meme[i] = 0;
            }
    if(!exist)
        System.out.println("ILLEGAL_ERASE_ARGUMENT");
    }
    static void defragment()
    {
    int m = meme.length;
    int i = 0, j = 0;
    for(i=0;i<m;++i)
        if(meme[i] > 0)
            {
            int data = meme[i];
            meme[i] = 0;
            meme[j++] = data;
            
            }
    }
    static void tc()
    {
    int t,m;
    t = scan.nextInt();
    m = scan.nextInt();
    meme = new int[m];
    while(t-- > 0)
        {
        String query = scan.next();
        if(query.equals("alloc"))
            alloc();
        else if(query.equals("erase"))
            erase();
        else
            defragment();
        }
    }
    public static void main(String[] args)
    {
    int t = 1;
    //t = scan.nextInt();
    while(t-- > 0)
        tc();
    }
}
