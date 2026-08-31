#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define rep(i,a) for(int i=0;i<(a);i++)
const ll MOD=1000000007;

int main(){
  ll X; int K; cin>>X>>K;
  set<pair<ll,ll> > st;
  rep(i,K){
    ll t; cin>>t;
    st.insert(make_pair(t,-1));
  }
  int Q; cin>>Q;
  rep(i,Q){
    ll t,a; cin>>t>>a;
    st.insert(make_pair(t,a));
  }
  bool inc=0;
  ll pre=0, a=0,b=X,c=0;
  for(auto s:st){
    ll t=s.first, x=s.second;
    ll dt=t-pre;
    if(inc){
      c+=dt;
      if(b+c>X) b=X-c;
      if(a>b) a=b;
    }else{
      c-=dt;
      if(a+c<0) a=-c;
      if(a>b) b=a;
    }
    if(x==-1) inc=!inc;
    else cout<<max(a,min(b,x))+c<<endl;
    pre=t;
  }
  return 0;
}
