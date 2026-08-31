// package EducationalRound85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemD {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        StringBuilder print=new StringBuilder();
        while(test--!=0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            long l=Long.parseLong(st.nextToken());
            long r=Long.parseLong(st.nextToken());
            long sum[]=new long[n+1];
            build(sum);
            int ind=search(sum,l,n);
            if(ind==-1){
                print.append("1\n");
                continue;
            }
            long rem=l-sum[ind-1];
            long end=(1l*n*(n-1))+1;
//            System.out.println(end);
            if(rem%2==0){
                long p=ind;
                long curr=p+rem/2;
                boolean chance=false;
                while(l<=r){
                    if(l==end){
                        print.append("1");
                        break;
                    }
                    if(chance){
                        print.append(p+" ");
                        chance=false;
                    }
                    else{
                        print.append(curr+" ");
                        chance=true;
                        curr++;
                        if(curr>n){
                            p++;
                            curr=p+1;
                        }
                    }
                    l++;
                }
            }
            else{
                long p=ind;
                long curr=p+rem/2+1;
                boolean chance=true;
                while(l<=r){
                    if(l==end){
                        print.append("1");
                        break;
                    }
                    if(chance){
                        print.append(p+" ");
                        chance=false;
                    }
                    else{
                        print.append(curr+" ");
                        chance=true;
                        curr++;
                        if(curr>n){
                            p++;
                            curr=p+1;
                        }
                    }
                    l++;
                }
            }
            print.append("\n");
        }
        System.out.print(print.toString());
    }
    public static void build(long sum[]){
        int n=sum.length-1;
        for(int i=1;i<=n;i++){
            long curr=2l*(n-i);
            sum[i]=sum[i-1]+curr;
        }
        return;
    }
    public static int search(long sum[],long l,int n){
        int ans=-1;
        int low=1,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sum[mid]>=l){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
