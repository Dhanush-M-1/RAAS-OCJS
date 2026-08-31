#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> ii;
typedef pair<ll, ii> iii;
typedef string str;
typedef vector<ll>  vl;
typedef vector< vector<ll> > vvl;
typedef vector<ii> vii;
typedef vector< vector<ii> > vvii;
typedef vector<iii> viii;
typedef vector< vector<iii> > vviii;
typedef vector<str>  vs;
typedef vector< vector<str> > vvs;
typedef long double ld;
typedef priority_queue<long long> pq;
/*
Hiiden Function
__gcd()
__builtin_clz(x)
__builtin_ctz(x)
__builtin_popcount(x)

*/

//typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds;
// debugging Function
#define error(args...) { string _s = #args; replace(_s.begin(), _s.end(), ',', ' '); stringstream _ss(_s); istream_iterator<string> _it(_ss); err(_it, args); }

void err(istream_iterator<string> it) {}
template<typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
	cerr << *it << " = " << a << endl;
	err(++it, args...);
}


#define LSOne(S) ( (S) & -(S))
#define elif else if
#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define FOR(i,v) for(auto i:v)
#define rep(i,a,b) for(int i=(a);i<(b);i++)
#define rrep(i,a,b) for(int i=(a);i>=(b);i--)
#define repin(i,a,b,x) for(int i=(a);i<(b);i+=x)
#define repnin(i,a,b,x) for(int i=(a);i<=(b);i+=x)
#define MAX(a,b) a=max(a,b)
#define MIN(a,b) a=min(a,b)
#define fbo find_by_order
#define ook order_of_key
#define ALL(v) v.begin(),v.end()
#define FILL(arr,x) memset(arr,x,sizeof arr);
// if else int i = (number <0) ? 1:0 -  if (number <0) i=1 else 0
const ll MOD = 1e9 + 7;
const ll INF = 1e9;
const ld EPS = 1e-9;


int main()
{
 //ios_base::sync_with_stdio(0);
 //cin.tie(0);
 //cout.tie(0);
 //freopen("UT.txt","w",stdout);
    int t;
    cin >> t;

    while(t--){
        int n;
        cin >> n;
        ll tag[n];
        ll s[n];
        rep(i,0,n) cin >> tag[i];
        rep(i,0,n) cin >> s[i];


        ll dp[n];
        FILL(dp,0);
        rep(i,0,n){
           rrep(j,i-1,0){
               if(tag[i]==tag[j]) continue;
               ll dpi = dp[i];
               MAX(dp[i],dp[j]+abs(s[i]-s[j]));

               MAX(dp[j],dpi+abs(s[i]-s[j]));
          //cout << dp[i] << endl;
           }
        }
        ll ans=0;
        rep(i,0,n) MAX(ans,dp[i]);
        cout << ans << endl;

    }
}
