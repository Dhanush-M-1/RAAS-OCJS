#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<ll, ll> P;

#define fi first
#define se second
#define repl(i,a,b) for(ll i=(ll)(a);i<(ll)(b);i++)
#define rep(i,n) repl(i,0,n)
#define all(x) (x).begin(),(x).end()
#define dbg(x) cout<<#x"="<<x<<endl
#define mmax(x,y) (x>y?x:y)
#define mmin(x,y) (x<y?x:y)
#define maxch(x,y) x=mmax(x,y)
#define minch(x,y) x=mmin(x,y)
#define uni(x) x.erase(unique(all(x)),x.end())
#define exist(x,y) (find(all(x),y)!=x.end())
#define bcnt __builtin_popcount

#define INF 1e18
#define mod 1000000007

ll n,m,a,b,p,q;

int main(){
  cin>>n>>m>>a>>b>>p>>q;
  ll res=m;
  if(a==1&&b==1){
    ll cnt=min(m/(p+q),n);
    minch(res,m-cnt*(p+q));
    cnt=min(cnt+1,n);
    if(cnt*(p+q)-m>=0)minch(res,cnt*(p+q)-m);
    cout<<res<<endl;
    return 0;
  }
  ll crt1=p,crt2=q;
  vector<ll> cs,cs1;
  rep(k,n){
    if(2*m<crt1+crt2)break;
    cs.push_back(crt1+crt2);
    if(2*m/a<crt1||2*m/b<crt2)break;
    crt1*=a;
    crt2*=b;
  }
  ll n1=cs.size()/2;
  ll n2=cs.size()-n1;
  rep(S,1<<n1){
    ll sum=0;
    rep(i,n1){
      if((S>>i)&1)sum+=cs[i];
    }
    cs1.push_back(sum);
  }
  sort(all(cs1));

  rep(S,1<<n2){
    ll sum=0;
    rep(i,n2){
      if((S>>i)&1)sum+=cs[n1+i];
    }
    if(sum>=m){
      minch(res,sum-m);
    }else{
      ll idx=lower_bound(all(cs1),m-sum)-cs1.begin();
      if(idx<cs1.size()){
        minch(res,sum+cs1[idx]-m);
      }
      if(idx>0){
        minch(res,m-(sum+cs1[idx-1]));
      }
    }
  }
  cout<<res<<endl;
  return 0;
}

