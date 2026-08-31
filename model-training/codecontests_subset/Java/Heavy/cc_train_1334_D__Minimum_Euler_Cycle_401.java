import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer out = new StringBuffer();

        int t=in.nextInt();

        label:
        while(t--!=0) {

            long n=in.nextLong();

            long l=in.nextLong(),
                 r=in.nextLong();

            long cnt=0;
            long i;
            for(i=1L; i<=n; i++) {
                if(l<=cnt+((n-i)<<1))
                    break;
                cnt+=((n-i)<<1);
            }

            for(; i<=n && cnt<=r; i++) {
                for(long j=i+1; j<=n && cnt<=r; j++) {
                    cnt+=1;
                    if(l<=cnt && cnt<=r)
                        out.append(i+" ");
                    cnt+=1;
                    if(l<=cnt && cnt<=r)
                        out.append(j+" ");
                }
            }

            cnt+=1;
            if(l<=cnt && cnt<=r)
                out.append(1+" ");

            out.append("\n");
        }

        System.out.println(out);
    }
}