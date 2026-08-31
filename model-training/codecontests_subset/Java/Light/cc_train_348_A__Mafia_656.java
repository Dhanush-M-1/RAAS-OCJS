import java.io.BufferedReader;
import java.io.InputStreamReader;


public class C349 {
    public static void main(String[] args)throws Exception{
        // TODO Auto-generated method stub
        new C349().run();
    }
    
    int[] getArray(String line){
        String[] array=line.split(" ");
        int[] res=new int[array.length];
        for(int i=0;i<res.length;i++)
            res[i]=Integer.parseInt(array[i]);
        return res;
    }
    
    void run() throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        
        reader.readLine();
        int[] numbers=getArray(reader.readLine());
        
        
        System.out.println(getMin(numbers));
        System.out.flush();
        reader.close();
    }
    
    
    long getMin(int[] numbers){
        long max=0;
        for(int i:numbers)
            max+=i;
        
        long d=0;
        long u=max;
        while(u-d>1){
            long mitte=(u+d)/2;
            if(isPos(mitte, numbers))
                u=mitte;
            else
                d=mitte;
        }
        return u;
    }
    
    boolean isPos(long needed, int[] numbers){
        long sum=0;
        for(int i:numbers){
            sum+=(needed-i);
            if(needed<i) return false;
        }
        return sum>=needed;
    }



}
