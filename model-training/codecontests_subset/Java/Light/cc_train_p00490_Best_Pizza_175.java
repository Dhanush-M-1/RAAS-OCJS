//package BestPizzia;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int base = sc.nextInt();
		int per = sc.nextInt();
		int basecal = sc.nextInt();
		Integer[] cal = new Integer[N];
		int idx = N;
		int maxcal = 0;
		int parcal;
		for(int i = 0; i < N; i++) cal[i] = sc.nextInt();
		Arrays.sort(cal, Collections.reverseOrder());
		while(true) {
			int sumcal = basecal;
			for(int i = 0; i < idx; i++) sumcal += cal[i];
			parcal = sumcal / (base + per * idx);
			if(maxcal < parcal) maxcal = parcal; 
			idx--;
			if(idx == 0) break;
		}
		if(maxcal < basecal / base) maxcal = basecal / base;
		System.out.println(maxcal);
	}

}