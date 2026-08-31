#include <bits/stdc++.h>
using namespace std;
//define ONLINE_JUDGE
#ifndef ONLINE_JUDGE
#define debug(x) cout << #x <<'\t' << x <<endl
#else
#define debug(x)
#endif
typedef long long ll;
typedef unsigned long long ull;
const ll mod = 1e9 + 7;
const double eps = 1e-8;
const ll LINF = 0x3f3f3f3f3f3f3f3f;
#define fast ios::sync_with_stdio(false);cin.tie(0);cout.tie(0)
typedef pair<int, int> pii;
const int INF = 0x3f3f3f3f;
#define lowbit(x) ((x) & -(x))
#define mem(a, b) memset(a, b, sizeof(a))
#define PI acos(-1)
#define endl '\n'
#define lson l, mid, rt << 1
#define rson mid + 1, r, rt << 1 | 1
//#define int long long
//ll gcd(ll a, ll b){a = abs(a);b = abs(b);return a == 0 ? b : gcd(b % a, a);}
//inline ll Pow(ll a, ll n, ll MOD) { ll t = 1; a %= MOD; while (n > 0) { if (n & 1) t = t * a % MOD; a = a * a % MOD, n >>= 1; } return t % MOD; }
#define int long long
const int maxn = 2e5+100;
int a[20][maxn];

ll solve(int x,int m)
{
    if(a[x][m]!=-1) return a[x][m];
    if(x+m<10) return 1;
    ll res = 0;
    res += solve(1,m-(10-x));
    res %= mod;
    res += solve(0,m-(10-x));
    res %= mod;
    return a[x][m] = res;
}

signed main()
{
    #ifndef ONLINE_JUDGE
    freopen("in.txt", "r", stdin);
    // freopen("out.txt", "w", stdout);
    #endif
    fast;
    int T;
    cin>>T;
    mem(a,-1);
    while(T--){
        int n,m;
        cin>>n>>m;
        ll res = 0;
        while(n){
            res += solve(n%10,m);
            res = res%mod;
            n /= 10;
        }
        cout<<res<<endl;

    }
    return 0;
}