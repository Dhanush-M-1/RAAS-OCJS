#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool read(T &num) {
  char in;
  bool IsN = false;
  while (in = getchar(), in != '-' && (in < '0' || in > '9'))
    if (in == EOF) return false;
  in == '-' ? (IsN = true, num = 0) : num = in - '0';
  while (in = getchar(), in >= '0' && in <= '9') num = num * 10 + in - '0';
  return IsN ? num = -num : num, true;
}
const int maxn = 2e5 + 7;
const int inf = 2e9 + 7;
const int mod = 1e9 + 7;
stack<int> tree;
vector<int> edge[maxn];
int deg[maxn];
vector<int> ans;
int fa[maxn], vis[maxn];
void dfs(int u, int p) {
  tree.push(u);
  fa[u] = p;
  for (int i = (0); i < (edge[u].size()); i++) {
    if (edge[u][i] != p) dfs(edge[u][i], u);
  }
}
void gao(int u) {
  ans.push_back(u);
  vis[u] = 1;
  for (int i = (0); i < (edge[u].size()); i++) {
    int v = edge[u][i];
    deg[v]--;
    if (v == fa[u]) continue;
    if (vis[v]) continue;
    if (deg[v] % 2 == 0) gao(v);
  }
}
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int root;
  for (int i = (1); i < (n + 1); i++) {
    int k;
    cin >> k;
    if (k) {
      edge[i].push_back(k);
      edge[k].push_back(i);
      deg[k]++;
      deg[i]++;
    } else
      root = i;
  }
  dfs(root, -1);
  while (!tree.empty()) {
    int u = tree.top();
    tree.pop();
    if (deg[u] % 2 == 0) {
      gao(u);
    }
  }
  if (ans.size() == n) {
    cout << "YES" << endl;
    for (int i = (0); i < (ans.size()); i++) cout << ans[i] << endl;
  } else
    cout << "NO" << endl;
  return 0;
}
