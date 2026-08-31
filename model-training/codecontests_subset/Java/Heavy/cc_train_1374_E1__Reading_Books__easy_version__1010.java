import java.io.*;
import java.util.*;
 
public class E1{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        FastReader s=new FastReader();
        int n=s.nextInt();
        int k=s.nextInt();
        int counta=0,countb=0,countab=0,ans=0,temp1,temp2,temp3;
        ArrayList<Integer> arrab = new ArrayList<Integer>();
        ArrayList<Integer> arra = new ArrayList<Integer>();
        ArrayList<Integer> arrb = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            temp1=s.nextInt();
            temp2=s.nextInt();
            temp3=s.nextInt();
            if(temp2==1&&temp3==1){
                arrab.add(temp1);
                countab++;
            } 
            else if(temp2==1&&temp3==0){
                arra.add(temp1);
                counta++;
            } 
            else if(temp2==0&&temp3==1){
                arrb.add(temp1);
                countb++;
            } 
        }
        Collections.sort(arra);Collections.sort(arrb);Collections.sort(arrab);
        temp1=0;temp2=0;temp3=0;
        if((counta+countab)<k||(countb+countab)<k){
            ans=-1;
        }
        else if(counta==0||countb==0){
            for(int i=0;i<k;i++) ans+=arrab.get(i);
        }
        else{
            int i=0,j=0,sum=0;temp3=0;int ext=0;
            while(temp1<k||temp2<k){
                sum=0;ext=0;
                if(i<counta&&j<countb){
                    sum+=(arra.get(i)+arrb.get(j));
                    ext=1;
                } 
                // if(j<countb){
                //     sum+=arrb.get(j);
                //     ext=1;
                // }
                if(!arrab.isEmpty()&&temp3<countab&&(arrab.get(temp3)<=sum||ext==0)){
                    ans+=arrab.get(temp3);
                    temp3++;
                    temp1++;temp2++;
                }
                else{
                    if(temp1<k&&i<counta){
                        ans+=arra.get(i);
                        i++;
                        temp1++;
                    }
                    if(temp2<k&&j<countb){
                        ans+=arrb.get(j);
                        j++;
                        temp2++;
                    }
                }
            }
        }
        System.out.println(ans);
    } 
}