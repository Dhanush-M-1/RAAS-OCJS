
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author workzone
 */
public class books_stack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        int ar[]=new int[n];
        int br[]=new int[m];
        HashMap<Integer,Integer> weight=new HashMap<Integer,Integer>();
        for(int i=0;i<n;++i)
        {
            ar[i]=sc.nextInt();
            weight.put(i+1, ar[i]);
        }
        
        for(int i=0;i<m;++i)
        {
            br[i]=sc.nextInt();
        }
        Stack<Integer> s=new Stack<Integer>();
        HashMap map=new HashMap();
        int ans=0;
        for(int i=0;i<m;++i)
        {
            int num=br[i];
            if(!map.containsKey(num))
            {
                Stack<Integer> temp=new Stack<Integer>();
                while(!s.empty())
                {
                    temp.push(s.peek());
                    ans+=weight.get(s.peek());
                    s.pop();
                }
                while(!temp.empty())
                {
                    s.push(temp.peek());
                    temp.pop();
                }
                s.push(num);
                map.put(num, num);
            }
            else
            {
                Stack<Integer> temp=new Stack<Integer>();
                while(s.peek()!=num)
                {
                    temp.push(s.peek());
                    ans+=weight.get(s.peek());
                    s.pop();
                }
                s.pop();
                while(!temp.empty())
                {
                    s.push(temp.peek());
                    temp.pop();
                }
                s.push(num);
            }
        }
        System.out.println(ans);
    }
}
