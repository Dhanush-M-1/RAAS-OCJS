import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long n = Long.parseLong(st.nextToken());
        TreeMap<Long, Long > fact = descomposicionPrima(n);
        int con = 0;

        long a=-1, b=-1 ;
        for(Entry<Long, Long> x : fact.entrySet()){
            con+= x.getValue();
            if(x.getValue()>=2)
            {
                a=x.getKey();
                b = x.getKey();
            }
            else{
                if(a== -1)
                    a = x.getKey();
                else if(b==-1)
                    b = x.getKey();
            }

        }
        if(con <= 1){
            System.out.println(1);
            System.out.println(0);
        }
        else if(con == 2){
            System.out.println(2);
        }else{
            System.out.println(1);
            System.out.println(a*b);
        }

    }

    static TreeMap<Long, Long> descomposicionPrima (long n){
        TreeMap<Long, Long>  res = new TreeMap<Long, Long>();
        long cont , i , R , N ;
        for(cont = 0 , i = 2 ,R = (long) Math.sqrt(n), N = n; N> 1 && i<= R; ++i ){
            if( N %i == 0){
                cont++;
                N/=i; i--;
            }else if(cont>0){
                res.put(i, cont);
                cont=0;
            }
        }
        if(cont>0)res.put(i, cont);
        if(N != 1) res.put(N, 1L);

        return res;
    }
}
