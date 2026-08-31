#include<bits/stdc++.h>
#define ll long long 
#define rep(i,n) for(ll i=0;i<n;i++)
using namespace std;
signed main(){
  ll n,m;
  ll a[100000],b[100000],c[100000],d[100000],sum[100000];
  cin>>n>>m;
  vector<pair<ll,ll> > pp(m);
  rep(i,n) cin>>a[i]>>b[i];
  rep(i,m) cin>>c[i]>>d[i];
  rep(i,n){
    rep(j,m){
      sum[j] = abs(a[i]-c[j])+abs(b[i]-d[j]);
      pp[j] = make_pair(sum[j],j+1);
    }
    sort(pp.begin(),pp.end());
    cout<<pp[0].second<<"\n";
  }
  return 0;
}