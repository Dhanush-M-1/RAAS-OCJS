#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int big = pow(10, 9) + 7, size = 200000;
    int tt;
    cin >> tt;
    vector<ll> dp(size+1);
    dp[0] = 1;
    for (int i = 0; i < size; i++)
    {
        if (i + 9 < size)
            dp[i + 9] = (dp[i + 9] + dp[i]) % big;
        if (i + 10 < size)
            dp[i + 10] = (dp[i + 10] + dp[i]) % big;
    }
    for (int i = 1; i < size; i++)
    {
        dp[i] = (dp[i] + dp[i - 1]) % big;
    }
    while (tt--)
    {
        string s;
        ll m, ans = 0;
        cin >> s >> m;
        ans = s.size();
        vector<ll> num(10);
        for (int i = 0; i < s.size(); i++)
        {
            int n = s[i] - '0';
            num[n]++;
        }
        for (int i = 0; i < 10; i++)
        {
            if (m < (10 - i))
                continue;
            ans = (ans + num[i] * dp[m - (10 - i)]) % big;
        }
        cout << ans << "\n";
    }

    return 0;
}