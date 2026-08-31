#include"bits/stdc++.h"
#include<chrono>
#define cintie ios_base::sync_with_stdio(false);cin.tie(NULL);
#define pb push_back
#define f first
#define s second
#define all(v) v.begin(),v.end() 
#define getunique(v) {sort(all(v)); v.erase(unique(all(v)), v.end());}
#define vsz(x) ((long long) x.size())
using namespace std;
#define mod 1000000007
typedef long long ll;
typedef long double lld;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<pii> vpi;
typedef vector<pll> vpl;
const lld pi = 3.14159265358979323846;
struct custom_hash {
    static uint64_t splitmix64(uint64_t x) {
        // designed by Sebastiano Vigna and found on Neal's blog
        x += 0x9e3779b97f4a7c15;
        x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
        x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
        return x ^ (x >> 31);
    }

    size_t operator()(uint64_t x) const {
        static const uint64_t FIXED_RANDOM = chrono::steady_clock::now().time_since_epoch().count();
        return splitmix64(x + FIXED_RANDOM);
    }
};
int main(){
  cintie;
  int t=1,kc;
  cin>>t;
  for(kc=1;kc<=t;kc++){
  ll n,m,i,k,j,ans=1;
  cin>>k>>n>>m;
  vi a(n),b(m);
  for(i=0;i<n;i++){
    cin>>a[i];
  }
  for(i=0;i<m;i++){
    cin>>b[i];
  }
  vi sol;
  i=0;j=0;
  while(ans){
      if(i<n && j<m){
          if(a[i]==0){sol.push_back(0);i++;k++;}
          else if(b[j]==0){sol.push_back(0);j++;k++;}
          else{
              if(min(a[i],b[j])>k){ans=0;}
              else if(a[i]<b[j]){sol.push_back(a[i]);i++;}
              else {sol.push_back(b[j]);j++;}
          }
      }
      else if(i<n){
          if(a[i]==0){sol.push_back(0);i++;k++;}
          else if(a[i]>k){ans=0;}
          else{sol.push_back(a[i]);i++;}
      }
      else if(j<m){
          if(b[j]==0){sol.push_back(0);j++;k++;}
          else if(b[j]>k){ans=0;}
          else{sol.push_back(b[j]);j++;}
      }
      else{
          break;
      }
  }
  if(ans){
      for(auto x:sol)cout<<x<<" ";
  }
  else cout<<"-1";
  cout<<"\n";
  
  }
  return 0;
}

