#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int lim=1e6;int inf=1e8;
ll mod = 1e9+7;
#define ln '\n'
#define forstl(it,v) for(auto &it: v)
#define fi first
#define se second
#define dbg(args...) { string _s = #args; replace(_s.begin(), _s.end(), ',', ' '); \
stringstream _ss(_s); istream_iterator<string> _it(_ss); err(_it, args); }
void err(istream_iterator<string> it) { cerr<<endl; }
template<typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << "\t"; err(++it, args...);
}
template<typename T1,typename T2>
ostream& operator <<(ostream& c,pair<T1,T2> v){
  c<<"("<<v.fi<<","<<v.se<<")"; return c;
}
template <template <class...> class TT, class ...T>
ostream& operator<<(ostream& out,TT<T...>& c){
    out<<"{ ";
    forstl(x,c) out<<x<<" ";
    out<<"}"; return out;
}

int main()
{
  // ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
  int t; cin>>t;
  while(t--){
    int n, m; cin>>n>>m;
    int a[n];
    for(int i=0;i<n;i++) cin>>a[i]; 
    int x[m];
    for(int i=0;i<m;i++) cin>>x[i];
    pair<ll, int> cum[n];
    cum[0] = make_pair(a[0], 0);
    for(int i=1;i<n;i++) cum[i] = make_pair(cum[i-1].first+a[i], i);
    ll loopsum = cum[n-1].first;
    int endzeros = 0;
    for(int i=n-1;i>=0;i--){
      if(a[i]==0) endzeros++;
      else break;
    }
    sort(cum, cum+n);
    int minind[n];
    minind[n-1] = cum[n-1].second;
    for(int i = n-2;i>=0;i--){
      minind[i] = min(minind[i+1], cum[i].second);
    }
    for(int i=0;i<m;i++){
      if(x[i] > cum[n-1].first){
        if(loopsum <= 0) cout<<-1<<" ";
        else{
          ll q = ceil((x[i]-cum[n-1].first)/((double)loopsum));
          ll rem = x[i] - loopsum*q;
          int ind = lower_bound(cum, cum+n, make_pair(rem, -1)) - cum;
          ll ans = q*n + minind[ind];
          cout<<ans<<" ";
        }
      }else{
        int ind = lower_bound(cum, cum+n, make_pair((ll)x[i], -1)) - cum;
        cout<<minind[ind]<<" ";
      }
    }
    cout<<ln;
  }
}