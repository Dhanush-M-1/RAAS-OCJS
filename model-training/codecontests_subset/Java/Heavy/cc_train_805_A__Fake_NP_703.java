import java.io.*;
import java.util.*;
  
public class Answer 
{ 
   static HashMap<Long,Long> ansmap = new HashMap<>();
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
  
    public static void main(String[] args) 
    { 
        FastReader s=new FastReader(); 
        long first = s.nextLong(); 
        long second = s.nextLong();
        long maxvalue = 0;
        long maxkey = 0;
        long flag = 0;

        // while(first<=second){
        //     findDivisors(first);
        //     first++;
        // }
       // for (HashMap.Entry<Long, Long> entry : ansmap.entrySet()) {
       //  maxvalue = Math.max(entry.getValue(),maxvalue);
       //  if(flag!=maxvalue){
       //      maxkey = entry.getKey();
           
       //  }
       //  flag = maxvalue;
       //  }
        if (first==second) {
            System.out.println(first);

        }else
        System.out.println(2);

        } 

        static void findDivisors(long number){
            for(long i = 2;i<=Math.sqrt(number);i++){
                if(number%i==0){
                    if(ansmap.containsKey(i)){
                        ansmap.replace(i,ansmap.get(i)+1);
                    }else{
                        ansmap.put(i,Long.valueOf(1));
                    }
                }
            }
        }

    }
        
    
