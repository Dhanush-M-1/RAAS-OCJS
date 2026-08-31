#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 11;
int n, par[maxn], siz[maxn], deg[maxn], odd[maxn];
bool mark[maxn], seen[maxn];
vector<int> g[maxn];
vector<int> q;
void dfs(int u) {
  siz[u] = 1;
  bool ok = 1;
  for (auto x : g[u]) {
    if (x != par[u]) {
      par[x] = u;
      dfs(x);
      siz[u] ^= siz[x];
      if (siz[x]) odd[u]++;
      ok &= siz[x] & 1;
    }
  }
  deg[u] = (int)(g[u]).size() - (u != 0);
  ok &= ((int)(g[u]).size() % 2 == 0);
  if (ok) q.push_back(u);
}
void recheck(int u) {
  int d = deg[u];
  if (u && !mark[par[u]]) d++;
  if (deg[u] == odd[u] && d % 2 == 0) q.push_back(u);
}
int32_t main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  if (n % 2 == 0)
    return cout << "NO" << endl, 0;
  else
    cout << "YES" << endl;
  for (int i = 0; i < n; i++) {
    cin >> par[i];
    par[i]--;
    if (par[i] == -1) continue;
    g[par[i]].push_back(i);
    g[i].push_back(par[i]);
  }
  memset(par, 0, sizeof par);
  dfs(0);
  q.reserve(maxn);
  while (!q.empty()) {
    int now = q.back();
    q.pop_back();
    if (mark[now]) continue;
    mark[now] = 1;
    cout << now + 1 << endl;
    if (now) deg[par[now]]--;
    for (auto x : g[now]) {
      if (!mark[x]) {
        recheck(x);
      }
    }
  }
}
