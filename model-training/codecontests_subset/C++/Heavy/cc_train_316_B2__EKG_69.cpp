#include <bits/stdc++.h>
using namespace std;
inline int in() {
  int32_t x;
  scanf("%d", &x);
  return x;
}
inline string get() {
  char ch[1000010];
  scanf("%s", ch);
  return ch;
}
const int MAX_LG = 21;
const int maxn = 2e5 + 100;
const int base = 29;
const int mod = 1e9 + 7;
const int INF = 2e9 + 100;
int nxt[maxn];
int sz[maxn];
int deg[maxn];
bool mark[maxn];
bool dp[maxn];
bool dp2[maxn];
inline int root(int x) { return (nxt[x] == 0 ? x : nxt[x] = root(nxt[x])); }
inline void dfs(int v) {
  mark[v] = true;
  sz[v] = 1;
  if (nxt[v] == 0) return;
  int u = nxt[v];
  if (mark[u])
    sz[v] += sz[u];
  else {
    dfs(u);
    sz[v] += sz[u];
  }
}
int32_t main() {
  int n = in(), id = in();
  for (int i = 1; i <= n; i++) nxt[i] = in(), deg[nxt[i]]++;
  for (int i = 1; i <= n; i++) {
    if (!mark[i]) dfs(i);
  }
  vector<int> vc;
  for (int i = 1; i <= n; i++)
    if (deg[i] == 0 && root(i) != root(id)) vc.push_back(sz[i]);
  dp[0] = true;
  for (int i = 0; i < vc.size(); i++) {
    for (int j = 0; j + vc[i] <= 1000; j++) dp2[j + vc[i]] |= dp[j];
    for (int j = 0; j <= 1000; j++) dp[j] |= dp2[j], dp2[j] = false;
  }
  for (int x = 0; x <= 1000; x++) {
    if (dp[x]) {
      cout << x + sz[id] << "\n";
    }
  }
}
