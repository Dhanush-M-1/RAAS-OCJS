#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for (int i = 0; i < (int)(n); i++)
#define ll long long
int main(){
  ll n,m;
  cin >> n >> m;
  vector<ll> a(n),b(n),c(m),d(m);
  rep(i,n){
    cin >> a.at(i) >> b.at(i);
  }
  rep(i,m){
    cin >> c.at(i) >> d.at(i);
  }
  rep(i,n){
    ll sum=1e9+7,ans;
    rep(j,m){
      ll p=abs(a.at(i)-c.at(j))+abs(b.at(i)-d.at(j));
      if(sum>p){
        sum=p;
        ans=j+1;
      }
    }
    cout << ans << endl;
  }
}
      