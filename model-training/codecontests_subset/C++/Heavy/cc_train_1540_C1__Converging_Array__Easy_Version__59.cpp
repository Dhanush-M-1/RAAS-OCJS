// #pragma comment(linker, "/stack:200000000000")
#pragma GCC optimize("Ofast")
// #pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")

#include <bits/stdc++.h> 

using namespace std;
using i128 = __int128_t;
using u128 = __uint128_t;
using u64 = uint64_t;

//define
#define int long long
#define ll int
#define trav(i,v)   for(auto i: v)
#define rep(i,n)    for(int i=0;i<n;i++)
#define repu(i,k,n) for(int i=k;i<=n;i++)
#define repd(i,k,n) for(int i=k;i>=n;i--)
#define se second
#define fi first
#define pb push_back
#define mp make_pair
#define all(v)  v.begin(), v.end()
#define itn int 
#define sz(x) (int)x.size()
    
//typedef
typedef unsigned long long ull;
typedef long double ld;
typedef std::pair<int, int> pii;
typedef std::vector<int> vi;
typedef std::vector< pii > vii;
typedef std::vector< std::vector<int> > vvi;
typedef std::vector< std::pair < pii, int > > vpp;
 
const long long MOD = 1000000007;
// const long long MOD = 998244353;
const long double PI = 3.141592653589793238;
const long long pi = 31415926;
const long long inf = 1000000000000000000;
const long long small_inf = INT_MAX;
const int N = 200;

int modpow(int x, int n = MOD-2, int mod = MOD){ int res=1; while(n>0){ if(n&1) res=res*x%mod; x=x*x%MOD; n>>=1;} return res;}
int power(int x, int n){ int res=1; while(n>0){ if(n&1) res=res*x; x=x*x; n>>=1; } return res;}
int add(int x, int y){ return (x+y)%MOD; }
int mult(int x, int y){ return (x*y)%MOD; }

void init(){
    
}



void solve()
{
/*Don't hurry, nothing good comes if you rush*/
    int n;
    cin>>n;
    vi c(n+1,0);
    vi b(n+1,0);
    repu(i,1,n){
        cin>>c[i];
    }
    repu(i,1,n-1){
        cin>>b[i];
    }
    int q;
    cin>>q;
    int y;
    vi sum(n+1,0);
    vi v(n+1,0);
    cin>>y;
    v[1] = y;
    repu(i,2,n){
        v[i] = v[i-1]+b[i-1];
    }
    repu(i,1,n){
        sum[i] = sum[i-1]+v[i];
    }
    vvi dp(n+1,vi(10001,0));
    repu(i,max(0ll, sum[1]),c[1]){
        dp[1][i] = 1;
    }
    repu(i,2,n){
        repu(x,0,c[i]){
            repd(j,10000,max(x,sum[i])){
                dp[i][j] += dp[i-1][j-x];
                dp[i][j] %= MOD;
            }
        }
    }
    int ans = 0;
    repd(i,10000,max(0ll, sum[n])){
        ans += dp[n][i];
        ans %= MOD;
    }
    cout<<ans<<endl;
}

void clear_global(){

}

signed main(){
    // #ifndef ONLINE_JUDGE
    //    freopen("./input.txt", "r", stdin);
    //    freopen("./output.txt", "w", stdout);
    // #endif
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);

    int t23 = 1, tt23 = 1; 
    // cin>>t23;
    init();
    while(tt23<=t23)
    {
        // cout<<"Case #"<<tt23<<": ";
        solve();
        tt23++;
        clear_global();
    }
    cerr << "Time : " << 1000 * ((double)clock()) / (double)CLOCKS_PER_SEC << "ms\n";
}   