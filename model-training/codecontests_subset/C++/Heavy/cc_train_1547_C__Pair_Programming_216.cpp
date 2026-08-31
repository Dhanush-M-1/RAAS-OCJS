//codeforces this templete copied from tenkei before contest
#pragma GCC optimize("Ofast","unroll-loops","omit-frame-pointer","inline")
#pragma GCC option("arch=native","tune=native","no-zero-upper")
#pragma GCC target("avx2")
#include <bits/stdc++.h>
using namespace std;
#define INF 2147483647
#define infL (1LL<<60)
#define inf (1<<30)
#define inf9 (1000000000)
#define MOD 1000000007//998244353//1000000007
#define EPS 1e-9
#define Gr 9.8
#define PI acos(-1)
#define REP(i,n) for(int (i)=0;(i)<(int)(n);(i)++)
#define REQ(i,n) for(int (i)=1;(i)<=(int)(n);(i)++)
#define all(x) (x).begin(),(x).end()
#define lch (rt<<1)
#define rch (rt<<1|1)
#define readmp(n) for(int i=0,u,v;i<n;i++) {scanf("%d%d",&u,&v); mp[u].push_back(v); mp[v].push_back(u);}
typedef  long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef long double ld;
typedef unsigned int uint;
typedef unsigned long long ull;
typedef ll ValType;
template<typename  T> void maxtt(T& t1, T t2) {
    t1=max(t1,t2);
}
template<typename  T> void mintt(T& t1, T t2) {
    t1=min(t1,t2);
}
 
#define MAX (135)
 
bool debug = 0;
 
int dx[4] = {0,1,0,-1}, dy[4] = {1,0,-1,0};
string direc="RDLU";
const ll MOD2 = (ll)MOD * (ll)MOD;
ll ln, lk, lm;
void etp(bool f = 0) {
    puts(f ?"YES" : "NO");
    exit(0);
}
void addmod(int &x, int y, int mod = MOD){
    x+=y; if (x>=mod) x-=mod;
    if(x<0) x+=mod;
    assert(x>=0 && x<mod);
}
void et(int x=-1) {
    printf("%d\n", x); exit(0);
}
ll fastPow(ll x, ll y, int mod=MOD) {
    ll ans = 1;
    while(y>0) {
        if(y&1) ans = (x * ans)%mod;
        x = x*x%mod;
        y>>=1;
    }
    return ans;
}
ll gcd1(ll x, ll y) {
    return y?gcd1(y,x%y):x;
}
double gcd(double a, double b)
{
    if (a < b)
        return gcd(b, a);
 
    // base case
    if (fabs(b) < 0.001)
        return a;
 
    else
        return (gcd(b, a - floor(a / b) * b));
}

void fmain(int tid) {
 ll n,k,m;
    ll a=0,b=0,c=0,f=0,j=0,l=0,i=0,aa=0,bb=0,cc,dd=0,p=0,r=0,d;
    string s;
cin>>n>>a>>b;
vector<ll>v;
vector<ll>va(a);
vector<ll>vb(b);l=n;
for(i=0;i<a;i++)
{
    cin>>va[i];
}
for(i=0;i<b;i++)
{
    cin>>vb[i];

}
r=1;i=0;j=0;
while(r)
{
    if(va[i]<vb[j] && r)
   { while(va[i]<vb[j] && r)
    {
        v.push_back(va[i]);
        i++;
        if(i==a)
        {
            for(j=j;j<b;j++)
            {
                v.push_back(vb[j]);
            }
            r=0;break;
        }

    }
   }
   else if(r)
   { while(va[i]>=vb[j] && r)
    {
        v.push_back(vb[j]);
        j++;
        if(j==b)
        {
            for(i=i;i<a;i++)
            {
                v.push_back(va[i]);
            }
            r=0;break;
        }

    }
   }
}

for(i=0;i<(a+b);i++)
{
     if(v[i]==0)
     {
         l++;
     }
     else if(v[i]>l)
     {
         cout<<"-1"<<endl;return;
     }
}
for(i=0;i<(a+b);i++)
{
    cout<<v[i]<<" ";
}
cout<<endl;



  






 
 

    






 




    
  //  cout<<a<<" "<<j<<" ";

//cout<<"kjfj";

//cout<<a<<" "<<b<<" "<<c;

//vector<ll>v(n);
 
//scanf("%lld",&k);
 
 //scanf("%lld",&r);
//cout<<"error check 1"<<endl;
 
 
 
 
 // scanf("%s",s);
 // vector<vector<int>> v( n+1 , vector<int> (m+1));
 
//cout<<e<<" "<<o<<endl;
 
//cout<<endl;
  //   set<int>s;
 // vector<bool>check(1000000000,false);
 // map<int,int>ma;
//   vector<int>vc;
 //vector<ll>v(n);
  //std::string sa = std::to_string(bb); int to string
 
  // cout<<"error check 1"<<endl;
 
 //PRIME CHECK
//   for(i=2;i*i<=n;i++)
//   {
//        if(check[i])
//        {
//            for(j=i*i;j<=n;j+=i)
//            {
//             check[j]=false;
//            }
//        }   
//   }
  
   //l=s.length();
//   vector<int>av;
//   vector<int>avv;
  //cout<<"error check 2"<<endl;
//   m=*min_element(v.begin(), v.end());
//   //b=accumulate(v.begin(), v.end(), 0);
 
}
 
 
 
 

int main() {
//     ios_base::sync_with_stdio(false);
//   cin.tie(NULL);
    int t=1;
//    init();
 ll a,b,n,bb=0;
 scanf("%d", &t);
    // or
    //t=1;
    //comment input t;
   REQ(i,t) {
        fmain(i);
    }
    return 0;
}