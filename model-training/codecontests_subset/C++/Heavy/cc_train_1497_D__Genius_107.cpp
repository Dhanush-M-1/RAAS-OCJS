#include <bits/stdc++.h>
#define ll long long
#define endl "\n"
#define pb push_back
#define all(a) (a).begin(),(a).end()
#define F first
#define S second
#define rep(i,x,y) for(ll i=x;i<y;i++)
#define N 100001
using namespace std;
void solve()
{
    ll n; cin>>n;
    vector<ll> tag(n),s(n),dp(n,0LL);
    rep(i,0,n) cin>>tag[i]; rep(i,0,n) cin>>s[i];
    rep(i,1,n)
    {
        for(int j=i-1;j>=0;j--)
        {
            ll bro=0;
            if(tag[j]!=tag[i])
            {
                bro=dp[i]+abs(s[i]-s[j]);
                dp[i]=max(dp[i],dp[j]+abs(s[i]-s[j]));
                dp[j]=max(dp[j],bro);
            }
        }
    }
    cout<<*(max_element(all(dp)))<<endl;

}
int main() {
  ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
  int t=1;
  cin>>t;
  for(int i=1;i<=t;i++)
  {
      solve();
  }
  return 0;
}
