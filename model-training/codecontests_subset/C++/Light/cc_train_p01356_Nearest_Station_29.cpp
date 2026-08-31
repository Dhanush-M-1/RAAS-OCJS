#include <iostream>
#include <algorithm>
#include <queue>
#define REP(i,n) for(int i=0; i<(int)(n); i++)

typedef long long ll;

using namespace std;

const ll inf = 1ll << 60;

ll mult(ll a, ll b){
  if(inf / a < b) throw 0;
  return a * b;
}

int main(){
  ll n, m, a, b, p, q;
  cin >> n >> m >> a >> b >> p >> q;
  if(a == 1 && b == 1){
    ll tmp = min(n + 1, m / (p + q));
    ll ans = inf;
    for(ll t = max(0ll, tmp - 2); t < min(n + 1, tmp + 2); t++){
      ll tt = t * (p + q);
      ans = min(ans, std::abs(m - tt));
    }
    cout << ans << endl;
    return 0;
  }

  if(n > 40) n = 40;

  vector<ll> v;
  ll aa = 1;
  ll bb = 1;

  try{
    REP(i,n){
      ll val = mult(p, aa) + mult(q, bb);
      if(val <= m + m) v.push_back(val);
      else break;
      aa = mult(aa, a);
      bb = mult(bb, b);
    }
  }catch(int n){}

  vector<ll> as;
  vector<ll> bs;

  n = v.size();

  if(n == 1){
    cout << min(m, std::abs(m - v[0])) << endl;
    return 0;
  }

  REP(i,1<<(n/2)){
    ll tmp = 0;
    REP(j,n/2) if(i & (1 << j)) tmp += v[j];
    as.push_back(tmp);
  }

  REP(i,1<<(n/2 + n%2)){
    ll tmp = 0;
    REP(j,n/2 + n%2) if(i & (1 << j))
      tmp += v[j + n / 2];
    bs.push_back(tmp);
  }

  sort(as.begin(), as.end());
  sort(bs.rbegin(), bs.rend());

  size_t ai = 0, an = as.size() - 1;
  size_t bi = 0, bn = bs.size() - 1;
  ll ans = m;

  while(ai < an || bi < an){
    ll tmp = as[ai] + bs[bi];
    ans = min(ans, std::abs(m - tmp));
    if(tmp > m){
      if(bi != bn) bi++;
      else ai++;
    }else{
      if(ai != an) ai++;
      else bi++;
    }
  }

  cout << ans << endl;

  return 0;
}