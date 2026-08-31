#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int MAXN = 200005;
int n, m, a, b, vis[MAXN], rnd, l;
bool toa, tob;
vector<int> G[MAXN];
void dfs(int id) {
  l++;
  vis[id] = rnd;
  for (auto x : G[id]) {
    if (x == a)
      toa = true;
    else if (x == b)
      tob = true;
    if (x == a || x == b || vis[x] == rnd) continue;
    dfs(x);
  }
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  memset(vis, 0, sizeof(vis));
  rnd = 0;
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= n; ++i) G[i].clear();
    for (int i = 1; i <= m; ++i) {
      int u, v;
      cin >> u >> v;
      G[u].push_back(v);
      G[v].push_back(u);
    }
    rnd++;
    ll cnta, cntb;
    cnta = cntb = 0;
    for (int i = 1; i <= n; ++i) {
      if (vis[i] != rnd && i != a && i != b) {
        toa = tob = false;
        l = 0;
        dfs(i);
        if (toa && tob)
          continue;
        else if (toa)
          cnta += l;
        else if (tob)
          cntb += l;
      }
    }
    cout << cnta * cntb << '\n';
  }
  return 0;
}
