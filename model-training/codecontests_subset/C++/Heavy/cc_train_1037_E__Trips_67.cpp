#include <bits/stdc++.h>
using namespace std;
const long long linf = 1LL << 62;
const int iinf = 1000000009;
const double dinf = 1e17;
const int Mod = 1e9 + 9;
const int maxn = 1000005;
set<pair<int, int> > s, sp;
int n, m, k, u, v;
int mp[maxn], rt;
pair<int, int> sd[maxn], ds[maxn];
vector<int> vp[200005];
void up(int x) {
  for (int i = 1; i <= vp[x].size(); i++) {
    if (s.count(make_pair(vp[x][i - 1], x))) {
      sp.erase(make_pair(mp[vp[x][i - 1]], vp[x][i - 1]));
      mp[vp[x][i - 1]]--;
      sp.insert(make_pair(mp[vp[x][i - 1]], vp[x][i - 1]));
      s.erase(make_pair(vp[x][i - 1], x));
      s.erase(make_pair(x, vp[x][i - 1]));
    }
  }
}
void del() {
  set<pair<int, int> >::iterator it;
  while (1) {
    rt = 0;
    for (it = sp.begin(); it != sp.end(); it++) {
      if (((*it).first) >= k) break;
      ds[rt++] = (*it);
    }
    if (!rt) break;
    for (int i = 0; i <= rt - 1; i++) sp.erase(ds[i]), up(ds[i].second);
  }
}
void del(int i) {
  if (s.count(sd[i])) {
    s.erase(sd[i]);
    u = sd[i].first;
    v = sd[i].second;
    s.erase(make_pair(v, u));
    sp.erase(make_pair(mp[u], u));
    sp.insert(make_pair(--mp[u], u));
    sp.erase(make_pair(mp[v], v));
    sp.insert(make_pair(--mp[v], v));
    del();
  }
}
int ans[maxn];
void solve() {
  s.clear();
  ios::sync_with_stdio(false);
  memset(mp, 0, sizeof(mp));
  sp.clear();
  cin >> n >> m >> k;
  for (int i = 1; i <= n; i++) vp[i].clear();
  for (int i = 1; i <= m; i++) {
    cin >> u >> v;
    mp[u]++;
    mp[v]++;
    s.insert(make_pair(u, v));
    s.insert(make_pair(v, u));
    sd[i] = make_pair(u, v);
    vp[v].push_back(u);
    vp[u].push_back(v);
  }
  for (int i = 1; i <= n; i++) sp.insert(make_pair(mp[i], i));
  for (int i = m; i >= 1; i--) {
    del();
    ans[i] = sp.size();
    del(i);
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << endl;
  ;
}
int main() {
  int t = 1;
  while (t--) solve();
  return 0;
}
