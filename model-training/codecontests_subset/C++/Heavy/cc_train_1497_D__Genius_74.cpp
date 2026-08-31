    #include<stdio.h>
    #include<iostream>
    #include<string.h>
    #include<algorithm>
    #include<queue>
    #include<stack>
    #include<math.h>
    #include<map>
    typedef long long int ll;
    using namespace std;
    #define maxn 0x3f3f3f3f
    #define INF 0x3f3f3f3f3f3f3f3
    ll maps[100500],m[110000];
    ll dp[100005];
    int main()
    {
        ll a,b,c,d,i,j,k,l;
        scanf("%lld",&a);
        while(a--)
        {
            memset(m,0,sizeof(m));
            memset(maps,0,sizeof(maps));
            memset(dp,0,sizeof(dp));
           scanf("%lld",&b);
           for(i=1;i<=b;i++)
           {
               scanf("%lld",&m[i]);
           }
           for(i=1;i<=b;i++)
           {
               scanf("%lld",&maps[i]);
           }
           for(i=2;i<=b;i++)
           {
               for(j=i-1;j>=1;j--)
               {
                   if(m[i]==m[j])
                    continue;
                    k=dp[i];
                    d=dp[j];
                   l=abs(maps[i]-maps[j]);
                   dp[i]=max(dp[i],d+l);
                   dp[j]=max(dp[j],k+l);
               }
           }
           ll ans=0;
           for(i=1;i<=b;i++)
           {
               ans=max(dp[i],ans);
           }
           printf("%lld\n",ans);

        }
    }

