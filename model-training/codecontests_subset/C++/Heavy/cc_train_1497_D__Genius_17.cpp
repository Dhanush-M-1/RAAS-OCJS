#include <algorithm>
#include <cmath>
#include <cstdio>
#include <cstring>
#include <list>
#include <map>
#include <iostream>
#include <iomanip>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>
#define LL long long
#define inf 0x3f3f3f3f
#define INF 0x3f3f3f3f3f3f
#define PI 3.1415926535898
#define F first
#define S second
#define endl '\n'
#define lson rt << 1
#define rson rt << 1 | 1
#define lowbit(x) (x & (-x))
#define f(x, y, z) for (int x = (y), __ = (z); x < __; ++x)
#define _rep(i, a, b) for (int i = (a); i <= (b); ++i)
#define _per(i, a, b) for (int i = (a); i >= (b); --i)
using namespace std;

const int maxn = 5007;
const int mod = 1e9 + 7;
int n, k;
int tag[maxn], s[maxn];
LL dp[maxn];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--)
    {
        cin >> n;
        _rep(i, 0, n + 5) dp[i] = 0;
        _rep(i, 1, n)
        {
            cin >> tag[i];
        }
        _rep(i, 1, n) cin >> s[i];
        LL ans = 0;
        _rep(i, 1, n)
        {
            _per(j, i - 1, 1)
            {
                if (tag[i] == tag[j])
                {
                    continue;
                }
                LL tmp = abs(s[i] - s[j]);
                LL dpi = dp[i], dpj = dp[j];
                dp[i] = max(dp[i], dpj + tmp);
                dp[j] = max(dp[j], dpi + tmp);
                ans = max(ans, max(dp[i], dp[j]));
            }
        }
        cout << ans << endl;
    }
}