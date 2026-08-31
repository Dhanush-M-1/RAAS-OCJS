import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hm = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		try {
			int n = Integer.parseInt(br.readLine());
			int result = 1;
			for(int i = 0 ; i<n; i++)
			{
				String[] temp = new String[2];
				temp = br.readLine().split(" ");
				pq.add(Integer.parseInt(temp[0]));
				hm.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));		
			}
			
			int index = pq.poll();
			for(int i = 1 ; i<n; i++)
			{
				int temp = pq.poll();
				if(temp-hm.get(temp) > index)
				{
					index = temp;
					result++;
				}
				else if(i+1 <= n-1 &&temp+hm.get(temp) <pq.peek())
				{
					index = temp+hm.get(temp);
					result++;
				}
				else if(i == n-1)
				{
					result++;
				}
				else
				{
					index = temp;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
