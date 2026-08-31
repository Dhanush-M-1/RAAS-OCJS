#include <bits/stdc++.h>
using namespace std;
const int N = (int)1e5 + 50;
int n, m;
vector<int> G[N];
int vis[N], dep[N];
int tin[N], tout[N], tim;
int up[N][2];
int gd[N], par[N];
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
void dfs1(int v) {
  vis[v] = 1;
  tin[v] = tim++;
  for (int nxt : G[v]) {
    if (!vis[nxt]) dfs1(nxt);
  }
  tout[v] = tim - 1;
}
bool check(int root) {
  bool good = true;
  tim = 0;
  fill(vis, vis + n, 0);
  dfs1(root);
  function<void(int)> dfs = [&](int v) {
    vis[v] = true;
    for (int nxt : G[v]) {
      if (vis[nxt] && !(tin[nxt] <= tin[v] && tout[v] <= tout[nxt])) {
        good = false;
      }
      if (!vis[nxt]) dfs(nxt);
    }
  };
  fill(vis, vis + n, 0);
  dfs(root);
  return good;
}
void dfs2(int v, int d) {
  vis[v] = 1;
  dep[v] = d;
  up[v][0] = up[v][1] = -1;
  function<void(int)> add = [&](int nxt) {
    if (nxt == -1 || dep[nxt] >= dep[v]) return;
    for (int i = 0; i < 2; i++) {
      if (up[v][i] == -1) {
        up[v][i] = nxt;
        break;
      }
      if (dep[nxt] < dep[up[v][i]]) swap(nxt, up[v][i]);
    }
  };
  for (int nxt : G[v]) {
    if (vis[nxt])
      add(nxt);
    else {
      dfs2(nxt, d + 1);
      add(up[nxt][0]);
      add(up[nxt][1]);
    }
  }
  gd[v] = (up[v][1] == -1);
  par[v] = up[v][0];
}
void dfs3(int v) {
  vis[v] = 1;
  if (par[v] != -1 && !gd[par[v]]) gd[v] = 0;
  for (int nxt : G[v]) {
    if (!vis[nxt]) dfs3(nxt);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> m;
    for (int i = 0; i < (n); ++i) G[i].clear();
    for (int i = 0; i < (m); ++i) {
      int a, b;
      cin >> a >> b;
      a--, b--;
      G[a].push_back(b);
    }
    tim = 0;
    int root = -1;
    vector<int> idx(n, 0);
    for (int i = 0; i < (n); ++i) idx[i] = i;
    shuffle(begin(idx), end(idx), rng);
    for (int i = 0; i < min(100, (int)(idx).size()); i++) {
      if (check(idx[i])) {
        root = idx[i];
        break;
      }
    }
    if (root == -1) {
      cout << -1 << '\n';
      continue;
    }
    fill(vis, vis + n, 0);
    dfs2(root, 0);
    fill(vis, vis + n, 0);
    dfs3(root);
    vector<int> res;
    for (int i = 0; i < (n); ++i)
      if (gd[i]) res.push_back(i);
    if ((int)(res).size() * 5 < n)
      cout << -1 << "\n";
    else {
      for (int x : res) cout << x + 1 << " ";
      cout << '\n';
    }
  }
}
