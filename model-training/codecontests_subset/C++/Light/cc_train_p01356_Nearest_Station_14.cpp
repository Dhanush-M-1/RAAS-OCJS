#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll INF = 1LL<<45;
ll Sum[100],n,m,a,b,p,q;

ll calc(ll k){
  ll A = 1,B = 1,res=p+q;
  while(res>0&&res<=INF&&k--)A*=a,B*=b,res=p*A+q*B;
  if(res<0) res = INF;
  return min(INF,res);
}

ll ans = INF;
set<ll> used[101];
void dfs(ll pos,ll sum){
  ans = min(ans,(ll)abs(m-sum));
  if(m<sum||pos==-1||sum>INF||used[pos].count(sum)) return;
  used[pos].insert(sum);
  
  if(Sum[pos]+sum<m){ans=min(ans,m-(Sum[pos]+sum));return;}
  dfs(pos-1,sum+calc(pos));  
  dfs(pos-1,sum);
}

int main(){
  cin>>n>>m>>a>>b>>p>>q;
  Sum[0] = calc(0);
  for(int i=1;i<60;i++)Sum[i]=min(INF,calc(i)+Sum[i-1]);

  if(max(a,b)==1) {
    ll s = abs(m - (m/(p+q))*(p+q));
    ll t = abs(m - (m/(p+q))*(p+q) - (p+q));
    if(m/(p+q)==n) t = INF;
    if(m/(p+q)<=n) cout<<min(s,t)<<endl;
    else cout<< m-(p+q)*n <<endl;
    return 0;
  }
  dfs(min(n-1,50LL),0);
  cout<<ans<<endl;
  return 0;
}