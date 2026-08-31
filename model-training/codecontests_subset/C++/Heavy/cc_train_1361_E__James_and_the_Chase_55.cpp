#include <bits/stdc++.h>
const int MAXN = 200005;
using namespace std;
int n, m, vis[MAXN], back[MAXN], dep[MAXN], low[MAXN], interest[MAXN];
vector<int> G[MAXN], Gr[MAXN];
mt19937 rng(time(0));
int dfs1(int v, int d) {
  vis[v] = 1;
  dep[v] = d;
  for (int to : G[v]) {
    if (vis[to] == 1) {
      back[v]++;
      if (low[v] == -1 || dep[to] < dep[low[v]]) {
        low[v] = to;
      }
    } else if (vis[to] == 2) {
      return 1;
    } else {
      if (dfs1(to, d + 1)) {
        return 1;
      }
      if (low[v] == -1 || dep[low[to]] < dep[low[v]]) {
        low[v] = low[to];
      }
      back[v] += back[to];
    }
  }
  if (dep[v] == 0) {
    back[v] -= Gr[v].size();
  } else {
    back[v] -= (int)Gr[v].size() - 1;
  }
  vis[v] = 2;
  return 0;
}
int is_interesting(int v) {
  fill(vis, vis + 1 + n, 0);
  fill(back, back + 1 + n, 0);
  fill(dep, dep + 1 + n, 0);
  fill(low, low + 1 + n, -1);
  int res = dfs1(v, 0);
  return res == 0;
}
void dfs2(int v, int p) {
  if (v == p) {
    interest[v] = 1;
  } else {
    interest[v] = (back[v] == 1 && interest[low[v]]);
  }
  for (int to : G[v]) {
    if (dep[to] > dep[v]) {
      dfs2(to, v);
    }
  }
}
void solve() {
  cin >> n >> m;
  vector<int> deck;
  for (int i = 1; i <= n; i++) {
    interest[i] = 0;
    G[i].clear();
    Gr[i].clear();
    deck.push_back(i);
  }
  shuffle(deck.begin(), deck.end(), rng);
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    G[u].push_back(v);
    Gr[v].push_back(u);
  }
  int root = -1;
  for (int i = 0; i < min((int)deck.size(), 200); i++) {
    if (is_interesting(deck[i])) {
      root = deck[i];
      break;
    }
  }
  if (root == -1) {
    cout << "-1\n";
    return;
  }
  dfs2(root, root);
  vector<int> ans;
  for (int i = 1; i <= n; i++) {
    if (interest[i]) {
      ans.push_back(i);
    }
  }
  if (ans.size() * 5 < n) {
    cout << "-1\n";
    return;
  }
  for (int i = 0; i < (int)ans.size(); i++) {
    cout << ans[i] << " \n"[i + 1 == ans.size()];
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int tc;
  cin >> tc;
  while (tc--) {
    solve();
  }
}
