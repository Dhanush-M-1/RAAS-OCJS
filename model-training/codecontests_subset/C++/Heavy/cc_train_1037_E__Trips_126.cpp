#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = double;
using pll = pair<ll, ll>;
using vll = vector<ll>;
using vpll = vector<pll>;
using vvll = vector<vll>;
stack<ll> st;
vector<ll> deg;
vector<vector<ll>> g;
vector<pair<ll, ll>> e;
ll k;
set<pair<ll, ll>> deleted;
ll fixStuff() {
  ll del = 0;
  while (!st.empty()) {
    ll i = st.top();
    st.pop();
    if (deg[i] < 0) continue;
    deg[i] = -1;
    del++;
    for (ll j = 0; j < (ll)g[i].size(); ++j) {
      if (deleted.count(make_pair(i, g[i][j]))) continue;
      if (deleted.count(make_pair(g[i][j], i))) continue;
      deg[g[i][j]]--;
      if (deg[g[i][j]] < k) {
        st.push(g[i][j]);
      }
    }
  }
  return del;
}
int main() {
  ios::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  ll n, m;
  cin >> n >> m >> k;
  deg = vector<ll>(n);
  g = vector<vector<ll>>(n);
  e = vector<pair<ll, ll>>(m);
  for (ll i = 0; i < (ll)m; ++i) {
    ll u, v;
    cin >> u >> v;
    u--;
    v--;
    g[u].push_back(v);
    g[v].push_back(u);
    deg[u]++;
    deg[v]++;
    e[i].first = u;
    e[i].second = v;
  }
  for (ll i = 0; i < (ll)n; ++i)
    if (deg[i] < k) st.push(i);
  vector<ll> res;
  ll cnt = n - fixStuff();
  for (ll i = m - 1; i >= (ll)0; --i) {
    res.push_back(cnt);
    if (deg[e[i].first] < 0 || deg[e[i].second] < 0) continue;
    deg[e[i].first]--;
    deg[e[i].second]--;
    deleted.insert(make_pair(e[i].first, e[i].second));
    if ((deg[e[i].first] < k && deg[e[i].first] >= 0)) st.push(e[i].first);
    if ((deg[e[i].second] < k && deg[e[i].second] >= 0)) st.push(e[i].second);
    if (!st.empty()) cnt -= fixStuff();
  }
  reverse(res.begin(), res.end());
  for (ll i = 0; i < (ll)res.size(); ++i) cout << res[i] << endl;
  return 0;
}
