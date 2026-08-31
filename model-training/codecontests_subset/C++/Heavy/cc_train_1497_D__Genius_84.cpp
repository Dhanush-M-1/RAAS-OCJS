#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 5005;
int T, N, tag[maxn], s[maxn];
ll dp[maxn];

int main()
{
    scanf("%d", &T);
    while (T--)
    {
        scanf("%d", &N);
        for (int i = 1; i <= N; ++i)
            scanf("%d", tag + i);
        for (int i = 1; i <= N; ++i)
            scanf("%d", s + i);
        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= N; ++i)
            for (int j = i - 1; j; --j)
            {
                if (tag[i] == tag[j])
                    continue;
                ll xi = dp[i], xj = dp[j], d = abs(s[i] - s[j]);
                dp[i] = max(dp[i], xj + d), dp[j] = max(dp[j], xi + d);
            }
        printf("%lld\n", *max_element(dp + 1, dp + N + 1));
    }
    return 0;
}

