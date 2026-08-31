#include <bits/stdc++.h>
int main()
{
    int t;
    std::cin>>t;
    while(t--)
    {
        int n;
        std::cin>>n;
        std::vector<long long> a(n),b(n),dp(n,0);
        for(int i=0;i<n;i++)
        std::cin>>a[i];
        for(int i=0;i<n;i++)
        std::cin>>b[i];
        for(int j=1;j<n;j++)
        for(int i=j-1;i>=0;i--)
        {
            if(a[i]==a[j])
            continue;
            long long u=dp[i],v=dp[j],p=abs(b[i]-b[j]);
            dp[i]=std::max(dp[i],v+p);
            dp[j]=std::max(dp[j],u+p);
        }
        std::cout<<*max_element(dp.begin(),dp.end())<<'\n';
    }
    return 0;
}