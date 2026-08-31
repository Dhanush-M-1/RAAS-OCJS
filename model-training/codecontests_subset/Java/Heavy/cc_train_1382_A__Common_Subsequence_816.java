import java.util.*;
public class q1{
	public static int[] intersection(int[] nums1, int[] nums2) {
        int min = Math.min(nums1.length,nums2.length);
        HashSet<Integer> x = new HashSet<Integer>();
        List<Integer> ans = new LinkedList<Integer>(); 
        if(min == nums1.length){
            for(int i = 0; i <  min; i++){
                x.add(nums1[i]);
            }
            for(int i = 0; i < nums2.length; i++){
                if(x.contains(nums2[i])){
                    x.remove(nums2[i]);
                    ans.add(nums2[i]);
                }
            }
        }
        else{
            for(int i = 0; i <  min; i++){
                x.add(nums2[i]);
            }
            for(int i = 0; i < nums1.length; i++){
                if(x.contains(nums1[i])){
                    x.remove(nums1[i]);
                    ans.add(nums1[i]);
                }
            }
        }
        int k = 0;
        int[] result =new  int[ans.size()];
        for(Integer p : ans){
            result[k++] = p;
        }
        return result;
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int z = 0; z < t; z++){
			int n = in.nextInt();
			int m = in.nextInt();
			int[] a = new int[n],b = new int[m];
			for(int i = 0; i < n; i++){
				a[i] = in.nextInt();
			}
			for(int i = 0; i < m; i++){
				b[i] = in.nextInt();
			}
			int[] result = intersection(a,b);
			if(result.length == 0){
				System.out.println("NO");
				continue;
			}
			System.out.println("YES");
			System.out.print(1+" ");
			for(int i = 0; i < result.length; i++){
				System.out.print(result[i]+" ");
				break;
			}
			System.out.println();
		}
	}
}