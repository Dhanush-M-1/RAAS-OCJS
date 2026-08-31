import java.io.*;
import java.util.*;
public class Memory {
    
    boolean[]mem;
    int[][]res;
    int in = 0;
    int all = 0;
    public void read()
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int m = s.nextInt();
        mem = new boolean[m+1];
        res = new int[100000][2];
        int i = 0;
        while(i<t)
        {
            String x = s.next();
            int op = 0;
            if(x.equals("alloc")||x.equals("erase"))
                op = s.nextInt();           
            solve(x,op);
            i++;
        }
    }
    public void solve(String x,int op)
    {
        if(x.equals("alloc")) alloc(op);
        else if(x.equals("erase")) erase (op,true);
        else defrag();
    }
    public void defrag()
    {
        int st;
        for (int i = 1; i < res.length; i++) 
        {
            st = res[i][0];
            while(st>1&&!mem[st-1])
            {
                mem[st-1] = true;
                mem[res[i][1]+st-1] = false;
                res[i][0] = res[i][0] - 1;
                st--;
            }
        }       
    }
    public void erase(int op,boolean f)
    {
        if(op<0||op>=res.length||res[op][0]==0) 
        {
            if(f)
                System.out.println("ILLEGAL_ERASE_ARGUMENT");
        }
        else
        {
            int st = res[op][0];
            int siz = res[op][1];
            //System.out.println(st+" "+siz);
            for (int i = st; i <siz+st; i++) 
            {
                mem[i] = false;
            }
            res[op][0] = 0;
            res[op][1] = 0;         
        }
//      for (int i = 1; i < mem.length; i++) {
//          System.out.print(mem[i]+" ");
//      }
//      System.out.println();
    }
    public void alloc(int op)
    {
        if(op<0) System.out.println();
        int a = 0;
        for (int i = 1; i < mem.length; i++)
        {
            if(!mem[i])
            {
                int st = i;             
                for (int j = i; j <op+st; j++) 
                {               
                        if(j<mem.length&&mem[j]) break;
                        i++;
                        if(i>mem.length) break;
                        if(i-st==op) 
                        {
                            a = i - op;
                            break;
                        }
                        if(i>=mem.length) break;
                }
            }
            if(a!=0) break;
        }       
        if(a==0) 
        {
            System.out.println("NULL");
            return;
        }
        else 
        {
            for (int i = a; i <op+a; i++) 
            {
                mem[i] = true;
            }
            all++;
            System.out.println(all);
            res[all][0] = a;
            res[all][1] = op;
        }
    }
    public static void main(String[] args) {
        new Memory().read();
    }

}
