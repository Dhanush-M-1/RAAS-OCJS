
import java.io.*;
import java.util.*;
public class Code534B 
{
	public static void main(String[] args) throws IOException 
	{

		BufferedReader jk = new BufferedReader(new InputStreamReader(System.in)) ;
		StringTokenizer ana = new StringTokenizer(jk.readLine()) ;
		OutputStream out = new BufferedOutputStream ( System.out );
		int n = Integer.parseInt(ana.nextToken()) ;
		Vector<Integer> v= new Vector<Integer>() ;
		for(int i=2 ; i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				int d = n/i ;
				if(d!=i)
				{
					v.add(-d) ; 
				}
				v.add(-i);
			}
		}
		v.add(-n) ;
		Collections.sort(v);
		boolean m[][]= new boolean[n][n] ;
		for(int i=0 ; i<n ;i++)
		{
			String s = jk.readLine() ;
			for(int j=0 ; j<(n/4);j++)
			{
				String d = "" ; 
				d+= s.charAt(j) ;
				Integer g = Integer.valueOf(d,16) ;
				String cb=Integer.toBinaryString(g.intValue());
				for(int h=0 ; h<(4-cb.length()) ;h++) m[i][4*j+h]=false ;
				int u=0 ;
				for(int h=(4-cb.length()) ; h<4 ;h++)
				{
					if(cb.charAt(u)=='1') m[i][4*j+h]=true ;
					else m[i][4*j+h]=false;
					u++;
				}
			}
		}
		
		int resu = 1 ;
		for(int div :v)
		{
			int di = -div ;
			boolean tem =true ; 
			chafi: for(int ui=0 ; ui<=(n-di) ;ui+=(di))
			{
				for(int uj=0 ; uj<=(n-di) ;uj+=(di))
				{
					boolean g = m[ui][uj] ;
					for(int i=ui ; i<ui+di;i++)
					{
						for(int j=uj ; j<uj+di ;j++)
						{
                                 if(m[i][j]!=g)
                                 {
                                	 tem=false ; break chafi ;
                                 }
						}
					}
				}
			}
			if(tem)
			{
				resu=di ; break ;
			}
		}
		System.out.println(resu);
	}

}



