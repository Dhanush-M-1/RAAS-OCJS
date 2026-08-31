import java.util.Arrays;
import java.util.Scanner;

public class b551 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		String c = in.next();
		int[] aa = new int[27];
		int[] bb = new int[27];
		int[] cc = new int[27];
		for(char k : a.toCharArray()){
			aa[k-'a']++;
		}
		//System.out.println(Arrays.toString(aa));
		for(char k : b.toCharArray()){
			bb[k-'a']++;
		}
		//System.out.println(Arrays.toString(bb));
		for(char k : c.toCharArray()){
			cc[k-'a']++;
		}
		//System.out.println(Arrays.toString(cc));
		int max = 0;
		int maxb = 0;
		int maxc = 0;
		for(int bees = 0; bees < a.length()+5; bees++){
			int[] aclone = new int[27];
			boolean alright = true;
			for(int i = 0; i < aa.length; i++){
				aclone[i]=aa[i]-(bb[i]*bees);
				
				if(aclone[i]<0){
					alright = false;
					break;
				}
			}
			if(!alright){
				break;
			}
		//	System.out.println(Arrays.toString(aclone));
			int cmin = Integer.MAX_VALUE;
			for(int i = 0; i < aa.length; i++){
				cmin = Math.min(cmin, cc[i]>0?aclone[i]/cc[i]:cmin);
			}
			if(bees+cmin>max){
				maxb = bees;
				maxc = cmin;
				max = bees+cmin;
			}
		}
//		System.out.println(maxb);
//		System.out.println(maxc);
		int[] aclone = new int[27];
		for(int i = 0; i < aa.length; i++){
			aclone[i]=aa[i]-(bb[i]*maxb);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < maxb; i++){
			sb.append(b);
		}
		//System.out.println(sb);
		for(int i = 0; i < aa.length; i++){
			aclone[i]=aclone[i]-(cc[i]*maxc);
		}
		for(int i = 0; i < maxc; i++){
			sb.append(c);
		}
		//System.out.println(sb);
		//System.out.println(Arrays.toString(aclone));
		for(int i = 0; i < aa.length; i++){
			for(int j = 0; j < aclone[i]; j++){
				sb.append((char)(i+'a'));
			}
		}
		System.out.println(sb.toString().trim());
	}

}
