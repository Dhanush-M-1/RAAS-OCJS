import java.util.*;
public final class B{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        char[] cAry=in.next().toCharArray();
        HashMap<String,Integer> fmap=new HashMap<String,Integer>();
        for(int i=0;i<cAry.length-1;i++)
        {
            String key=new String(new char[]{cAry[i],cAry[i+1]});
            if(!fmap.containsKey(key))
            {
                fmap.put(key,1);
            }
            else
            {
                fmap.put(key,fmap.get(key)+1);
            }
        }
        int max=0;
        String maxKey="-1";
        for(String aKey:fmap.keySet())
        {
            int val=fmap.get(aKey);
            if(val>max)
            {
                max=val;
                maxKey=aKey;
            } 
        }
        System.out.println(maxKey);
    }
}