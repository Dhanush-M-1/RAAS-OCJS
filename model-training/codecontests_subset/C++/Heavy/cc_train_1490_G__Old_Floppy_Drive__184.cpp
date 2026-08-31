#include <bits/stdc++.h>
#define watch(x) cout <<(#x)<<" is "<<(x)<<endl
#define debug cout <<"hi"<<endl
#define maxn 3e5+10
#define inf32 0x3f3f3f3f
 
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef long double ld;
typedef pair<ll, ll> pll;
typedef pair<int,int>pii;
const int MOD=1e9+7;
const int INF32=1<<30;
const ll INF64=1LL<<60;
 
void solve(){
     int tc;cin >> tc;
     while(tc--){
        ll n,m;cin >> n >> m;
        vector<ll>a(n),x(m);
        for(int i = 0;i<n;i++) cin >> a[i];
        for(int i = 0;i<m;i++) cin >> x[i];
        vector<ll>pre(n+1,0);
        for(int i = 1;i<=n;i++) pre[i] = pre[i-1]+a[i-1];
        ll cycle = pre[n];
        for(int i = 1;i<=n;i++) pre[i] = max(pre[i],pre[i-1]);
        for(int i = 0;i<m;i++){
            if(cycle<=0&&pre[n]<x[i]){
                cout << -1 <<' ';continue;
            }
 
            ll l = 1,check = 0;ll r = 0;
            if(cycle<=0) r = n-1;
            else if(pre[n]>=1e9) r = n;
            else r = 2e18/cycle+10;
            while(l<=r){
                ll mid = (l+r)/2;
                ll check = (mid/n)*cycle+pre[mid%n];
                if(mid>=n) check = max(check,(mid/n-1)*cycle+pre[n]);
                if(check>=x[i]) r = mid-1;
                else l = mid+1;
            }
            cout << l-1 <<' ';
        }
        cout <<'\n';
     }
}
 
int main(){
  ios_base::sync_with_stdio(0);
  cin.tie(0); cout.tie(0);
  solve();
  return 0;
}