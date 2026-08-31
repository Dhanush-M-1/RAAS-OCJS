import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    ArrayList<Integer> ar1 = new ArrayList<Integer>();
		    int m = sc.nextInt();
		    ArrayList<Integer> ar2 = new ArrayList<Integer>();
		    for(int i = 0; i<n; i++) ar1.add(sc.nextInt());
		    for(int i = 0; i<m; i++) ar2.add(sc.nextInt());
		    Collections.sort(ar1);
		    Collections.sort(ar2);
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    for(int i = 0; i<n; i++){
		        for(int j = 0; j<m; j++){
		            int x = ar1.get(i);
		            int y = ar2.get(j);
		            if(x==y) res.add(x);
		            else if(y>x) break;
		        }
		    }
		    int len = res.size();
		    if(len>0){
		        System.out.println("YES");
		        System.out.print(1+" "+res.get(0));
		        System.out.println();
		    }
		    else{
		        System.out.println("NO");
		    }
		}
	}
}
