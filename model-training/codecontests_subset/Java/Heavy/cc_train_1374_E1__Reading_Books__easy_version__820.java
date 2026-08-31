import java.util.*;
import java.io.*;
 
public class Solution{
	static PrintWriter out=new PrintWriter(System.out);
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] input=br.readLine().trim().split(" ");
		
		int n=Integer.parseInt(input[0]);
		int k=Integer.parseInt(input[1]);
		PriorityQueue<Integer> pqAlice=new PriorityQueue<Integer>();
		PriorityQueue<Integer> pqBob=new PriorityQueue<Integer>();
		PriorityQueue<Integer> pqBoth=new PriorityQueue<Integer>();
		
		int countAlice=0;
		int countBob=0;
		
		for(int i=0;i<n;i++) {
			input=br.readLine().trim().split(" ");
			int time=Integer.parseInt(input[0]);
			int alice=Integer.parseInt(input[1]);
			int bob=Integer.parseInt(input[2]);
			
			if(alice==1 && bob==1) {
				countAlice++;
				countBob++;
				pqBoth.add(time);
			}
			else if(alice==1) {
				countAlice++;
				pqAlice.add(time);
			}
			else if(bob==1){
				countBob++;
				pqBob.add(time);
			}
		}
		
		if(countAlice<k || countBob<k) {
			System.out.println("-1");
			return;
		}
		
		countAlice=0;
		countBob=0;
		
		int ans=0;
		while(countAlice<k && countBob<k)
		{
			int option1=Integer.MAX_VALUE;
			if(pqBoth.isEmpty()==false)
			{
				option1=pqBoth.remove();
			}
			int temp1=Integer.MAX_VALUE;
			if(pqAlice.isEmpty()==false)
			{
				temp1=pqAlice.remove();
			}
			int temp2=Integer.MAX_VALUE;
			if(pqBob.isEmpty()==false)
			{
				temp2=pqBob.remove();
			}
			
			int option2=Integer.MAX_VALUE;
			if(temp1!=Integer.MAX_VALUE && temp2!=Integer.MAX_VALUE)
			{
				option2=temp1+temp2;
			}
			
			int min;
			if(option1<=option2)
			{
				min=option1;
				if(temp1!=Integer.MAX_VALUE) {
					pqAlice.add(temp1);
				}
				if(temp2!=Integer.MAX_VALUE)
				{
					pqBob.add(temp2);
				}
			}
			else {
				min=option2;
				if(option1!=Integer.MAX_VALUE) {
					pqBoth.add(option1);
				}
			}
			ans+=min;
			countAlice++;
			countBob++;
		}
		out.println(ans);
		
		out.flush();
		out.close();
	}		
}