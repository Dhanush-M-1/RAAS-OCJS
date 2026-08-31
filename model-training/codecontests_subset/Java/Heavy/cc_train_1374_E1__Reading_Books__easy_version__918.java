import java.util.*;
import java.io.IOException;
public class P1374E1 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int k = sc.nextInt();

			PriorityQueue<Integer> alice = new PriorityQueue<>();
			PriorityQueue<Integer> bob = new PriorityQueue<>();
			PriorityQueue<Integer> both = new PriorityQueue<>();

			for(int i=0; i<n ; i++) {
				int ti = sc.nextInt();
				int ai = sc.nextInt();
				int bi = sc.nextInt();

				if(ai==1 && bi==1)
					both.add(ti);
				else if(ai==1)
					alice.add(ti);
				else if(bi==1)
					bob.add(ti);
			}
			
			int aliceK = k, bobK = k;
			long output = 0;
			while(!both.isEmpty() && (aliceK>0 && bobK>0)) {
				if(alice.isEmpty() || bob.isEmpty() || (both.peek() < alice.peek()+bob.peek())) {
					output += both.poll()*1L;
				} else {
					output += (alice.poll()*1L + bob.poll());
				}
				aliceK--; bobK--;
			}

			while(aliceK>0 && !alice.isEmpty()) {
				output += (alice.poll()*1L);
				aliceK--;
			}

			while(bobK>0 && !bob.isEmpty()) {
				output += (bob.poll()*1L);
				bobK--;
			}

			if(bobK>0 || aliceK>0)
				output = -1;
			System.out.println(output);
	}
}
