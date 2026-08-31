import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class codeforces {
    static book[] b;
    static book[] C;
	public static void main(String[] args) {
			
     scanner in  = new scanner();
     int n = in.nextInt();
     int m = in.nextInt();
     int bob = in.nextInt();
     int alice = bob;
     long cost = 0;
     b= new book[n];
     ArrayList<book> oo = new ArrayList<>();
     ArrayList<book> oz = new ArrayList<>();
     ArrayList<book> zo = new ArrayList<>();
     ArrayList<book> zz = new ArrayList<>();
     for(int i = 0;i<n;i++)
     {
    	 b[i] = new book();
    	 b[i].time = in.nextInt();
    	 b[i].alice = in.nextInt();
    	 b[i].bob = in.nextInt();
    	 b[i].color = "red";
    	 if(b[i].alice==1 && b[i].bob==1)
    		 oo.add(b[i]);
     }
     C = b.clone();
     int Too = 0;
     com c = new com();
     Arrays.sort(b,c);
     int count = 0;
     int i = 0;
   //  System.out.println(b[5].time+" "+C[5].time);
     Collections.sort( oo,c);
     while(i<n && (alice>0 || bob>0))
     {
    	 alice-=b[i].alice;
    	 bob-=b[i].bob;
    	 b[i].color = "green";
    	 count++;
    	 cost += b[i].time;
    	 if(b[i].alice==0 && b[i].bob==0)
    		 zz.add(b[i]);
    	 if(b[i].alice==0 && b[i].bob==1)
    		 zo.add(b[i]);
    	 if(b[i].alice==1 && b[i].bob==0)
    		 oz.add(b[i]);
    	 if(b[i].alice==1 && b[i].bob==1)
    		 Too++;
    	 i++;
     }
     boolean no = alice<=0?(bob<=0?true:false):(false);
    // System.out.println(count);
      if(count>m && no)
     {
    	 while(count!=m && i>0)
    	 {
    		if(alice<0 && bob==0)
    		{
    			 i--;
    			if(b[i].bob==0)
    			{
    				alice+=b[i].alice;
    				b[i].color = "red";
    				cost-=b[i].time;
    	    		count--;
    	    		if(b[i].alice==0)
    	    			zz.remove(zz.size()-1);
    	    		if(b[i].alice==1)
    	    			oz.remove(oz.size()-1);
    			}
    		}
    		else if(alice==0 && bob<0)
    		{
    			 i--;
    			if(b[i].alice==0)
    			{
    				bob+=b[i].bob;
    				b[i].color = "red";
    				cost-=b[i].time;
    	    		count--;
    	    		if(b[i].bob==0)
    	    			zz.remove(zz.size()-1);
    	    		if(b[i].bob==1)
    	    			zo.remove(zo.size()-1);
    			}
    		}
    		else
    		{
    			if(zz.size()>=1)
    			{
    			  if(oz.size()>=1 && zo.size()>=1 && oo.size()>Too)
    			  {
    			  if(zz.get(zz.size()-1).time>(oz.get(oz.size()-1).time+zo.get(zo.size()-1).time-oo.get(Too).time))
    			   {
    				cost-=zz.get(zz.size()-1).time;
    				zz.remove(zz.size()-1).color = "red";
    				count--;
    			   }
    			  else
    			    {
    				cost-=(oz.get(oz.size()-1).time+zo.get(zo.size()-1).time-oo.get(Too).time);
    				oz.remove(oz.size()-1).color = "red";
    				zo.remove(zo.size()-1).color = "red";
    				oo.get(Too++).color = "green";
    				count--;
    			    }
    			  }
    			  else
    			  {
    				  cost-=zz.get(zz.size()-1).time;
      				zz.remove(zz.size()-1).color = "red";
      				count--;
    			  }
    			}
    			else
    			{
    				if(oz.size()>=1 && zo.size()>=1 && oo.size()>Too)
      			  {
      				cost-=(oz.get(oz.size()-1).time+zo.get(zo.size()-1).time-oo.get(Too).time);
      				oz.remove(oz.size()-1).color = "red";
      				zo.remove(zo.size()-1).color = "red";
      				oo.get(Too++).color = "green";
      				count--;
      			  }
    				else
    					break;
    			}
    		}
    	 }
     }
     else if(count<m && no)
     {
    	 while(count!=m && i<n)
    	 {
    		b[i].color = "green";
    		count++;
    		cost+=b[i].time;
    		i++;
    	 }
     }
      if(count==m && no)
      {
      System.out.println(cost);
       for(int z = 0;z<n;z++)
    	   if(C[z].color =="green")
    	   System.out.print((z+1)+" ");
      }
      else
    	  System.out.println(-1);
     
 }
}
class com implements Comparator<book>
{

	@Override
	public int compare(book o1, book o2) {
		// TODO Auto-generated method stub
		return o1.time-o2.time;
	}
	
}
class book
{
	int time;
	int alice;
	int bob;
	String color;
}
class scanner
{
	BufferedReader br ;
	StringTokenizer st;
	
	public scanner()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = null;
	}
	 public String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }
	public int nextInt()
	{
		return Integer.parseInt(next());
	}
	public long nextLong()
	{
	  return	Long.parseLong(next());
	}
}