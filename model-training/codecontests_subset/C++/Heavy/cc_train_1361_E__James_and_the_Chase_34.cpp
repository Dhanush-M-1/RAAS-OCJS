#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = -1;
  for (; isdigit(c); c = getchar()) x = x * 10 + c - '0';
  return x * f;
}
const int MAXN = 400010;
const int INF = 1e9;
int T, N, M;
int Node[MAXN << 1], Next[MAXN << 1], Root[MAXN + 1], cnt;
inline void insert(int u, int v) {
  Node[++cnt] = v;
  Next[cnt] = Root[u];
  Root[u] = cnt;
  return;
}
vector<int> vec[MAXN + 1];
bool fnd[MAXN + 1], in[MAXN + 1];
int sz[MAXN + 1];
bool chs[MAXN + 1];
bool vis[MAXN + 1];
inline bool dfs(int k) {
  in[k] = 1;
  fnd[k] = 1;
  for (int x = Root[k]; x; x = Next[x]) {
    int v = Node[x];
    if (fnd[v] && !in[v]) {
      return 0;
    }
    if (!fnd[v] && !dfs(v)) return 0;
  }
  in[k] = 0;
  return 1;
}
int dep[MAXN + 1], mn[MAXN + 1];
inline void dfs2(int k) {
  in[k] = 1;
  fnd[k] = 1;
  sz[k] = 0;
  mn[k] = 0;
  for (int x = Root[k]; x; x = Next[x]) {
    int v = Node[x];
    if (fnd[v]) {
      sz[k]++;
      sz[v]--;
      if (dep[v] < dep[mn[k]]) mn[k] = v;
      continue;
    } else {
      dep[v] = dep[k] + 1;
      dfs2(v), sz[k] += sz[v];
      if (dep[mn[v]] < dep[mn[k]]) mn[k] = mn[v];
    }
  }
  if (dep[mn[k]] < dep[k]) vec[mn[k]].push_back(k);
  in[k] = 0;
  return;
}
inline void dfs3(int k) {
  in[k] = 1;
  fnd[k] = 1;
  if (sz[k] > 1) chs[k] = 0;
  if (!chs[k])
    for (auto v : vec[k]) {
      chs[v] = 0;
    }
  for (int x = Root[k]; x; x = Next[x]) {
    int v = Node[x];
    if (fnd[v]) {
      continue;
    } else
      dfs3(v);
  }
  in[k] = 0;
  return;
}
inline int rnd() {
  long long u = 0;
  for (int i = 1; i <= 9; i++) u = u * 10 + rand() % 9;
  return u;
}
inline void solve() {
  N = read(), M = read();
  for (int i = 1; i <= N; i++) Root[i] = 0, vis[i] = 0, vec[i].clear();
  cnt = 0;
  for (int i = 1; i <= M; i++) {
    int u = read(), v = read();
    insert(u, v);
  }
  int tms = 100;
  int root = -1;
  while (tms--) {
    int u = rnd() % N + 1;
    if (vis[u]) continue;
    vis[u] = 1;
    for (int i = 1; i <= N; i++) in[i] = 0, fnd[i] = 0;
    if (dfs(u)) {
      root = u;
      break;
    }
  }
  if (root == -1) {
    puts("-1");
    return;
  }
  int u = root;
  for (int i = 1; i <= N; i++) in[i] = 0, fnd[i] = 0, dep[i] = mn[i] = 0;
  dep[u] = 1;
  dep[0] = INF;
  dfs2(u);
  for (int i = 1; i <= N; i++) in[i] = 0, fnd[i] = 0, chs[i] = 1;
  dfs3(u);
  int all = 0;
  for (int i = 1; i <= N; i++) all += chs[i];
  if (all * 5 < N) {
    puts("-1");
    return;
  }
  for (int i = 1; i <= N; i++)
    if (chs[i]) printf("%d ", i);
  printf("\n");
}
int main() {
  srand((int)time(0));
  T = read();
  while (T--) solve();
  return 0;
}
