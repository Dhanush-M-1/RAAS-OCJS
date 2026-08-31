import java.util.*;

public class c
{
	public static void main(String[] arg)
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int days = in.nextInt();
		int[] weight = new int[size];
		for(int i = 0; i < size; i++)
			weight[i] = in.nextInt();
		int[] arr = new int[days];
		for(int i = 0; i < days; i++)
		{
			arr[i] = in.nextInt()-1;
		}
		int[] stack = new int[size];
		int index = 0;
		boolean[] used = new boolean[size];
		for(int i = 0; i < arr.length; i++)
		{
			if(used[arr[i]])
				continue;
			used[arr[i]] = true;
			stack[index++] = arr[i];
		}
		int answer = simulate(stack, arr, weight);
		System.out.println(answer);
	}

	public static int simulate(int[] begin, int[] days, int[] weight)
	{
		int answer = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		LinkedList<Integer> status = new LinkedList<Integer>();
		for(int i = begin.length-1; i >= 0; i--)
			stack.push(begin[i]);
		for(int i = 0; i < days.length; i++)
		{
			int temp = stack.pop();
			while(temp != days[i])
			{
				answer += weight[temp];
				status.push(temp);
				temp = stack.pop();
			}
			while(status.size() > 0)
			{
				stack.push(status.pop());
			}
			stack.push(temp);
		}
		return answer;
	}


}