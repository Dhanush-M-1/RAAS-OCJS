#include<bits/stdc++.h>
using namespace std;
#define ll long long
template <typename Arg1>
//print with endl
void pn(Arg1&& arg1)
{ cout<<arg1<<"\n";}
template <typename Arg1, typename... Args>
void pn(Arg1&& arg1, Args&&... args)
{ cout<<arg1<<"\n"; pn(args...); }
 //print with space
template <typename Arg1>
void ps(Arg1&& arg1)
{ cout<<arg1<<" ";}
template <typename Arg1, typename... Args>
void ps(Arg1&& arg1, Args&&... args)
{ cout<<arg1<<" "; ps(args...); }
 
template <typename Arg1>
void pvs(Arg1&& arg1, ll n)
{ for(ll i=0;i<n;i++)ps(arg1[i]); }
template <typename Arg1>
void pvn(Arg1&& arg1, ll n)
{ for(ll i=0;i<n;i++)pn(arg1[i]); }

ll sum(ll n){
    ll v=0;
    while(n!=0){
        v+=(n%10);
        n/=10;
    }
    return v;
}
 
ll log(ll n, ll b)
{ ll c=0;
  while(n>(b-1))
  { c++; n/=b; } return c; }
#define fast  ios::sync_with_stdio(false); cin.tie(NULL);  cout.tie(NULL);
#define mod 1000000007 //10^9+7
#define st string
#define ull unsigned long long
#define pb push_back
#define mp make_pair
#define vi vector <int>
#define vll vector <long long>
#define f0(i,a) for(i=0;i<a;i++)
#define f1(i,a) for(i=1;i<=n;i++)
#define all(a) a.begin(),a.end()
#define sz(a) a.size()
#define lb lower_bound
#define ub upper_bound
#define pl pair<ll,ll>
#define vpl vector<pl>
#define ff first
#define ss second
#define um unordered_map
#define dsort(v) sort(v); reverse(v);
#define maxall(v) *max_element(all(v))
#define minall(v) *min_element(all(v))
#define gcd(a,b)        __gcd(a,b)
#define lcm(a,b)        a/__gcd(a,b)*b
#define Y               "YES"
#define N               "NO"
#define endl            "\n"
#define debug(x)        cout << #x << " : " << x << nl;
const ll MOD = 998244353;
const ll inf = 1e18;
const ll MAX = 2e5 + 1;
ll GCD(ll a,ll b){
  if(b==0)
    return a;
  else 
    return GCD(b,a%b);
}
ll mulmod(ll x,ll n,ll M)
{
    ll result=1;
    while(n>0)
    {
        if(n% 2 ==1)
            result=(result * x)%M;
        x=(x*x)%M;
        n=n/2;
    }
    return result;
}

/////////////////////////
bool isPowerOfTwo(ll n) 
{ 
    if (n == 0) 
        return 0; 
    while (n != 1) 
    { 
        if (n%2 != 0) 
            return 0; 
        n = n/2; 
    } 
    return 1; 
}
void solve(){
   
   int k,n,m,i,j;
   cin>>k>>n>>m;
   vll a(n),b(m);
   f0(i,n) cin>>a[i];
   f0(i,m) cin>>b[i];
   vll ans;
   i=0,j=0;
   while(i<n && j<m){
    if(a[i]==0 && b[j]==0){
      k+=2;
      ans.pb(a[i]);
      ans.pb(b[j]);
      i++,j++;
    }
    else if(a[i]==0){
      k++;
      ans.pb(a[i]);
      i++;
    }
    else if(b[j]==0){
      k++;
      ans.pb(b[j]);
      j++;
    }
    else{
      if(a[i]<=k){
        ans.pb(a[i]);
        i++;
      }
      else if(b[j]<=k){
        ans.pb(b[j]);
        j++;
      }
      else{
        pn(-1);
        return ;
      }
    }
   }
   if(i!=n){
      while(i<n){
        if(a[i]==0){
          k++;
          ans.pb(a[i]);
          i++;
        }
        else if(a[i]>k){
          pn(-1);
          return ;
        }
        else{
           ans.pb(a[i]);
          i++;
        }
      }
   }
   if(j!=m){
      while(j<m){
        if(b[j]==0){
          k++;
          ans.pb(b[j]);
          j++;
        }
        else if(b[j]>k){
          pn(-1);
          return ;
        }
        else{
           ans.pb(b[j]);
          j++;
        }
      }
   }

   for(int x : ans) ps(x);
    pn("");
   
}
int main(){  
  fast;
  #ifdef Local
    freopen("inp.txt", "r", stdin);
   // freopen("out.txt", "w", stdin);
   #endif
  // solve();/*
  ll t;
  cin>>t;
  for(ll tt=1;tt<=t;tt++)
  {
    // cout<<"Case #"<<tt<<": ";
    solve();
  }
  //*/
}





