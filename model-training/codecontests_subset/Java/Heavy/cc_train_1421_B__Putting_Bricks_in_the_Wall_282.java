import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; 

public class Solution {

   static ArrayList<ArrayList<Integer>> list;
	static int count=0;
	public static void main(String[] args)
    {
		FastReader fr=new FastReader();
         int t=fr.nextInt();
         while(t-->0) {
        	 int n=fr.nextInt();
        	 char a[][]=new char[n][n];
        	 for(int i=0;i<n;i++) {
        		 String s=fr.next();
        		 for(int j=0;j<n;j++) {
        			 a[i][j]=s.charAt(j);
        		 }
        	 }
        	 ArrayList<Integer> li=new ArrayList<>();
        	 ArrayList<Integer> lj=new ArrayList<>();
        	 if(a[0][1]==a[1][0]) {
        		 int count=0;
        		 if(a[n-1][n-2]==a[0][1])
        		 {
        			 li.add(n-1);
        			 lj.add(n-2);
        				 count++;
        		 }
        		 if(a[n-2][n-1]==a[0][1]) {
        			 li.add(n-2);
        			 lj.add(n-1);
        			 count++;
        		 }
        		 System.out.println(count);
        		 for(int i=0;i<li.size();i++) {
        			 System.out.println((li.get(i)+1)+" "+(lj.get(i)+1));
        		 }
        	 }
        	 else {
        		 int count=0;
        		 if(a[n-1][n-2]==a[n-2][n-1]) {
        			 char c=a[n-1][n-2];
        			 if(a[1][0]==c) {
        				 li.add(1);
        				 lj.add(0);
        				 count++;
        			 }
        			 if(a[0][1]==c) {
        				 li.add(0);
        				 lj.add(1);
        				 count++;
        			 }
        			 
        		 }
        		 else {
        			 
        			 if(a[n-1][n-2]==a[1][0]) {
        				 count+=2;
        				 li.add(1);
        				 lj.add(0);
        				 li.add(n-2);
        				 lj.add(n-1);
        				 //System.out.println("KOK");
        				
        			 }
        			 else if(a[n-1][n-2]==a[0][1]) {
        				 count+=2;
        				 li.add(0);
        				 lj.add(1);
        				 li.add(n-2);
        				 lj.add(n-1);
        				// System.out.println("KK");
        			 }
        			 else if(a[n-2][n-1]==a[1][0]) {
        				 count+=2;
        				 li.add(1);
        				 lj.add(0);
        				 li.add(n-1);
        				 lj.add(n-2);
        				 //System.out.println("LK");
        			 }
        			 else {
        				 count+=2;
        				 li.add(0);
        				 lj.add(1);
        				 li.add(n-1);
        				 lj.add(n-2);
        				 //System.out.println("KJ");
        			 }
        			 
        			 
        			 //System.out.println();
        		 }
        		 System.out.println(count);
    			 for(int i=0;i<li.size();i++) {
    				 System.out.println(li.get(i)+1+" "+(lj.get(i)+1));
    			 }
        	 }
         }
		
    }

}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }
 
    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt()
    {
        return Integer.parseInt(next());
    }
 
    long nextLong()
    {
        return Long.parseLong(next());
    }
 
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
 
    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}