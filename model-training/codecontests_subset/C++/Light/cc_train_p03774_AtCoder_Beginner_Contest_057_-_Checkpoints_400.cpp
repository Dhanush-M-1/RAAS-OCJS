#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for (int i = 0; i < (n); i++) 
#define all(v) begin(v),end(v)
using ll = long long;

int main() {
  int n,m;cin>>n>>m;
  vector<int> a(n),b(n),c(m),d(m);
  rep(i,n)cin>>a[i]>>b[i];
  rep(i,m)cin>>c[i]>>d[i];
  rep(i,n){
    int ans,cnt1=1e9;
    rep(j,m){
     int cnt=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(cnt<cnt1){
        cnt1=abs(a[i]-c[j])+abs(b[i]-d[j]);
        ans=j+1;
      }
    }
    cout<<ans<<endl;
  }
}