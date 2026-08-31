#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
  ll x,k;cin>>x>>k;
  vector<ll> r(k+1);r[0]=0;for(ll i=1;i<=k;i++)cin>>r[i];
  ll d[k],u[k],da[k],ua[k];
  d[0]=0;
  da[0]=0;
  u[0]=x;
  ua[0]=x;
  for(ll i=1;i<=k;i++){
    ll t=r[i]-r[i-1];
    //cout<<t<<endl;
    if(i%2==0){
      if(da[i-1]+t>=x){
        d[i]=x;
        da[i]=x;
        u[i]=x;
        ua[i]=x;
      }
      else{
        da[i]=da[i-1]+t;
        d[i]=d[i-1];
        ua[i]=ua[i-1]+t;
        u[i]=u[i-1];
        if(ua[i]>=x){
          u[i]=u[i-1]-(ua[i]-x);
          ua[i]=x;
        }
      }
    }
    else{
      if(ua[i-1]-t<=0){
        d[i]=0;
        da[i]=0;
        u[i]=0;
        ua[i]=0;
      }
      else{
        da[i]=da[i-1]-t;
        d[i]=d[i-1];
        ua[i]=ua[i-1]-t;
        u[i]=u[i-1];
        if(da[i]<=0){
          d[i]=d[i]-da[i];
          da[i]=0;
        }
      }
    }
  }
  for(ll i=0;i<=k;i++){
    //cout<<d[i]<<" "<<da[i]<<" "<<u[i]<<" "<<ua[i]<<endl;
  }//return 0;
  ll q;cin>>q;
  for(ll i=0;i<q;i++){
    ll t,a;cin>>t>>a;
    ll e=upper_bound(r.begin(),r.end(),t)-r.begin();
    ll now;
    if(a<=d[e-1])now=da[e-1];
    else if(a>=u[e-1])now=ua[e-1];
    else now=a-d[e-1]+da[e-1];
    if(e%2==1){
      now-=t-r[e-1];
      now=max((ll)0,now);
    }
    else{
      now+=t-r[e-1];
      now=min(x,now);
    }
    cout<<now<<endl;
  }
}