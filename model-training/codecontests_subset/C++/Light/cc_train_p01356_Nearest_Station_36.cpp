#include<bits/stdc++.h>
using namespace std;
#define int long long
bool ch(int a,int b){
  int x=1000000000000000LL;
  x/=a;
  x/=b;
  return x==0;
}
signed main(){
  int n,m,a,b,p,q;
  cin>>n>>m>>a>>b>>p>>q;
  if(a==1&&b==1){
    //cout<<m%(p+q)<<endl;
    if(ch(n,p+q)) cout<<min(m%(p+q),(p+q)-m%(p+q))<<endl;
    else{
      int t=n*(p+q);
      if(m>=t) cout<<m-t<<endl;
      else cout<<min(m%(p+q),(p+q)-m%(p+q))<<endl;
    }
    return 0;
  }
  int ans=m;
  int ta=1,tb=1;
  vector<int> v;
  for(int i=0;i<n;i++){
    if(ch(p,ta)) break;
    if(ch(q,tb)) break;
    int t=p*ta+q*tb;
    //cout<<t<<endl;
    if(t<=m) v.push_back(t);
    else{
      ans=min(ans,t-m);
      break;
    }
    if(ch(ta,a)) break;
    if(ch(tb,b)) break;
    ta*=a;tb*=b;
  }
  int x=v.size();
  int y=x/2;
  set<int> s;
  for(int i=0;i<(1<<y);i++){
    int t=0;
    for(int j=0;j<y;j++) if((i>>j)&1) t+=v[j];
    if(t>m){
      ans=min(ans,t-m);
      continue;
    }    
    //cout<<t<<endl;
    s.insert(-t);
    ans=min(ans,m-t);
  }
  
  for(int i=0;i<(1<<(x-y));i++){
    int t=0;
    for(int j=0;j<(x-y);j++) if((i>>j)&1) t+=v[y+j];
    if(t>m){
      ans=min(ans,t-m);
      continue;
    }
    //cout<<t<<endl;
    ans=min(ans,m-t);
    int u=t-m;
    int k=*s.lower_bound(u);
    ans=min(ans,m-(t-k));
  }
  
  s.clear();
  for(int i=0;i<(1<<y);i++){
    int t=0;
    for(int j=0;j<y;j++) if((i>>j)&1) t+=v[j];
    if(t>m){
      ans=min(ans,t-m);
      continue;
    }    
    //cout<<t<<endl;
    s.insert(t);
    ans=min(ans,m-t);
  }
  
  int inf=m*2;
  s.insert(inf);
  for(int i=0;i<(1<<(x-y));i++){
    int t=0;
    for(int j=0;j<(x-y);j++) if((i>>j)&1) t+=v[y+j];
    if(t>m){
      ans=min(ans,t-m);
      continue;
    }
    //cout<<t<<endl;
    ans=min(ans,m-t);
    int v=m-t;
    int l=*s.lower_bound(v);
    if(l!=inf) ans=min(ans,(t+l)-m);
  }
  //assert(ans>=0);
  cout<<ans<<endl;
  return 0;
}