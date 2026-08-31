#include<bits/stdc++.h>
using namespace std;
using Int = long long;
template<typename T1,typename T2> inline void chmin(T1 &a,T2 b){if(a>b) a=b;}
template<typename T1,typename T2> inline void chmax(T1 &a,T2 b){if(a<b) a=b;}

//INSERT ABOVE HERE
signed main(){
  using i128 = __int128_t;
  Int n,m,a,b,p,q;
  cin>>n>>m>>a>>b>>p>>q;
  
  i128 N(n),M(m),A(a),B(b),P(p),Q(q);


  auto calc=[&](i128 a,i128 b)->i128{return a<=b?b-a:a-b;};
  
  if(a==1&&b==1){
    i128 need=M/(P+Q);
    if(need<=N){
      i128 ans=calc(M,need*(P+Q));
      if(need-1>=0) chmin(ans,calc(M,(need-1)*(P+Q)));
      if(need+1<=N) chmin(ans,calc(M,(need+1)*(P+Q)));
      cout<<Int(ans)<<endl;
      return 0;
    }
    cout<<Int(M-N*(P+Q))<<endl;
    return 0;
  }
  
  vector<i128> vs;  
  for(Int i=0;i<n;i++){
    vs.emplace_back(P+Q);
    if(P+Q>M) break;
    P*=A;
    Q*=B;
  }
  
  const Int H = 20;
  i128 ans=M;
  vector<i128> hs;
  
  for(Int bit=0;bit<(1LL<<H);bit++){
    i128 tmp=0;
    for(Int i=0;i<(Int)vs.size();i++){
      if((~bit>>i)&1) continue;
      tmp+=vs[i];
    }
    hs.emplace_back(tmp);
    chmin(ans,calc(M,tmp));
  }
  sort(hs.begin(),hs.end());
  hs.erase(unique(hs.begin(),hs.end()),hs.end());
  
  if(vs.size()>H){
    Int R=vs.size()-H;
    for(Int bit=0;bit<(1LL<<R);bit++){      
      i128 tmp=0;
      for(Int i=H;i<(Int)vs.size();i++){
        if((~bit>>(i-H))&1) continue;
        tmp+=vs[i];
      }
      auto it=upper_bound(hs.begin(),hs.end(),M-tmp);
      if(it!=hs.end()) chmin(ans,calc(M,tmp+*it));
      ++it;
      if(it!=hs.end()) chmin(ans,calc(M,tmp+*it));

      for(Int k=0;k<3;k++){
        if(it!=hs.begin()) --it;
        chmin(ans,calc(M,tmp+*it));
      }
    }
  }
  cout<<(Int)ans<<endl;
  return 0;
}

