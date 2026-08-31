//#pragma GCC optimize("Ofast")
//#pragma GCC optimize("unroll-loops")
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using db = double;
using ld = long double;
template<typename T> using V = vector<T>;
template<typename T> using VV = vector<vector<T>>;
template<typename T> using PQ = priority_queue<T>;
#define fs first
#define sc second
#define pb push_back
#define mp make_pair
#define mt make_tuple
#define eb emplace_back
#define lb(c, x) distance((c).begin(), lower_bound(all(c), (x)))
#define ub(c, x) distance((c).begin(), upper_bound(all(c), (x)))
#define all(v) (v).begin(),(v).end()
#define siz(v) (ll)(v).size()
#define rep(i,a,n) for(ll i=a;i<(ll)(n);++i)
#define repr(i,a,n) for(ll i=n-1;(ll)a<=i;--i)
#define ENDL '\n'
typedef pair<int,int> Pi;
typedef pair<ll,ll> PL;
constexpr ll mod = 1000000007; // 998244353;
constexpr ll INF = 1000000099;
constexpr ll LINF = (ll)(1e18 +99);
const ld PI = acos((ld)-1);
constexpr ll dx[4]={-1,0,1,0},dy[4]={0,1,0,-1};
template<typename T,typename U> inline bool chmin(T& t, const U& u){if(t>u){t=u;return 1;}return 0;}
template<typename T,typename U> inline bool chmax(T& t, const U& u){if(t<u){t=u;return 1;}return 0;}
template<typename T> inline T gcd(T a,T b){return b?gcd(b,a%b):a;}
inline void Yes() { cout << "Yes" << ENDL; }
inline void No() { cout << "No" << ENDL; }
inline void YES() { cout << "YES" << ENDL; }
inline void NO() { cout << "NO" << ENDL; }

template<typename T,typename Y> inline T mpow(T a, Y n) {
  T res = 1;
  for(;n;n>>=1) {
    if (n & 1) res = res * a;
    a = a * a;
  }
  return res;
}

template <typename T>
vector<T> finddivisor(T x) {  //整数xの約数(xを含む)
  vector<T> divisor;
  for(T i = 1; (i * i) <= x; i++) {
    if(x % i == 0) {
      divisor.push_back(i);
      if(i * i != x) { divisor.push_back(x / i);}
    }
  }
  sort(divisor.begin(), divisor.end());
  return divisor;
}

template <typename T> V<T> prefix_sum(const V<T>& v) {
  int n = v.size();
  V<T> ret(n + 1);
  rep(i, 0, n) ret[i + 1] = ret[i] + v[i];
  return ret;
}


template<typename T>
T rand(T l,T r){
  static random_device rd;
  static mt19937 g(rd());
  return uniform_int_distribution<T>(l,r)(g);
}

template<typename T>
istream& operator >> (istream& is, vector<T>& vec){
  for(auto&& x: vec) is >> x;
  return is;
}

template<typename T,typename Y>
ostream& operator<<(ostream& os,const pair<T,Y>& p){
  return os<<"{"<<p.fs<<","<<p.sc<<"}";
}

template<typename T> ostream& operator<<(ostream& os,const V<T>& v){
  os<<"{";
  for(auto e:v)os<<e<<",";
  return os<<"}";
}

template<typename ...Args>
void debug(Args&... args){
  for(auto const& x:{args...}){
    cerr<<x<<' ';
  }
  cerr<<ENDL;
}

ll dp[5010]={};

signed main(){
  cin.tie(0);cerr.tie(0);ios::sync_with_stdio(false);
  cout<<fixed<<setprecision(20);
  int qq;cin>>qq;
  while(qq--){
    ll n;cin>>n;
    V<ll> t(n),s(n);cin>>t>>s;

    rep(i,0,n)dp[i]=0;

    rep(i,0,n){
      repr(j,0,i)if(t[i]!=t[j]){
        ll dpi=dp[i],dpj=dp[j];
        chmax(dp[j],dpi+abs(s[i]-s[j]));
        chmax(dp[i],dpj+abs(s[i]-s[j]));
      }
    }

    ll ans=0;
    rep(i,0,n)chmax(ans,dp[i]);
    cout<<ans<<ENDL;
  }
}
//(・_・)(・_・)(・_・)(・_・)
//CHECK overflow,what to output?
//any other simpler approach?