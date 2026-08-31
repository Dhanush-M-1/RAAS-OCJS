#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll mod = 1000000007;
#define RANGE(x) x.begin(),x.end()
void one(){
  
}
int main(){
  std::ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin>>n;
  vector<int> b(n-1);
  vector<int> c(n);
  ll allways= 1;
  for(int i=0;i<n;++i){
    cin>>c[i];
    allways*=c[i];
    allways%=mod;
  }
  for(int i=1;i<n;++i){
    cin>>b[i-1];
  }
  int Q;
  cin>>Q;
  vector<int> bbars(n);
  vector<int> bpre(n);
  bpre[0]=0;
  bbars[0]=0;
  for(int i=1;i<n;++i){
    bpre[i]=bpre[i-1]+b[i-1];
    bbars[i]=bbars[i-1]+bpre[i];
  }
  while(Q-->0){
    int x;
    cin>>x;
    ll offset = 0;
    ll failures = 0;
    vector<ll> curr(1,1);
    for(int k=0; k<n;++k){
      int os = curr.size();
      vector<ll> temp(os+c[k]);
      ll val = 0;
      for(int i=0;i<temp.size();++i){
        if(i>=c[k]+1)val-=curr[i-c[k]-1];
        if(i<os)val+=curr[i];
        temp[i] = val%mod;
      }
      // check if i>0;
      int min =bbars[k] + (k+1)*x;
      if(offset<min){
        curr.clear();
        if(min-offset<temp.size()){
          curr.insert(curr.end(),temp.begin() + min-offset,temp.end());
          offset = min;
        }
      }
      else{
        swap(temp,curr);
      }
    }
    ll res = 0;
    for(ll i:curr){
      res+=i;
    }
    cout<<res%mod<<endl;
  }
  cout<<flush;
}
