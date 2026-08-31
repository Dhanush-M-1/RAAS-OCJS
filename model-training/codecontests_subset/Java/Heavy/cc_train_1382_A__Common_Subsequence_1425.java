import java.util.*;
public class abc{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t -- > 0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                b[i]=sc.nextInt();
                hs.add(b[i]);
            }
            int i=0,j=0;
            HashMap<Integer,Integer> hm=new HashMap<>();
            int min=Integer.MAX_VALUE;
            int c=0;
            while(i<n){
                if(hs.contains(a[i])){
                    while(j<m){
                        if(a[i]==b[j]){
                            // c++;
                            hm.put(1,a[i]);
                            // if(min>c) min=c;
                            break;
                        }
                        j++;
                    }
                }
                i++;
            }
            // if(min!=Integer.MAX_VALUE){
            if(!hm.isEmpty()){
                System.out.println("YES");
                System.out.println("1 "+hm.get(1));
            }
            else{
                System.out.println("NO");   
            }
        }
    }
}