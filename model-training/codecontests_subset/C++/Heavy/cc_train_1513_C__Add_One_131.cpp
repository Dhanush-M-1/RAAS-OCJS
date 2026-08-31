#include<bits/stdc++.h>
using namespace std;
#define gc getchar_unlocked
#define fo(i,n) for(int i=0;i<n;i++)
#define Fo(i,k,n) for(int i = k ;i<=n;i++)
#define FO(i,n,k) for(int i = n;i>=k;i--)
#define ll long long
#define si(x)   scanf("%d",&x)
#define sl(x)   scanf("%lld",&x)
#define ss(s)   scanf("%s",s)
#define pi(x)   printf("%d\n",x)
#define pl(x)   printf("%lld\n",x)
#define ps(s)   printf("%s\n",s)
#define deb(x) cout << #x << "=" << x << endl
#define deb2(x, y) cout << #x << "=" << x << "," << #y << "=" << y << endl
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define all(x) x.begin(), x.end()
#define clr(x) memset(x, 0, sizeof(x))
#define mems(a,x) memset(a,x,sizeof(a))
#define sortall(x) sort(all(x))
#define tr(it, a) for(auto it = a.begin(); it != a.end(); it++)
#define PI 3.1415926535897932384626
typedef pair<int, int>  pii;
typedef pair<ll, ll>    pl;
typedef vector<int>     vi;
typedef vector<ll>      vl;
typedef vector<pii>     vpii;
typedef vector<pl>      vpl;
typedef vector<vi>      vvi;
typedef vector<vl>      vvl;
typedef pair<pair<int, int> , int > piii;
mt19937_64 rang(chrono::high_resolution_clock::now().time_since_epoch().count());
int rng(int lim) {
    uniform_int_distribution<int> uid(0, lim - 1);
    return uid(rang);
}
const int mod =   1000000007 ;//998244353; //;
//const int N = 3e5, M = N;
vector<ll> dp;


void solve()
{
    ll n, m;
    cin >> n >> m;



    ll ans = 0;
    while (n > 0)
    {
        ll t = n % 10;
        if (t + m >= 10)
        {
            ans = (ans + dp[m - (10 - t)]) % mod;
        }
        else
        {
            ans = (ans  + 1) % mod;
        }
        // ans = (ans + f(n % 10, m)) % mod;
        n /= 10;
    }
    cout << ans << endl;
    // dp.clear();

}

int main() {
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    srand(chrono::high_resolution_clock::now().time_since_epoch().count());

    int t = 1;
    cin >> t;
    dp.resize(200002, -1);
    fo(i, 10)
    dp[i] = 2;
    dp[9] = 3;
    Fo(i, 10, 200002)
    {
        dp[i] = (dp[i - 10] + dp[i - 9]) % mod;
    }
    while (t--) {
        solve();
    }

    return 0;
}




