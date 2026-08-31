import java.io.*;
import java.util.*;


public class Cony {

	public static void main(String[] args) throws IOException
	{
		BufferedReader jk = new BufferedReader(new InputStreamReader(System.in)) ;
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)) ; 
		StringTokenizer ana = new StringTokenizer(jk.readLine()) ; 
		int n = Integer.parseInt(ana.nextToken()) ;
		int m = Integer.parseInt(ana.nextToken()) ;
		int p[] = new int[n] ; 
		int index[]= new int[n] ; 
		ana = new StringTokenizer(jk.readLine()) ; 
		for(int i=0; i<n ;i++)
		{
			int pup = Integer.parseInt(ana.nextToken())-1 ;
			p[i]=pup ; 
			index[pup]=i ; 
		}
		int nas  = p[n-1] ;
		ArrayList<Co> nas_freinds = new ArrayList<>() ; 
		int u[]= new int[m] ; int v[]= new int[m] ; 
		for(int i=0; i<m ;i++)
		{
			ana = new StringTokenizer(jk.readLine()) ; 
			int ue = Integer.parseInt(ana.nextToken())-1 ;
			int ve= Integer.parseInt(ana.nextToken())-1 ;
			u[i]=ue ; v[i]=ve ;
			if(ve==nas) nas_freinds.add(new Co(ue,index[ue])) ; 
		}
		Collections.sort(nas_freinds);
		int num_freinds = nas_freinds.size() ;
		ArrayList<Set<Integer>> nas_friends_friends = new ArrayList<>() ; 
		int friends_number[]= new int[n] ;
		Set<Integer> nas_f = new HashSet<Integer>() ;
		for(int i=0 ; i<num_freinds ;i++)
		{
			int pupil = nas_freinds.get(i).p ;
			friends_number[pupil]=i ;
			nas_f.add(pupil) ;
			nas_friends_friends.add(new HashSet<Integer>()) ; 
		}

		for(int i=0 ; i<m ;i++)
		{
			int pupil = u[i] ;
			if(nas_f.contains(pupil))
			{
				int inde =  friends_number[pupil] ; 
				nas_friends_friends.get(inde).add(v[i]) ;
			}
		}
		int current = n-1 ; 
		int ans = 0 ;
		ch : for(Co ele : nas_freinds)
		{
			int pup = ele.p ;  int pup_index = index[pup] ;
			int num = friends_number[pup] ;
			
			boolean tem = true ;
			
			for(int i=pup_index+1 ;i<current ;i++)
			{
				int pupils = p[i] ;
				
				if(!nas_friends_friends.get(num).contains(pupils)) 
				{
					tem =false ; break ; 
				}
				

			}
           
			if(tem)
			{
				for(int i=pup_index+1 ;i<current ;i++)
				{
					int pupils = p[i] ;
					p[i-1]=pupils ;
					index[pupils]-- ;

				}
				ans++ ;current--;
			}
		
		}
		out.println(ans);
		out.flush();

	}
}
class Co implements Comparable<Co>
{
	int p,index ; 
	Co(int p, int index)
	{
		this.p=p ; this.index=index ; 
	}
	@Override
	public int compareTo(Co o) {
		if(this.index<o.index) return 1 ;
		if(this.index>o.index) return -1 ;
		return 0;
	}
}


