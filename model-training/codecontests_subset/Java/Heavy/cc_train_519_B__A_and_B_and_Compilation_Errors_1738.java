import java.util.*;

public class Codechef {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=in.nextInt();
        for(int i=0;i<n-1;i++){
            int a=in.nextInt();
            if(map.containsKey(a))
                map.put(a,map.get(a)+1);
            else
                map.put(a, 1);
        }
        int val=0;
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                System.out.println(arr[i]);
                val=arr[i];
                break;
            }
            if(map.get(arr[i])==1)
                map.remove(arr[i]);
            else
                map.put(arr[i],map.get(arr[i])-1);
        }
        map.clear();
            map.put(val, 1);
            for(int i=0;i<n-2;i++){
                int a=in.nextInt();
                if(map.containsKey(a))
                    map.put(a,map.get(a)+1);
                else
                    map.put(a, 1);
            }
            for(int i=0;i<n;i++){
                if(!map.containsKey(arr[i])){
                    System.out.println(arr[i]);
                    val=arr[i];
                    break;
                }
                if(map.get(arr[i])==1)
                    map.remove(arr[i]);
                else
                    map.put(arr[i],map.get(arr[i])-1);
            }
    }
}