#include<bits/stdc++.h>
#include <sys/types.h>
#include <unistd.h>
#define ull unsigned long long int
//#define lli long long int
#define int long long int
#define NUM 1000000007
#define mp make_pair
#define pb push_back
#define ITR ::iterator
#define endl "\n"
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL);
using namespace std;
//ull power(ull x, ull n) {
//   if (n == 0)
//       return 1;
//
//   if (n % 2 == 0) {
//       ull y = power(x, n / 2);
//       return (y * y);
//   }
//   else return ((x * pow(x, n - 1)));
//}
int fact(int n)
{
    int ans = 1;
    while (n)
    {
        ans = (ans * n) % NUM;
        n--;
    }
    return ans;
}
const int maxn = 2e5 + 1;
int dp[10][maxn];
 
int rec(int n, int m)
{
    if (m <= 0 or m < (10 - n)) return 1;
 
    if (dp[n][m] != -1) return dp[n][m];
    if (n + m >= 10) return  dp[n][m] = (rec(1, m - 10 + n) + rec(0, m - 10 + n)) % NUM;
    return dp[n][m];
}
signed main()
{
// #ifndef ONLINE_JUDGE
//     freopen("input.txt", "r", stdin);
//     freopen("output.txt", "w", stdout);
// #endif
    fast_io
    int t;
    cin >> t;
    vector<int> v;
    memset(dp, -1, sizeof dp);
    while (t--) {
        v.clear();
        int i, n, m, ans = 0;
        cin >> n >> m;
        while (n)
        {
            ans += rec(n % 10, m);
            n /= 10;
            ans %= NUM;
        }
        cout << ans << endl;
    }
    return 0;
}