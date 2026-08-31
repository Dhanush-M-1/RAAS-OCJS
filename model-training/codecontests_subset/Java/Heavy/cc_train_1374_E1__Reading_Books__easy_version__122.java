import java.util.PriorityQueue;
import java.util.Scanner;

public class E1
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		PriorityQueue<Integer> bs = new PriorityQueue<Integer>();
		PriorityQueue<Integer> as = new PriorityQueue<Integer>();
		PriorityQueue<Integer> abs = new PriorityQueue<Integer>();
		PriorityQueue<Integer> os = new PriorityQueue<Integer>();
		
		int atotal = 0;
		int btotal = 0;
		int total = 0;
		
		for(int i=0;i<n;i++)
		{
			int temp = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==0 && b==0)
				os.add(temp);
			else if(a==0 && b==1)
				bs.add(temp);
			else if(a==1 && b==0)
				as.add(temp);
			else
				abs.add(temp);
			
		}
		
		boolean val = true;
		
		while(atotal<k && btotal<k && val)
		{
			if(btotal>=k)
			{
				
				if(as.size()>0 && abs.size()>0)
				{
					if(as.peek()<=abs.size())
					{
						total+=as.poll();
						atotal++;
					}
					else
					{
						total+=abs.poll();
						atotal++;
						btotal++;
					}
				}
				else if(as.size()>0 && abs.size()==0)
				{
					total+=as.poll();
					atotal++;
				}
				else if(as.size()==0 && abs.size()>0)
				{
					total+=abs.poll();
					atotal++;
					btotal++;
				}
				else
					val = false;
				
				
			}
			else if(atotal>=k)
			{
				if(bs.size()>0 && abs.size()>0)
				{
					if(bs.peek()<=abs.peek())
					{
						total+=bs.poll();
						btotal++;
					}
					else
					{
						total+=abs.poll();
						atotal++;
						btotal++;
					}
				}
				else if(bs.size()>0 && abs.size()==0)
				{
					total+=bs.poll();
					btotal++;
				}
				else if(bs.size()==0 && abs.size()>0)
				{
					total+=abs.poll();
					atotal++;
					btotal++;
				}
				else
					val = false;
			}
			else
			{
				
				if( as.size() > 0 && bs.size()>0 && abs.size()>0 && (as.peek()+bs.peek())<abs.peek() )
				{
					total+=as.poll();
					total+=bs.poll();
					atotal++;
					btotal++;
				}
				else if(as.size()>0 && bs.size()>0 && abs.size()>0 && (as.peek()+bs.peek())>=abs.peek())
				{
					total+=abs.poll();
					atotal++;
					btotal++;
				}
				else if( as.size()>0 && bs.size()>0 && abs.size()==0 )
				{
					total+=as.poll();
					total+=bs.poll();
					atotal++;
					btotal++;
				}
				else if((as.size()==0 || bs.size()==0) && abs.size()>0 )
				{
					total+=abs.poll();
					atotal++;
					btotal++;
				}
				else
					val = false;
				
			}
		}
		
		System.out.println(val?total:-1);
		
	}
	
}
