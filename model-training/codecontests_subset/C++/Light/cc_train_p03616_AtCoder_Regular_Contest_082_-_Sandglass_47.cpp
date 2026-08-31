#include <bits/stdc++.h>

using namespace std;

typedef long long lli;
typedef double lld;
typedef vector<lli> vll;
typedef vector<bool> vbl;
typedef vector<double> vdl;
typedef vector<vector<lli>> mat;
typedef vector<vdl> mad;
typedef unordered_map<lli,unordered_map<lli,lli>> graph;
typedef complex<double> cmp;
typedef vector<cmp> vcl;

lli x,k;
vll r;
lli q;
vll t,a;

int main(){
  cin >> x >> k;
  r = vll(k+1);
  for(lli i = 1;i <= k;i++) cin >> r[i];
  cin >> q;
  t = a = vll(q);
  for(lli i = 0;i < q;i++) cin >> t[i] >> a[i];
  lli l,u,s;
  l = 0;u = x;s = 0;
  for(lli i = 0,j = 0;i < q;i++){
    while(j+1 <= k && r[j+1] < t[i]){
      if(j%2){
        lli d = min(r[j+1]-r[j],x-l-s);
        u = min(u,x-s-d);
        s += d;
      }else{
        lli d = max(r[j]-r[j+1],-u-s);
        l = max(l,-s-d);
        s += d;
      }
      j++;
    }
    if(j%2){
      lli d = min(t[i]-r[j],x-l-s);
      u = min(u,x-s-d);
      s += d;
    }else{
      lli d = max(r[j]-t[i],-u-s);
      l = max(l,-s-d);
      s += d;
    }
    r[j] = t[i];
    if(a[i] <= l) cout << l+s << endl;
    else if(a[i] >= u) cout << u+s << endl;
    else cout << a[i]+s << endl;
  }


  return 0;

}
