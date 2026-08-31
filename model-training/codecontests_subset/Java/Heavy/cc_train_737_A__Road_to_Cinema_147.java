/** This is a solution to the problem Road To Cinema (729C) on codeforces.com
 * 
 * Given:
 * - n cars with price c_i and fuel tank volume v_i
 * - k gas stations along a road of length s, at given positions
 * - timelimit t
 * 
 * Fuel stations are free and instant. Each car has two speeds: 2min/km with 1l/km, and 1min/km with 2l/km. Speed can be changed any time. Cars are fully tanked.
 * What is the cheapest car with which the road can be passed in time?
 * 
 * For details, see:
 * http://codeforces.com/problemset/problem/729/C
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RoadToCinema {
	/*
	 * Ideas: if s > t, print -1 (not possible)
	 * As the speed can be changed any time, every average speed a, 1/km <= a <= 2/km is possible, with corresponding fuel usage (3 - a) / km
	 * Sort cars by tank volume, sort gas stations by position. O(n log n) O(k log k)
	 * Keep two pointers, one to car with minimum possible tank volume, on to car with maximum possible tank volume.?
	 * Iterate through stations. Very every car between the first one able to make it and the first one able to make it at full speed:
	 * 							 update the minimum time required to get there. 
	 * If timelimit is exceeded OR cars are not able to make it at slow speed, increase first pointer. 
	 * If cars are not able to make it at full speed, increase second pointer. O(n*k)
	 * Print cheapest car in range O(n)
	 * 
	 * Better: Sort cars and stations, binary search on cars to get smallest volume car which gets there in time. O(n log n + k log k + k log n)
	 * 
	 * O(k) possible? for each distance, compute range [minvolume, maxvolume], with corresponding times [mintime, maxtime], do same as above without the cars. Possible?
	 */
	
	private static class Car implements Comparable<Car> {
		public int price;
		public int volume;
		
		Car(int p, int v) {
			price = p;
			volume = v;
		}
		
		@Override
		public int compareTo(Car o) {
			return this.volume - o.volume;
		}
	}
	
	private boolean isInTime(int volume, List<Integer> stations, int length, int timeLimit) {
		int cur = 0;
		int k = stations.size();
		int time = 0;
		for(int i = 0; i < k; ++i) {
			int dist = stations.get(i) - cur;
			if(dist > volume) return false;		// not able to make this distance, even at slow speed
			else if(2*dist <= volume) time += dist;	// can make it at full speed, then do it
			else { // dist <= volume < 2*dist -> spend volume/dist liters per km at average speed of (3 - volume/dist)
				time += 3*dist - volume;
			}
			if(time > timeLimit) return false;
			cur = stations.get(i);
		}
		return true;
	}
	
	private void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		// read cars
		List<Car> cars = new ArrayList<Car>(n);
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			cars.add(new Car(p, v));
		}
		
		// read stations
		st = new StringTokenizer(br.readLine());
		List<Integer> stations = new ArrayList<Integer>(k);
		for(int i = 0; i < k; ++i) {
			stations.add(Integer.parseInt(st.nextToken()));
		}
		br.close();
		
		Collections.sort(cars);
		Collections.sort(stations);
		
		stations.add(s);
		
		// binary search on cars to get FIRST car which can do it in time
		int left = 0; int right = n;
		while(left < right) {
			// invariant: the last item for which property does not hold is in [left, right)
			int mid = (left + right)/2;
			if(isInTime(cars.get(mid).volume, stations, s, t)) { // first must be on the left
				right = mid;
			} else {
				left = mid + 1;									// first must be on the right
			}
		}
		int pos = right;
		
		if(pos >= n) System.out.println("-1");
		else {
			int minPos = pos;
			for(pos++; pos < n; ++pos) {
				if(cars.get(minPos).price > cars.get(pos).price) {
					minPos = pos;
				}
			}
			
			System.out.println(cars.get(minPos).price);
		}
		
	}
	public static void main(String[] args) throws IOException {
		new RoadToCinema().solve();
	}
}
