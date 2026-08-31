#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<ll> vll;
int main(){
  ll n,m;
  cin>>n>>m;
  vll a(n),b(n),c(m),d(m);
  for (ll i=0;i<n;i++) cin>>a[i]>>b[i];
  for (ll i=0;i<m;i++) cin>>c[i]>>d[i];
  ll min,index;
  for (ll i=0;i<n;i++) {
    min=1000000000;
    for (ll j=0;j<m;j++) {
      if (min>abs(a[i]-c[j])+abs(b[i]-d[j])) {
        min=abs(a[i]-c[j])+abs(b[i]-d[j]);
        index=j+1;
      }
    }
    cout<<index<<endl;
  }
}