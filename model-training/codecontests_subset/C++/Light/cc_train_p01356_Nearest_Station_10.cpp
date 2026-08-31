#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll INF=10000000000000000LL;

ll mul(ll a,ll b){
  if(a>INF/b)return INF;
  return a*b;
}

ll n,m,a,b,p,q;

void dfs(ll x,ll sum,vector<ll> &t,vector<ll> &T){
  if(x==(int)t.size()){
    T.push_back(sum);
  }else{
    dfs(x+1,sum,t,T);
    dfs(x+1,min(INF,sum+t[x]),t,T);
  }
}

ll solve(){
  ll MAX=1000000000000LL;
  
  assert( 1<= n &&n <= MAX );
  assert( 1<= m &&m <= MAX );
  assert( 1<= a &&a <= MAX );
  assert( 1<= b &&b <= MAX );
  assert( 1<= p &&p <= MAX );
  assert( 1<= q &&q <= MAX );


  if(a==1 && b==1){
    ll d=p+q;
    ll total=mul(d,n);
    if(total <= m)return m-total;
    return min(m%d,d-m%d);
  }
  
  vector<ll> t, u;
  ll ak=1,bk=1;


  for(int i=0;i<n;i++){
    if(i&1)t.push_back( mul(ak,p) + mul(bk,q) );
    else   u.push_back( mul(ak,p) + mul(bk,q) );
    ak=mul(ak,a);
    bk=mul(bk,b);
    if( i==40 )break;
  }
  
  vector<ll> T,U;
  dfs(0,0,t,T);
  dfs(0,0,u,U);
    
  sort(T.begin(),T.end());
  sort(U.begin(),U.end());
  
  ll res=m;
  for(int i=0;i<(int)T.size();i++){
    ll target=m-T[i];
    int index=lower_bound(U.begin(),U.end(),target)-U.begin();
    for(int j=index-2;j<=index+2;j++){
      if(0<=j && j<(int)U.size()){
        ll c=T[i]+U[j];
        res=min( res,  abs(m-c) );      
      }
    }
  }
  return res;
}

int main(){
  cin>>n>>m>>a>>b>>p>>q;
  cout<<solve()<<endl;
  return 0;
}