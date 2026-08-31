#include<bits/stdc++.h>
#include <unordered_map>
using namespace std;
#define _USE_MATH_DEFINES
# define M_PI           3.14159265358979323846  /* pi */
#define ll long long 
#define ld long double 
#define vbe(v) ((v).begin()), ((v).end())
#define sz(v)     ((int)((v).size()))
#define clr(v, d)   memset(v, d, sizeof(v))
#define rep(i, v)   for(int i=0;i<sz(v);++i)
#define lp(i, n)    for(int i=0;i<(int)(n);++i)
#define lpi(i, j, n)  for(int i=(j);i<(int)(n);++i)
#define lpd(i, j, n)  for(int i=(j);i>=(int)(n);--i)
#define MIN(x, y) (((x) < (y)) ? (x) : (y))  
#define FASTIO ios_base::sync_with_stdio(false); cin.tie(NULL); cin.tie(0);
#define INFLL 1e18
#define INF 1e9
#define MOD 1000000007
ll GCD(ll a, ll b) { return (a) ? GCD(b % a, a) : b; }
ll LCM(ll a, ll b) { return a * b / GCD(a, b); }
ll fastpow(ll b, ll p) { if (!p) return 1; ll ret = fastpow(b, p >> 1); ret *= ret; if (p & 1) ret *= b; return ret; }
const int mxN = 3e5;
ll dp[mxN];
ll gaser(ll n)
{
    if (n < 10) return 1;
    ll &ret = dp[n];
    if (ret != 0) return ret;
    return ret = (gaser(n - 9)%MOD + gaser(n - 10)%MOD)%MOD;
}
void solve()
{
    int n, m;
    cin >> n >> m;
    string str = to_string(n);
    ll ans = 0;
    lp(i, str.length())
    {
        ans = (ans % MOD + gaser(str[i] - '0'+m) % MOD) %MOD;
    }
    cout <<ans;
}
int main()
{

    FASTIO;
    //freopen("input.txt", "r", stdin);

    int t;
    cin >> t;
    while (t--)
    {
        solve();
        cout << "\n";
    }
}