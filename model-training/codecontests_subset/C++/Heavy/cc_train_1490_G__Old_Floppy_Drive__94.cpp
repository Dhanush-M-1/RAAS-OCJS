//#include <atcoder/all>
//using namespace atcoder;
//using mint = modint;

#include <bits/stdc++.h>
#define int long long
#define sint signed
#define endl "\n" // fflush(stdout);
#define ALL(v) (v).begin(),(v).end()
#define Vi vector<int>
#define VVi vector<Vi>
#define VVVi vector<VVi>
#define Vm vector<mint>
#define VVm vector<Vm>
#define Vs vector<string>
#define Vd vector<double>
#define Vc vector<char>
#define Pii pair<int,int>
#define Pdd pair<double,double>
#define VPii vector<Pii>
#define Tiii tuple<int,int,int>
#define VTiii vector<Tiii>
#define PQi priority_queue<int>
#define PQir priority_queue<int,vector<int>,greater<int>>
#define pb push_back
#define mp make_pair
#define mt make_tuple
#define itos to_string
#define stoi stoll
#define FI first
#define SE second
#define cYES cout<<"YES"<<endl
#define cNO cout<<"NO"<<endl
#define cYes cout<<"Yes"<<endl
#define cNo cout<<"No"<<endl
#define cyes cout<<"yes"<<endl
#define cno cout<<"no"<<endl
#define sortr(v) sort(v,greater<>())
#define rep(i,a,b) for(int i=a;i<b;i++)
#define repeq(i,a,b) for(int i=a;i<=b;i++)
#define repreq(i,a,b) for(int i=a;i>=b;i--)
#define dem(a,b) ((a+b-1)/(b))
#define INF 3000000000000000000 // 3.0*10^18
#define MAX LLONG_MAX
#define PI acos(-1.0L)

using namespace std;

/* debug */
template <typename T>
ostream& operator<<(ostream& os,const vector<T> &V){int N=V.size();
if(N==0){os<<'.';return os;}rep(i,0,N-1){os<<V[i]<<' ';}os<<V[N-1];return os;}
template <typename T>
ostream& operator<<(ostream& os,const vector<vector<T>> &V){
int N=V.size();rep(i,0,N-1)os<<V[i]<<endl;os<<V[N-1];return os;}
template <typename T,typename S>
ostream& operator<<(ostream& os, pair<T,S> const&P){os<<P.FI<<' '<<P.SE;return os;}
//ostream& operator<<(ostream& os, mint const&M){os<<M.val();return os;}

/* useful */
template<typename T>void Vin(vector<T> &v){int n=v.size();rep(i,0,n)cin>>v[i];}
int scomb(int n, int r){if(r<0||r>n)return 0;if((n-r)<r)r=n-r; // nCr
int a=1;for(int i=n;i>n-r;--i){a=a*i;}for(int i=1;i<r+1;++i){a=a/i;}return a;}
int digit_sum(int n){int ret=0; while(n>0){ret+=n%10;n/=10;}return ret;}
int digit(int k,int i){string s = itos(k);return s[s.size()-i]-'0';}
template<typename T>void press(T &v){v.erase(unique(ALL(v)),v.end());}
int SMALLER(Vi &a,int x){return lower_bound(a.begin(),a.end(),x)-a.begin();}
int orSMALLER(Vi &a,int x){return upper_bound(a.begin(),a.end(),x)-a.begin();}
int BIGGER(Vi &a,int x){return a.size()-orSMALLER(a,x);}
int orBIGGER(Vi &a,int x){return a.size()-SMALLER(a,x);}
int COUNT(Vi &a,int x) {return upper_bound(ALL(a),x)-lower_bound(ALL(a),x);}
int maxind(Vi &a){return max_element(ALL(a))-a.begin();}
int minind(Vi &a){return min_element(ALL(a))-a.begin();}
template<typename T>bool chmax(T &a,T b) {if(a<b){a=b;return 1;}return 0;}
template<typename T>bool chmin(T &a,T b) {if(a>b){a=b;return 1;}return 0;}
/*
Vi zip(Vi b){int Z=b.size();
Pii p[Z+10];int a=b.size();Vi l(a);for(int i=0;i<a;i++)
p[i]=mp(b[i],i);sort(p,p+a);int w=0;for(int i=0;i<a;i++)
{if(i&&p[i].first!=p[i-1].first)w++;l[p[i].second]=w;}return l;}
*/
Vi vis(Vi &v){Vi S(v.size()+1);rep(i,1,S.size())S[i]+=v[i-1]+S[i-1];return S;}

//const int MOD = 998244353;
const int MOD = 1000000007;
const double EPS = 1e-10;

void init(){cin.tie(0);cout.tie(0);ios::sync_with_stdio(0);
cout<<fixed<<setprecision(12);//mint::set_mod(MOD);
}

/************************************ START ************************************/

void sol() {
  int n,m;cin >> n >> m;
  Vi a(n),x(m);Vin(a);Vin(x);
  int sum = 0;
  rep(i,0,n) {
    sum += a[i];
  }
  Vi b = vis(a);
  int maxx = -INF;
  rep(i,0,b.size()) {
    chmax(maxx,b[i]);
    b[i] = maxx;
  }
  //cout << b << endl;
  Vi pre(m);
  rep(i,0,m) {
    if(sum <= 0) {
      int ans = SMALLER(b,x[i]);
      if(ans > n) pre[i] = -1;
      else pre[i] = ans-1;
    }
    else {
      int ans = 0;
      int kai = 0,sa = 0;
      if(x[i] > maxx) {
        sa = x[i]-maxx;
        kai = dem(sa,sum);
        ans += kai*n;
        x[i] -= kai*sum;
      }
      ans += SMALLER(b,x[i])-1;
      pre[i] = ans;
    }
  }
  cout << pre << endl;
}

signed main() {
  init();
  int q = 1;
  cin >> q;
  while(q--) sol();
  return 0;
}