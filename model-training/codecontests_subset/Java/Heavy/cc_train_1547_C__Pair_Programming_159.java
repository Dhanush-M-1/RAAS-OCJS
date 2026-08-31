

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class R731_C {
    public static Scanner reader = new Scanner(System.in);
    static int a[] = new int[102];
    static int b[] = new int[102];
    // solution here.
    public static void solve() throws IOException
    {
    	String in1[] = reader.nextLine().split(" ");
    	int k,n,m;
    	k = Integer.parseInt(in1[0]);
    	n = Integer.parseInt(in1[1]);
    	m = Integer.parseInt(in1[2]);
    	String in2[] = reader.nextLine().split(" ");
    	for(int i=0;i<n;i++) {
    		a[i] = Integer.parseInt(in2[i]);
    	}
    	in2 = reader.nextLine().split(" ");
    	for(int i=0;i<m;i++) {
    		b[i] = Integer.parseInt(in2[i]);
    	}
    	int p1=0;int p2=0;
    	int flag=0;
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	while(p1<n || p2<m)
    	{
    		if(p1 == n)
    		{
    			if(b[p2] == 0)
    			{
    				ans.add(b[p2]);
    				k++;
    				p2++;
    			}
    			else
    			{
    				if(b[p2]>k) {
    					flag=1;
    					break;
    				}
    				else
    				{
    					ans.add(b[p2]);
    					p2++;
    				}
    			}
    		}
    		else if(p2 == m)
    		{
    			if(a[p1] == 0)
    			{
    				ans.add(a[p1]);
    				k++;
    				p1++;
    			}
    			else
    			{
    				if(a[p1]>k) {
    					flag=1;
    					break;
    				}
    				else
    				{
    					ans.add(a[p1]);
    					p1++;
    				}
    			}
    		}
    		else
    		{
    			if(a[p1] == 0)
    			{
    				ans.add(a[p1]);
    				k++;
    				p1++;
    			}
    			else if(b[p2] == 0)
    			{
    				ans.add(b[p2]);
    				k++;
    				p2++;
    			}
    			else
    			{
    				if(a[p1]<=k)
    				{
    					ans.add(a[p1]);
    					p1++;
    				}
    				else if(b[p2]<=k)
    				{
    					ans.add(b[p2]);
    					p2++;
    				}
    				else
    				{
    					flag=1;
    					break;
    				}
    			}
    		}
    	}
    	if(flag == 1)
    		System.out.println("-1");
    	else
    	{
    		for(int i=0;i<ans.size();i++)
    			System.out.print(ans.get(i)+" ");
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
        
        final int cases;
        try {
            cases = Integer.parseInt(reader.nextLine().trim());
            for (int i = 0; i < cases; i++) {
//            	System.out.println();
            	String tmp = reader.nextLine();
                solve();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}