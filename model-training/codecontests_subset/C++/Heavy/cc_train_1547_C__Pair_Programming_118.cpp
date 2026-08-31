#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
#define ld long double
#define pb push_back
#define ppb pop_back
#define ss  second
#define ff first
#define pii pair<int,int>
#define pll pair<ll,ll>
#define dbg(x) cout<<(#x)<<"= {"<<x<<"}\n";
#define sz(s) (int)s.size()
#define all(v) v.begin(),v.end()
#define vi vector<int>
#define vpi vector<pii>
#define mp make_pair
//Constants
int mod= 1e9+7;
int modd=998244353;
const int MAX= 2e5+5;
const int inf= 1e9;
#define start_time()  auto start = chrono::high_resolution_clock::now()
#define stop_time()  auto stop = chrono::high_resolution_clock::now();
#define exec_time() auto duration = chrono::duration_cast<chrono::microseconds>(stop - start);cout << "time:"<<duration.count()/1e6 << " seconds" << endl

                            //*****Functions******//
ll bipow(ll a,ll b)
{ll ans=1;
 while(b)
 {if(b&1)ans=(ans*1LL*a)%mod;a=(a*1LL*a)%mod;b>>=1;}
 return ans;
}

bool isPrime(int x)
{
   if(x==1)return 0;
   else if(x==2 || x==3)return 1;
   if(x%2==0 ||x%3==0)return 0;
   for(int i=5;i*i<=x;i+=6){if(x%i==0 || x%(i+2)==0)return 0;}
  return 1;
}
    //****Modular operations
inline ll add(ll x,ll y){return (x%mod+y%mod)%mod;} 
inline ll sub(ll x,ll y){
 if(x<0)x+=mod;if(y<0)y+=mod;
  return (x%mod-y%mod + mod)%mod;}
inline ll mul(ll x,ll y){return ((x%mod)*(y%mod))%mod;}
inline ll dvd(ll x,ll y){return mul(x,bipow(y,mod-2));}

                      //*****factorial and inverse_factorial*****//
/*
vector<int>fac(MAX),inv_fac(MAX);
 void Factorials()
 {    inv_fac[0]=inv_fac[1]=fac[0]=fac[1]=1;
   for(int i=2;i<MAX;i++)fac[i]=(i*1LL*fac[i-1])%mod;
     for(int i=2;i<MAX;i++)inv_fac[i]=bipow(fac[i],mod-2);     
 }
*/
                            //*****Sieve*****//
/*
int sieve[MAX];
void Sieve(){sieve[1]=1;for(int i=2;i<MAX;i++)if(sieve[i]==0){for(int j=i;j<MAX;j+=i)sieve[j]=i;}}
*/

                          //*****Prime Generate*****//
/*
vector<int>primes;
void PrimeGen(){bool vis[MAX]={0};for(int i=2;i<MAX;i++)if(!vis[i]){primes.pb(i);for(int j=i;j<MAX;j+=i)vis[j]=1;}}
*/
//vector<vector<int>>pf(MAX);


                              //*****DSU*****// 
/*
 int g(int x,vector<int>&p){return p[x]=p[x]==x?x:g(p[x],p);}
 void unn(int a,int b,vector<int>&p,vector<int>&r)
 {
  a=get(a,p),b=get(b,p);
  if(r[a]==r[b])r[a]++;
  if(r[b]>r[a])swap(a,b);
  p[b]=a;
 }
*/

void solve()
{
 int k,n,m;cin>>k>>n>>m;
 int a[n],b[m];
 for(int &x:a)cin>>x;
  for(int &x:b)cin>>x;
  int i=0,j=0;
  int cur=k;
  vector<int>ans;
  while(i<n && j<m)
  {
    if(a[i]==0){ans.pb(0);cur++;i++;}
    else if(b[j]==0){ans.pb(0);cur++;j++;}
    else if(a[i]<=cur){ans.pb(a[i]);i++;}
    else if(b[j]<=cur){ans.pb(b[j]);j++;}
    else {cout<<-1<<endl;return;}
  }
  while(i<n){if(a[i]==0)cur++,ans.pb(0);
        else if(a[i]<=cur)ans.pb(a[i]);
        else {cout<<-1<<endl;return;}
        i++;
  }
  while(j<m){if(b[j]==0)cur++,ans.pb(0);
        else if(b[j]<=cur)ans.pb(b[j]);
        else {cout<<-1<<endl;return;}
        j++;
  }
  for(int &x:ans)cout<<x<<" ";cout<<endl;

}


int main()
{   //Factorials();
   //Sieve();
  //PrimeGen();
  ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);

  //cout<<setprecision(15)<<fixed;
  int tc=1;
  cin>>tc;
   
  while(tc--)
  {
       solve();
  }
  
  return 0;
}