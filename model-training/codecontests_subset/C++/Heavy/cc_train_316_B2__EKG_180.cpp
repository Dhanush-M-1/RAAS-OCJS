#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const double pi = acos(-1.0);
const int maxn = (int)1e5 + 10;
const int mod = (int)1e9;
int fastMax(int x, int y) { return (((y - x) >> (32 - 1)) & (x ^ y)) ^ y; }
int fastMin(int x, int y) { return (((y - x) >> (32 - 1)) & (x ^ y)) ^ x; }
vector<int> G[1005];
int n, m, color[1005], fn[1005], cnt = 0, nxt[1005], flg = 0;
vector<int> v;
priority_queue<int, vector<int>, greater<int> > vc;
void DFS_Visit(int u) {
  if (u == m) {
    flg = 1;
  }
  int i, v, l;
  cnt++;
  color[u] = 1;
  l = G[u].size();
  for (i = 0; i < l; i++) {
    v = G[u][i];
    if (color[v] == 0) {
      DFS_Visit(v);
    }
  }
}
void DFS() {
  int i;
  for (i = 1; i <= n; i++)
    if (color[i] == 0) {
      flg = 0;
      cnt = 0;
      DFS_Visit(i);
      if (flg == 0) v.push_back(cnt);
    }
}
int l;
int dp[1005][1005], cn = 0;
void call(int i, int sz) {
  if (cnt >= cn) return;
  if (dp[sz][i] != -1) return;
  for (int j = i; j < l; j++) {
    if (fn[sz + v[j]] == 0) {
      vc.push(sz + v[j]);
      fn[sz + v[j]] = 1;
      cnt++;
    }
    call(j + 1, sz + v[j]);
  }
  dp[sz][i] = 1;
}
int main() {
  memset(dp, -1, sizeof(dp));
  int i, x, j;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) {
    scanf("%d", &x);
    nxt[i] = x;
    if (x > 0) {
      nxt[i] = x;
      G[i].push_back(x);
      G[x].push_back(i);
    }
    cn++;
  }
  DFS();
  i = 1;
  while (nxt[m]) {
    i++;
    j = m;
    m = nxt[m];
    nxt[j] = 0;
  }
  l = v.size();
  vc.push(i);
  fn[i] = 1;
  cnt = 1;
  call(0, i);
  while (!vc.empty()) {
    int a = vc.top();
    vc.pop();
    printf("%d\n", a);
  }
  return 0;
}
