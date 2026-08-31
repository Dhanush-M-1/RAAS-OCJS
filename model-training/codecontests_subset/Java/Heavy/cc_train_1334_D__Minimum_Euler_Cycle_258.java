import java.io.IOException;
import java.io.InputStream;


public class Solution {
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            long n = in.nextInt();
            long l=in.nextLong();
            long r=in.nextLong();
            if(l==r && l==(n*(n-1)+1)){
                sb.append("1\n");
                continue;
            }
            long i=1;
            long start=2*(n-1),incr=start-2;
            for(i=1;i<n;i++){
                if(l<=start)
                    break;
                start=start+incr;
                incr-=2;
            }
            start=start-incr-2;
            long z=l-start;
            if(z%2==0){
                sb.append(i+z/2).append(" ");
                l++;
                z++;
            }

            if(r<=start+incr+2){
                for(long m=l;m<=r;m++){
                    if(m%2==1)
                        sb.append(i).append(" ");
                    else
                        sb.append(i+z/2).append(" ");
                    z++;
                }
                continue;
            }

            for(long m=l;m<=(start+incr+2);m++){
                //System.out.println(z);
                if(m%2==1)
                    sb.append(i).append(" ");
                else
                    sb.append(i+z/2).append(" ");
                z++;
            }

            l=start+incr+3;
            i++;

            if(l==r && l==(n*(n-1)+1)){
                sb.append("1\n");
                continue;
            }

            start+=incr+2;
            z=1;
            for(long m=l;m<=r;m++){
                if(m%2==1){
                    sb.append(i).append(" ");
                }
                else
                    sb.append(i+z/2).append(" ");


                if(m==(start+incr)){
                    start=start+incr;
                    i++;
                    incr-=2;
                    z=0;
                }
                z++;
                if(m==(n*(n-1)))
                    break;
            }

            if( r==(n*(n-1)+1)) {
                sb.append("1\n");
                continue;
            }
            sb.append("\n");



        }
        System.out.print(sb);


    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
