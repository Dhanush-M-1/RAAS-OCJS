#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n,m,a,b,p,q,s[50],g;
vector<ll> v[2];

void dfs(int f,ll pos,ll ss,ll e){
  if(pos==e){
    v[f].push_back(ss);
    return;
  }
  ll ns=s[pos]+ss;
  dfs(f,pos+1,ss,e);
  dfs(f,pos+1,ns,e);
}

int main(){
  cin>>n>>m>>a>>b>>p>>q;
  if(b==1&&a==1){
    if(m/(p+q)>=n)cout<<m-(p+q)*n<<endl;
    else cout<<min(p+q-(m%(p+q)),m%(p+q))<<endl;    
  }
  else{
    for(ll i=0,x=p,y=q;i<n;i++,x*=a,y*=b){
      ll ss=x+y;
      s[g++]=ss;
      if(ss>m)break;
    }
    v[0].push_back(0);
   v[1].push_back(0);
   v[1].push_back(1e16);
    dfs(0,0,0,g/2);
    dfs(1,g/2,0,g);
    ll ans=m;
    sort(v[1].begin(),v[1].end());
    for(int i=0;i<v[0].size();i++){
      int l=0,M,r=v[1].size();
      while(l<r){
	M=(l+r)/2;
	if(v[0][i]+v[1][M]<=m)l=M+1;
	else r=M;
      }
      ans=min(ans,m-v[0][i]-v[1][r-1]);
      ans=min(ans,v[0][i]+v[1][r]-m);
    }
    cout<<ans<<endl;
  }
  return 0;
}