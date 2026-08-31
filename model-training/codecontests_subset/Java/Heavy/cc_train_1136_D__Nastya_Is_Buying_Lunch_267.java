import java.util.*;
import java.math.*;

// **** D. Nastya Is Buying Lunch ****

public class D {
	static char [] in = new char [10000];
	static long HF = 300001L;
	public static void main (String [] arg) throws Throwable {
		int n = nextInt();
		int m = nextInt();
		int [] LINE = new int [n];
		//int [] LINEPOS = new int [n+1];
		//long [][] pairs = new long [m][2];
		//int [] cnt = new int [n+1];
		HashSet<Long> canSwitch = new HashSet<Long>(4*m);
		//int [][] canSwitchAt = int [n+1][];
		for (int i = 0; i<n; ++i) {
			LINE[i] = nextInt();
			//LINEPOS[LINE[i]] = i;
		}
		for (int i = 0; i<m; ++i) {
			long L0 = nextInt();
			long L1 = nextInt();
			//pairs[i][0] = Math.max(L0,L1);
			//pairs[i][1] = Math.min(L1,L0);
			canSwitch.add(L0 * HF + L1);
			//canSwitch.add(L1 * HF + L0);
			/*
			int I0 = (int)L0;
			int I1 = (int)L1;
			if (I0 < I1) {
				cnt[I1]++;
			} else {
				cnt[I0]++;
			}
			*/
		}
		/*
		for (int i = 0; i<n; ++i) canSwitchAt[i] = new int[cnt[i]];
		for (int i = 0; i<m; ++i) {
			int P1 = pairs[i][0];
			int P2 = pairs[i][1];
			cnt[P2]--;
			canSwitchAt[P2][cnt[P2]] = P1;
		}
		for (int i = 0; i<n; ++i) Arrays.sort(canSwitchAt[i]);
		*/
		
		// Calculate answer
		int ans = 0;
		long nastya = LINE[n-1];
		int nastya_pos = n-1;
		//System.err.println("Nastya init at " + nastya_pos);
		//boolean [] used = new boolean [n];
		int pos = n-1;
		for (pos = n-2; pos >= 0; --pos) {
			long P1 = LINE[pos];
			if (canSwitch.contains( P1 * HF + nastya)) {
				//System.err.println("Student " + P1 + " Definitely Switches with Nastya");
				ans++;
				nastya_pos--;
			} else {
				break;
			}
		}
		//System.err.println("Nastya is now at " + nastya_pos);
		
		for (pos = nastya_pos-1; pos>=0; --pos) {
			boolean can_do = true;
			long P0 = LINE[pos];
			if (!canSwitch.contains(P0 * HF + nastya)) continue;
			
			for (int seek_pos = pos+1; seek_pos < nastya_pos && can_do; ++seek_pos) {
				//if (used[seek_pos]) continue;
				long P1 = LINE[seek_pos];
				if (!canSwitch.contains(P0 * HF + P1)) {
					//System.err.println("Student " + P0 + " CANT switch with student " + P1);
					can_do = false;
				} else {
					//System.err.println("Student " + P0 + " can switch with student " + P1);
				}
			}
			if (can_do) {
				//System.err.println("Student " + P0 + " will switch with Nastya");
				LINE[pos] = LINE[nastya_pos-1];
				nastya_pos--;
				ans++;
			}
		}
		System.out.println(ans);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/************** FAST IO CODE FOLLOWS *****************/
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 45) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static String next() throws Throwable {
		int i = 0; while (i < 42 && i != -1) i = System.in.read(); int cptr = 0; while (i >= 42) { in[cptr++] = (char)i; i = System.in.read();}
		return new String(in, 0,cptr);
	}
	/**** LIBRARIES ****/
	public static long gcdL(long a, long b) {while (b != 0) {long tmp = b;b = (a % b);a = tmp;}return a;}
	public static int gcd(int a, int b) {while (b != 0) {int tmp = b;b = (a % b);a = tmp;}return a;}
}

/* Full Problem Text:
  
At the big break Nastya came to the school dining room.
There are n pupils in the school, numbered from 1 to n.
Unfortunately, Nastya came pretty late, so that all pupils had already stood in the queue, i.e.
Nastya took the last place in the queue.
Of course, it's a little bit sad for Nastya, but she is not going to despond because some pupils in the queue can agree to change places with some other pupils.
Formally, there are some pairs u, v such that if the pupil with number u stands directly in front of the pupil with number v, Nastya can ask them and they will change places.
Nastya asks you to find the maximal number of places in queue she can move forward.


 */