#include <iostream>
#include <cstring>

constexpr int N = 5010;
long long int dp[N][2];
int tag[N];
int s[N];

int main()
{
    int T;
    std::cin>>T;
    while(T--)
    {
        int n;
        std::cin>>n;

        for(int i=0;i<n;i++) scanf("%d", tag+i);
        for(int i=0;i<n;i++) scanf("%d", s+i);

        memset(dp, 0, sizeof(dp));
        int cur = 1, pre = 0;
        for(int i=0;i<n;i++)
        {
            std::swap(cur, pre);
            for(int j=i-1;j>=0;j--) dp[j][cur] = dp[j][pre];
            for(int j=i-1;j>=0;j--)
            {
                if(tag[i] == tag[j])continue;
                dp[j][cur] = std::max(dp[j][pre], dp[i][cur] + std::abs(s[i] - s[j]));
                dp[i][cur] = std::max(dp[i][cur], dp[j][pre] + std::abs(s[i] - s[j]));
            }
        }

        long long int res = 0;
        for(int i=0;i<n;i++)res = std::max(res, dp[i][cur]);
        std::cout<<res<<std::endl;
    }

    return 0;
}
