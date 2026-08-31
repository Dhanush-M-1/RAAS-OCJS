import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
 
public class Solving {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a = input.next();
		String b = input.next();
		String c = input.next();
		int [] A = new int[26];
		int [] AA = new int[26];
		int [] B = new int[26];
		int [] C = new int[26];
		int [][] D = new int[100001][2];
		int minc = 0;
		ArrayList<Integer> Bmin = new ArrayList();
		ArrayList<Integer> Cmin = new ArrayList();
		ArrayList<Integer> max = new ArrayList();
		for(int i = 0; i < a.length(); i++){
			A[(int)a.charAt(i)- 'a']++;
		}
		for(int i = 0; i < b.length(); i++){
			B[(int)b.charAt(i)- 'a']++;
		}
		for(int i = 0; i < 26; i++){
			if(B[i] > 0){Bmin.add(A[i]/B[i]);
			}
		}
		int minb = Collections.min(Bmin);
		for(int i = 0; i < c.length(); i++){
			C[(int)c.charAt(i)-'a']++;
		}
		while(minb >= 0){
			for(int r = 0; r < 26; r++){
				AA[r] = A[r];
			}
			for(int i = 0; i < 26; i++){
				
			if(B[i] > 0){AA[i] = A[i] - (minb*B[i]);
			}}
			for(int i = 0; i < 26; i++){
				if(C[i] > 0){Cmin.add(AA[i]/C[i]);}
			}
			minc = Collections.min(Cmin);
			int maxi = minc + minb;
			max.add(maxi);
			D[maxi][0] = minc;D[maxi][1] = minb; 
			minb--;
			Cmin.clear();
		}
		int fmax = Collections.max(max);
		for(int i = 0; i < D[fmax][1];i++){
			for(int j = 0; j < b.length(); j++){
				System.out.print(b.charAt(j));
			}
		}
		if(D[fmax][1]>0){
		for(int i = 0; i < 26; i++){
			if(B[i] > 0){A[i] = A[i] - (B[i]*D[fmax][1]);}
		}}
		for(int i = 0; i < D[fmax][0]; i++){
			for(int j = 0; j < c.length(); j++){
				System.out.print(c.charAt(j));
			}
		}
		if(D[fmax][0]>0){
			for(int i = 0; i < 26; i++){
				if(C[i] > 0){A[i] = A[i] - (C[i]*D[fmax][0]);} 
			}}
		for(int i = 0; i < 26; i++){
			if(A[i] > 0){for(int j = 0; j < A[i]; j++){
				System.out.print((char)(i+97));
			}}}
	}}